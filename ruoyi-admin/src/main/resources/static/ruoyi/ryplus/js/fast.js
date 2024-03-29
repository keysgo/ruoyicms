
var GlobalConfig={
    msg_type:"layer",//消息提示样式，可选的有toastr和layer
    msg_type_toastr:"toastr",
    msg_type_layer:"layer",
}
/**
 * 判断非空
 * @param val
 * @returns {Boolean}
 */
function isEmpty(val) {
    val = $.trim(val);
    if (val == null)
        return true;
    if (val == undefined || val == 'undefined')
        return true;
    if (val == "")
        return true;
    if (val == "null")
        return true;
    if (val.length == 0)
        return true;
    if (!/[^(^\s*)|(\s*$)]/.test(val))
        return true;
    return false;
}
function isNotEmpty(val) {
    return !isEmpty(val);
}
/*将后台返回的时间戳id转换成日期字符串*/
function convertTimeUuidToDateStr(id){
    id = id+"";
    var year = "20"+id.substring(0,2);
    var month = id.substring(2,4);
    var day = id.substring(4,6);
    var hour = id.substring(6,8);
    var min = id.substring(8,10);
    var sec = id.substring(10,12);
    return	year+"-"+month+"-"+day+" "+hour+":"+min+":"+sec;
}

function setCookie(name, value, days) {
    var date = new Date(),
        expires = "",
        days = Number(days);
    if (days) {
        date.setTime(date.getTime()+(days*24*60*60*1000));
        expires = "; expires="+date.toGMTString();
    }
    document.cookie = name+"="+value+expires+"; path=/";
}
function setCookieSeconds(name, value, seconds) {
    var date = new Date(),
        expires = "",
        days = Number(days);
    if (days) {
        date.setTime(date.getTime()+(seconds*1000));
        expires = "; expires="+date.toGMTString();
    }
    document.cookie = name+"="+value+expires+"; path=/";
}
function getCookie(name){
    //获取cookie字符串
    var strCookie=document.cookie;
    //将多cookie切割为多个名/值对
    var arrCookie=strCookie.split("; ");
    var value="";
    //遍历cookie数组，处理每个cookie对
    for(var i=0;i<arrCookie.length;i++){
        var arr=arrCookie[i].split("=");
        if(name==arr[0]){
            value=arr[1];
            break;
        }
    }
    return value;
}

function deleteCookie(name) {
    var date = new Date();
    date.setTime(date.getTime()-10000); //删除一个cookie，就是将其过期时间设定为一个过去的时间
    document.cookie = name + "= ' ' " + "; expires=" + date.toUTCString()+";path="+"/";
    document.cookie = name + "= ' ' " + "; expires=" + date.toUTCString()+";path="+"/";
}

function isEmail(v) {
    var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if (!myreg.test(v))//对输入的值进行判断
    {
        return false;
    }
    return true;
}
function isQQ(v){
    if(/^[0-9]{5,10}$/.test(v)){
        return true;
    }else{
        return false;
    }
}
//手机号
function isTelePhone(v){
    var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
    if (!myreg.test(pone)) {
        return false;
    } else {
        return true;
    }
}
function  addFav(title,url) {//  加入收藏夹
    if(document.all)
    {
        window.external.addFavorite(url,title);
    }
    else if(window.sidebar)
    {
        window.sidebar.addPanel(title,url,  "" );
    }
}

String.prototype.endsWith = function (str){
    return this.slice(-str.length) == str;
};

