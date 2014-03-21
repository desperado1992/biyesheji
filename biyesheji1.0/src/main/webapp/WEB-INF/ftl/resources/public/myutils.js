var utils = $.extend({}, utils);/* 定义全局对象，类似于命名空间或包的作用 */

utils.rootPath=function(){
					var curWwwPath = window.document.location.href;
					var pathName = window.document.location.pathname;
					var pos = curWwwPath.indexOf(pathName);
					var localhostPaht = curWwwPath.substring(0, pos);
					var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
					return (localhostPaht + projectName);
				};
                                      
   utils.projectName=function() {
		return window.document.location.pathname.substring(0, window.document.location.pathname.indexOf('\/', 1));
	}; 
	utils.host=function(){
		var curWwwPath = window.document.location.href;
		var pathName = window.document.location.pathname;
		var pos = curWwwPath.indexOf(pathName);
		var localhostPaht = curWwwPath.substring(0, pos);
		return localhostPaht;
	}
	
	
	/**
	 * @author 
	 * 
	 * 增加命名空间功能
	 * 
	 * 使用方法：utils.ns('jQuery.bbb.ccc','jQuery.eee.fff');
	 */
	utils.ns = function() {
		var o = {}, d;
		for ( var i = 0; i < arguments.length; i++) {
			d = arguments[i].split(".");
			o = window[d[0]] = window[d[0]] || {};
			for ( var k = 0; k < d.slice(1).length; k++) {
				o = o[d[k + 1]] = o[d[k + 1]] || {};
			}
		}
		return o;
	};

	/**
	 * @author 
	 * 
	 * 生成UUID
	 * 
	 * @returns UUID字符串
	 */
	utils.random4 = function() {
		return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
	};
	utils.UUID = function() {
		return (utils.random4() + utils.random4() + "-" + utils.random4() + "-" + utils.random4() + "-" + utils.random4() + "-" + utils.random4() + utils.random4() + utils.random4());
	};

	/**
	 * @author 
	 * 
	 * 获得URL参数
	 * 
	 * @returns 对应名称的值
	 */
	utils.getUrlParam = function(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null)
			return unescape(r[2]);
		return null;
	};

	/**
	 * @author 
	 * 
	 * 接收一个以逗号分割的字符串，返回List，list里每一项都是一个字符串
	 * 
	 * @returns list
	 */
	utils.getList = function(value) {
		if (value != undefined && value != '') {
			var values = [];
			var t = value.split(',');
			for ( var i = 0; i < t.length; i++) {
				values.push('' + t[i]);/* 避免他将ID当成数字 */
			}
			return values;
		} else {
			return [];
		}
	};

	/**
	 * @author 
	 * 
	 * @requires jQuery
	 * 
	 * 判断浏览器是否是IE并且版本小于8
	 * 
	 * @returns true/false
	 */
	utils.isLessThanIe8 = function() {
		return ($.browser.msie && $.browser.version < 8);
	};

	/**
	 * @author 
	 * 
	 * @requires jQuery
	 * 
	 * 将form表单元素的值序列化成对象
	 * 
	 * @returns object
	 */
	utils.serializeObject = function(form) {
		var o = {};
		$.each(form.serializeArray(), function(index) {
			if (o[this['name']]) {
				o[this['name']] = o[this['name']] + "," + this['value'];
			} else {
				o[this['name']] = this['value'];
			}
		});
		return o;
	};

	/**
	 * 
	 * 将JSON对象转换成字符串
	 * 
	 * @param o
	 * @returns string
	 */
	utils.jsonToString = function(o) {
		var r = [];
		if (typeof o == "string")
			return "\"" + o.replace(/([\'\"\\])/g, "\\$1").replace(/(\n)/g, "\\n").replace(/(\r)/g, "\\r").replace(/(\t)/g, "\\t") + "\"";
		if (typeof o == "object") {
			if (!o.sort) {
				for ( var i in o)
					r.push(i + ":" + obj2str(o[i]));
				if (!!document.all && !/^\n?function\s*toString\(\)\s*\{\n?\s*\[native code\]\n?\s*\}\n?\s*$/.test(o.toString)) {
					r.push("toString:" + o.toString.toString());
				}
				r = "{" + r.join() + "}";
			} else {
				for ( var i = 0; i < o.length; i++)
					r.push(obj2str(o[i]));
				r = "[" + r.join() + "]";
			}
			return r;
		}
		return o.toString();
	};