$(function(){
    baseMotheds.init();

});
var baseMotheds = function(){
    // lazyLoad
    var lazyLoad = function(){
        try{
            $("img.lazy").lazyload({threshold: 100,effect: "fadeIn"});
        }catch (ex){}
    };
    var imgError = function(){
        document.addEventListener("error", function (e) {
            var elem = e.target;
            if (elem.tagName.toLowerCase() == "img") {
                elem.src = "/resources/myblog/assets/i/f10.jpg";
            }
        }, true);
    };
    var imgNull = function(){
        $('img.lazy').each(function(){
            var _newImg = '/forum/images/header.jpeg';
            var _thisSrc = $(this).attr('src');
            if(_thisSrc == '' || _thisSrc == undefined){
                $(this).attr('src',_newImg);
            }
        });
        document.addEventListener("error", function (e) {
            var elem = e.target;
            if (elem.tagName.toLowerCase() == "img") {
                elem.src = "/resources/myblog/assets/i/f10.jpg";
            }
        }, true);
    };
    var goTop=function(){// 返回顶部
        $('.to-top').toTop({
            autohide: true,//返回顶部按钮是否自动隐藏。可以设置true或false。默认为true
            offset: 100,//页面滚动到距离顶部多少距离时隐藏返回顶部按钮。默认值为420
            speed: 500,//滚动和渐隐的持续时间，默认值为500
            right: 25,//返回顶部按钮距离屏幕右边的距离，默认值为15
            bottom: 50//返回顶部按钮距离屏幕顶部的距离，默认值为30
        });
    }
    var bubble=function () {
        if ($.bubble) {
            $.bubble.init();
        }
    }
    var websocket=function(){
        if ($.websocket) {

            var host=window.location.host;
            host="ws://" + host + "/websocket";
            /*var sitePath = "http://localhost:9080/";
            var schemes = {"http://": "ws://", "https://": "wss://"};
            var host, scheme;

            $.each(schemes, function (k, v) {
                if (sitePath.startsWith(k)) {
                    scheme = v;
                    host = sitePath.replaceAll(k, "");
                    return false;
                }
            });
            // 默认取8085端口的程序
            host = host || document.domain + ":9080";*/
            $.websocket.open({
                host: host,
                reconnect: true,
                callback: function (result) {
                    var resultJson = JSON.parse(result);
                    wesocketMsgResolver[resultJson["fun"]](resultJson["msg"]);
                }
            });
        }
    }
    return{
        init: function(){
            lazyLoad();
            //imgError();
            //imgNull();
            goTop();
            //bubble();
            //websocket();
        }
    }
}();
/**
 * websocket消息解析器
 *
 * @type {{online: wesocketMsgResolver.online}}
 */
var wesocketMsgResolver = {
    online: function (value) {
        value && $(".onlineNum").html(value);
    },
    notification: function (value) {
        value && Fast.msg_info(decodeURIComponent(value));
    }
};


//  格式化文件大小
function renderFileSize(value){
    if(null==value||value==''){
        return "0 Bytes";
    }
    var unitArr = new Array("Bytes","KB","MB","GB","TB","PB","EB","ZB","YB");
    var index=0,
        srcsize = parseFloat(value);
    index=Math.floor(Math.log(srcsize)/Math.log(1024));
    var size =srcsize/Math.pow(1024,index);
    //  保留的小数位数
    size=size.toFixed(2);
    return size+unitArr[index];
}
function getCookie(name){
    //获取cookie字符串
    var strCookie=document.cookie;
    //将多cookie切割为多个名/值对
    var arrCookie=strCookie.split("; ");
    var value="";
    //遍历cookie数组，处理每个cookie对
    for(var i=0;i<arrCookie.length;i++){
        var arr=arrCookie[i].split("=");
        if(name==arr[0]){
            value=arr[1];
            break;
        }
    }
    return value;
}
function randomInt(min, max){
    return Math.floor((Math.random() * max) + min);
}

(function ($) {
    $.extend({
        layer:{
            msg: function(content, type,options) {
                if(isNotEmpty(options)&&isNotEmpty(options.oparent)){
                    var opts={ icon: type, time: 2000, shift: randomInt(1, 5) };
                    if(isNotEmpty(options)){
                        opts= $.extend(opts,options);
                    }
                    if (isNotEmpty(type)) {
                        opts.icon=type;
                    }
                    options.oparent.layer.msg(content,opts);
                }else{
                    var opts={ icon: type, time: 2000, shift: randomInt(1, 5) };
                    if(isNotEmpty(options)){
                        opts= $.extend(opts,options);
                    }
                    if (isNotEmpty(type)) {
                        opts.icon=type;
                    }
                    layer.msg(content,opts);
                }

            },
            msg_top:function(content, type,options){
                options=$.extend({offset:1},options);
                $.layer.msg(content, type,options);
            },
            msg_right:function(content,oparent){
                $.layer.msg(content, 1,{oparent:oparent});
            },
            msg_wrong:function(content,oparent){
                $.layer.msg(content, 2,{oparent:oparent});
            },
            msg_ask:function(content,oparent){
                $.layer.msg(content, 3,{oparent:oparent});
            },
            msg_locked:function(content,oparent){
                $.layer.msg(content, 4,{oparent:oparent});
            },
            msg_cry:function(content,oparent){
                $.layer.msg(content, 5,{oparent:oparent});
            },
            msg_smile:function(content,oparent){
                $.layer.msg(content, 6,{oparent:oparent});
            },
            msg_warning:function(content,oparent){
                $.layer.msg(content, 7,{oparent:oparent});
            },
            alert:function(content,options){
                var callback;
                if(isNotEmpty(options)&&typeof (options.callback)=='function'){
                    callback=options.callback;
                }
                if(typeof options=='function'){
                    callback=options;
                }
                var opts = $.extend({
                    //skin:layer_skin,
                    shade: [0.1,'#000'],
                    shadeClose: true
                    // shift:2/*动画类型2为从下向上出现*/
                },options);

                layer.alert(content, opts,callback );
            },
            alert_right:function(content,options){
                options=$.extend({icon:1},options);
                $.layer.alert(content,options);
            },
            alert_wrong:function(content,options){
                options=$.extend({icon:2},options);
                $.layer.alert(content,options);
            },
            alert_ask:function(content,options){
                options=$.extend({icon:3},options);
                $.layer.alert(content,options);
            },
            alert_locked:function(content,options){
                options=$.extend({icon:4},options);
                $.layer.alert(content,options);
            },
            alert_cry:function(content,options){
                options=$.extend({icon:5},options);
                $.layer.alert(content,options);
            },
            alert_smile:function(content,options){
                options=$.extend({icon:6},options);
                $.layer.alert(content,options);
            },
            alert_warning:function(content,options){
                options=$.extend({icon:7},options);
                $.layer.alert(content,options);
            },
            //询问框
            confirm:function(content,callbackOK,callbackCancel){
                var options={
                    btn: ['确定','取消'],
                    icon: 3,
                    title:'询问',
                    shade: [0.3,'#000']
                };
                layer.confirm(content,options , function (index) {
                        layer.close(index);
                        if(typeof(callbackOK)=='function' ){
                            callbackOK();
                        }
                    }, callbackCancel
                );
            },
            //打开一个Iframe页面
            open_page: function (title, url,options) {
                var w,h;
                if(isEmpty(options)||isEmpty(options.w)){
                    w="70%";
                }else{
                    w=options.w;
                }
                if(isEmpty(options)||isEmpty(options.h)){
                    h="70%";
                }else{
                    h=options.h;
                };
                if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
                    w = 'auto';
                    h = 'auto';
                }
                var  opts={
                    type: 2,
                    area: [w, h],
                    fix: false, //不固定
                    maxmin: true,
                    shadeClose:true,
                    shade:0.4,
                    btn: ['确定', '关闭'],
                    title: title,
                    yes: function(index,layero){
                        var body = layer.getChildFrame('body', index);
                        var iframeWin = window[layero.find('iframe')[0]['name']];
                        iframeWin.save();
                    },
                    content: url
                };
                if(isNotEmpty(options)&&isNotEmpty(options.endCallBack)&& typeof (options.endCallBack)=='function'){
                    $.extend(opts,{end:endCallBack});
                }
                opts= $.extend(opts,options);
                if (isEmpty(title)) {
                    opts.title=false;
                };
                if(isNotEmpty(options)&&isNotEmpty(options.oparent)){
                    options.oparent.layer.open(opts);
                }else{
                    layer.open(opts);
                }
            },
            //打开即全屏
            open_page_full: function (title, url,options) {
                var w,h;
                if(isEmpty(options)||isEmpty(options.w)){
                    w="70%";
                };
                if(isEmpty(options)||isEmpty(options.h)){
                    h="70%";
                };
                if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
                    w = 'auto';
                    h = 'auto';
                }
                var  opts={
                    type: 2,
                    area: [w, h],
                    fix: false, //不固定
                    maxmin: true,
                    shadeClose:true,
                    shade:0.4,
                    btn: ['确定', '关闭'],
                    title: title,
                    yes: function(index,layero){
                        var body = layer.getChildFrame('body', index);
                        var iframeWin = window[layero.find('iframe')[0]['name']];
                        iframeWin.save();
                    },
                    content: url
                };
                if(isNotEmpty(options)&&isNotEmpty(options.endCallBack)&& typeof (options.endCallBack)=='function'){
                    $.extend(opts,{end:endCallBack});
                }
                opts= $.extend(opts,options);
                if (isEmpty(title)) {
                    opts.title=false;
                };
                var index;
                if(isNotEmpty(options)&&isNotEmpty(options.oparent)){
                    index=options.oparent.layer.open(opts);
                }else{
                    index=layer.open(opts);
                }
                layer.full(index);
            },
            // 打开遮罩层
            loading: function () {
                var loadType=1;
                var opts= {
                    area:['37px','37px'],
                    shade: [0.1,'#000']
                };
                layer.load(loadType,opts);
            },
            // 关闭遮罩层
            closeLoading: function () {
                setTimeout(function(){
                    //layer.closeAll(); //疯狂模式，关闭所有层
                    //layer.closeAll('dialog'); //关闭信息框
                    //layer.closeAll('page'); //关闭所有页面层
                    //layer.closeAll('iframe'); //关闭所有的iframe层
                    layer.closeAll('loading'); //关闭加载层
                    //layer.closeAll('tips'); //关闭所有的tips层
                }, 50);
            },
            tips:function(msg,attachment,position){
                layer.tips(msg, attachment, {
                    tips: [position, '#3595CC'],
                    time:5000
                });
            }

        }
        ,
        toastr:{
            config:{
                "closeButton": true,
                "debug": false,
                "newestOnTop": false,
                "progressBar": false,
                "positionClass": "toast-top-right",
                "preventDuplicates": false,
                "onclick": null,
                "showDuration": "300",
                "hideDuration": "1000",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            },
            config_center:{
                "closeButton": true,
                "debug": false,
                "newestOnTop": false,
                "progressBar": false,
                "positionClass": "toast-center-center",
                "preventDuplicates": false,
                "onclick": null,
                "showDuration": "300",
                "hideDuration": "1000",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            },
            config_top_center:{
                "closeButton": true,
                "debug": false,
                "newestOnTop": false,
                "progressBar": false,
                "positionClass": "toast-top-center",
                "preventDuplicates": false,
                "onclick": null,
                "showDuration": "300",
                "hideDuration": "1000",
                "timeOut": "5000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            },
            config_top_center_long_time:{
                "closeButton": true,
                "debug": false,
                "newestOnTop": false,
                "progressBar": false,
                "positionClass": "toast-top-center",
                "preventDuplicates": false,
                "onclick": null,
                "showDuration": "300",
                "hideDuration": "1000",
                "timeOut": "500000000",
                "extendedTimeOut": "1000",
                "showEasing": "swing",
                "hideEasing": "linear",
                "showMethod": "fadeIn",
                "hideMethod": "fadeOut"
            },
            info:function(msg,title){
                toastr.options=$.toastr.config;
                toastr.info(msg,title);
            },
            info_center:function(msg,title){
                toastr.options=$.toastr.config_center;
                toastr.info(msg,title);
            },
            info_top_center:function(msg,title){
                toastr.options=$.toastr.config_top_center;
                toastr.info(msg,title);
            },
            success:function(msg,title){
                toastr.options=$.toastr.config;
                toastr.success(msg,title);
            },
            warning:function(msg,title){
                toastr.options=$.toastr.config;
                toastr.warning(msg,title);
            },
            error_top_center:function(msg,title){
                toastr.options=$.toastr.config_top_center;
                toastr.error(msg,title);
            },
            error:function(msg,title){
                toastr.options=$.toastr.config;
                toastr.error(msg,title);
            },
            success_top_center_long_time:function(msg,title){
                toastr.options=$.toastr.config_top_center_long_time;
                toastr.success(msg,title);
            }
        }
    });

    var Fast={
        confirm:function(title,okFunction,cancelFunction){
            var index = layer.confirm(
                title,
                {icon: 3, title:"询问", shadeClose: false, btn: ["确定","取消"]},
                function () {
                    if(typeof okFunction=='function'){
                        okFunction();
                    }
                    layer.close(index);
                },function(){
                    if(typeof cancelFunction=='function'){
                        cancelFunction();
                    }
                    layer.close(index);
                }
            );
            return index;
        },
        msg:function(msg){
            if(GlobalConfig.msg_type==GlobalConfig.msg_type_toastr){
                $.toastr.info(msg);
            }else{
                layer.msg(msg);
            }
        },
        msg_success:function(msg){
            if(GlobalConfig.msg_type==GlobalConfig.msg_type_toastr){
                $.toastr.success(msg);
            }else{
                $.layer.msg_right(msg);
            }
        },
        msg_error:function(msg){
            if(GlobalConfig.msg_type==GlobalConfig.msg_type_toastr){
                $.toastr.error(msg);
            }else{
                $.layer.msg_wrong(msg);
            }
        },
        msg_warning:function(msg){
            if(GlobalConfig.msg_type==GlobalConfig.msg_type_toastr){
                $.toastr.warning(msg);
            }else{
                $.layer.msg_warning(msg);
            }
        },
        msg_info:function(msg){
            if(GlobalConfig.msg_type==GlobalConfig.msg_type_toastr){
                $.toastr.info(msg);
            }else{
                $.layer.msg_warning(msg);
            }
        },
        msg_info_center:function(msg){
            if(GlobalConfig.msg_type==GlobalConfig.msg_type_toastr){
                $.toastr.info_center(msg);
            }else{
                $.layer.msg_warning(msg);
            }
        },
        isExist:function (url){
            var flag=false;
            if(url.indexOf("http")==-1){
                var host=window.location.host;
                var protocol=window.location.protocol;
                url=protocol+"//"+host+url;
            }
            $.ajax({async:false,type:"GET",url:url,error:function(data,status){
                    //这里需要覆盖ajaxSetup中的方法
                },complete:function(XMLHttpRequest, textStatus) {
                    if(textStatus=="success"){
                        flag= true;
                    }
                }
            });
            return flag;
        },
        /*changeUrlArg:function(url, arg, val){//有bug,不用了
            var pattern = arg+'=([^&]*)';
            var replaceText = arg+'='+val;
            return url.match(pattern) ? url.replace(eval('/('+ arg+'=)([^&]*)/gi'), replaceText) : (url.match('[\?]') ? url+'&'+replaceText : url+'?'+replaceText);
        },*/
        getUri:function(){
            var url=  window.location.href;
            var host=window.location.host;
            var protocol=window.location.protocol;
            var uri=url.replace(protocol+"//"+host,"");
            if(uri.indexOf("?")>0){
                uri=uri.substring(0,uri.indexOf("?"));
            }
            return uri;
        },
        confirmSuccess: function (content, callBack) {
            layer.confirm(content, {
                icon: 1,
                title: "系统提示",
                btn: ['确认']
            }, function (index) {
                layer.close(index);
                callBack(true);
            });
        },
        confirmWaring: function (content, callBack) {
            layer.confirm(content, {
                icon: 0,
                title: "系统提示",
                btn: ['确认']
            }, function (index) {
                layer.close(index);
                callBack(true);
            });
        },
        // 弹出层指定宽度
        openNoBtn: function (title, url, width, height, endCallBack) {
            //如果是移动端，就使用自适应大小弹窗
            if ($.common.isMobile()) {
                width = 'auto';
                height = 'auto';
            }
            if ($.common.isEmpty(title)) {
                title = false;
            }
            if ($.common.isEmpty(url)) {
                url = "/404.html";
            }
            if ($.common.isEmpty(width)) {
                width = 800;
            }
            if ($.common.isEmpty(height)) {
                height = ($(window).height() - 50);
            }

            layer.open({
                type: 2,
                area: [width + 'px', height + 'px'],
                fix: false,
                //不固定
                maxmin: true,
                shade: 0.3,
                title: title,
                content: url,
                // 弹层外区域关闭
                shadeClose: false,
                end: endCallBack
            });
        },
        openHtml:function (html,width,height,title) {
            if ($.common.isEmpty(html)) {
                html = '<div style="padding:50px;">这是一个非常普通的页面层，请传入自定义的 html!</div>';
            }
            if ($.common.isEmpty(width)) {
                width = 500;
            }
            if ($.common.isEmpty(height)) {
                height = 300;
            }
            if ($.common.isEmpty(title)) {
                title = '温馨提示';
            }
            layer.open({
                type: 1
                ,area: [width + 'px', height + 'px']
                ,title: title
                ,shade: 0.6 //遮罩透明度
                ,maxmin: false //允许全屏最小化
                ,anim: 1 //0-6的动画形式，-1不开启
                ,btn:['确定']
                ,closeBtn: 0
                ,shadeClose: true
                ,content: html
            });
        }
    };
    window.Fast=Fast;
})(jQuery);

(function ($) {
    $.extend({
        websocket: {
            _this: null,
            _initialized: false,
            init: function (options) {
                if (!this.isSupported()) {
                    // console.error('Not support websocket');
                    return;
                }
                var op = $.extend({
                    callback: function () {
                    },
                    host: null,
                    reconnect: false
                }, options);
                if (!op.host) {
                    // console.error("初始化WebSocket失败，无效的请求地址");
                    return;
                }
                try {
                    this._this = new WebSocket(op.host);
                } catch (error) {
                    return;
                }
                this._initialized = true;
                //连接发生错误的回调方法
                this._this.onerror = function () {
                    // console.log("与服务器连接失败...");
                };

                //连接成功建立的回调方法
                this._this.onopen = function (event) {
                    // console.log("与服务器连接成功...");
                };

                //接收到消息的回调方法
                this._this.onmessage = function (event) {
                    // dwz.notification.show({notification: event.data});
                    op.callback(event.data);
                    // console.log("接收到服务器端推送的消息：" + event.data);
                };

                //连接关闭的回调方法
                this._this.onclose = function () {
                    $.websocket._initialized = false;
                    // console.log("已关闭当前链接");
                    if (op.reconnect) {
                        // 自动重连
                        setTimeout(function () {
                            $.websocket.open(op);
                        }, 5000);
                    }
                }
            },
            open: function (options) {
                var op = $.extend({
                    callback: function () {
                    },
                    host: null,
                    reconnect: false
                }, options);

                if (this._initialized) {
                    this.close();
                }
                this.init(options);
                //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
                window.onbeforeunload = function () {
                    // console.log("窗口关闭了");
                    $.websocket.close();
                }
            },
            isSupported: function () {
                return 'WebSocket' in window;
            },
            send: function (message) {
                if (!this._this) {
                    return;
                }
                this._this.send(message);
            },
            close: function () {
                if (!this._this) {
                    return;
                }
                this._this.close();
            }
        }
    });
})(jQuery);
/* 鼠标点击向上冒泡弹出提示动画 */
$.extend({
    bubble: {
        _tip: ['法制', '爱国', '敬业', '诚信', '友善', '富强', '民主', '文明', '和谐', '自由', '平等', '公正'],
        init: function () {
            var bubbleIndex = 0;
            $('body').click(function (e) {
                bubbleIndex = bubbleIndex >= $.bubble._tip.length ? 0 : bubbleIndex;
                if (!e.originalEvent) {
                    return;
                }
                var x = e.originalEvent.x || e.originalEvent.layerX || 0;
                var y = e.originalEvent.y || e.originalEvent.layerY || 0;
                var html = '<span style="position: fixed;z-index:9999;left: ' + x + 'px;top: ' + y + 'px;"></span>';
                var $box = $(html).appendTo($(this));
                $box.effectBubble({
                    y: -100,
                    className: 'thumb-bubble',
                    fontSize: 0.5,
                    content: '<i class="fa fa-smile-o"></i>' + $.bubble._tip[bubbleIndex]
                });
                setTimeout(function () {
                    $box.remove();
                }, 1002);
                bubbleIndex++;
            });
        },
        unbind: function (duration) {
            $("body").unbind('click');
            if (duration && !isNaN(duration = parseInt(duration))) {
                setTimeout(function () {
                    $.bubble.init();
                }, duration);
            }
        }
    }
});

/* 鼠标点击弹出提示动画 */

$.fn.extend({
    // 文字向上冒泡
    effectBubble: function (options) {
        var op = $.extend({
            content: '+1',
            y: -100,
            duration: 1000,
            effectType: 'ease',
            className: '',
            fontSize: 2
        }, options);

        return this.each(function () {
            var $box = $(this), flyId = 'effect-fly-' + (new Date().getTime());

            var tpl = '<span id="#flyId#" class="effect-bubble-fly #class#" style="opacity: 1;top:#top#px;left:#left#px;font-size: #fontSize#rem;">#content#</span>';
            var html = tpl.replaceAll('#left#', 12).replaceAll('#top#', -8)
                .replaceAll('#flyId#', flyId).replaceAll('#content#', op.content)
                .replaceAll('#class#', op.className).replaceAll('#fontSize#', op.fontSize);

            var $fly = $(html).appendTo($box);
            $fly.fadeIn(100, "swing", function () {
                $fly.animate({top: op.y, opacity: 0}, 100, function () {
                    $fly.fadeOut(op.duration, function () {
                        $fly.remove();
                    });
                });
            });
        });
    }
});
/**
 * 扩展String方法
 */
$.extend(String.prototype, {
    trim: function () {
        return this.replace(/(^\s*)|(\s*$)|\r|\n/g, "");
    },
    startsWith: function (str) {
        return new RegExp("^" + str).test(this);
    },
    endsWith: function (str) {
        return new RegExp(str + "$").test(this);
    },
    replaceAll: function (os, ns) {
        return this.replace(new RegExp(os, "gm"), ns);
    }
});

/* 返回顶部插件 */
(function ($) {
    $.fn.toTop = function (opt) {
        //variables
        var elem = this;
        var win = $(window);
        var doc = $('html, body');
        var options = opt;
        //如果没有配置自定义的参数，则使用默认
        if (!options) {
            options = $.extend({
                autohide: true,
                offset: 100,
                speed: 500,
                right: 15,
                bottom: 50
            }, opt);
        }
        elem.css({
            'position': 'fixed',
            'right': options.right,
            'bottom': options.bottom,
            'cursor': 'pointer'
        });
        if (options.autohide) {
            elem.css('display', 'none');
        }
        elem.click(function () {
            doc.animate({scrollTop: 0}, options.speed);
        });
        win.scroll(function () {
            var scrolling = win.scrollTop();
            if (options.autohide) {
                if (scrolling > options.offset) {
                    elem.fadeIn(options.speed);
                }
                else elem.fadeOut(options.speed);
            }
        });
    };
})(jQuery);
/* 返回顶部插件 end */

function tranColor(name) {
    var firstName = name.substring(1, 0);
    var str = '';
    for (var i = 0; i < name.length; i++) {
        str += parseInt(name[i].charCodeAt(0), 10).toString(16);
    }
    return '#' + str.slice(1, 4);
}
function textToImg(uname) {
    var name = uname.charAt(0);
    var fontSize = 60;
    var fontWeight = 'bold';
    var canvas = document.createElement("canvas");
    canvas.width = 120;
    canvas.height = 120;
    var context = canvas.getContext('2d');
    context.fillStyle = tranColor(uname);
    context.fillRect(0, 0, canvas.width, canvas.height);
    context.fillStyle = 'rgb(255,255,255)';
    context.font = fontWeight + ' ' + fontSize + 'px sans-serif';
    context.textAlign = 'center';
    context.textBaseline = "middle";
    context.fillText(name, fontSize, fontSize);
    return canvas.toDataURL("image/png");
};
