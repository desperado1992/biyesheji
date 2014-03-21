<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>    <html class="lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>    <html class="lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html> <!--<![endif]-->
<head>
	<title>后台登陆页</title>
			<script src="${pageContext.request.contextPath}/resources/admin/theme/scripts/jquery-1.8.2.min.js"></script>
		<%@ include file="/WEB-INF/jsp/public/common.jspf"%>	
</head>
<body>
	
	<!-- Start Content -->
	<div class="container-fluid left-menu">
		
		<div class="navbar main">
			<div class="innerpx">
				<button type="button" class="btn btn-navbar hidden-desktop hidden-tablet">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<div class="positionWrapper">
					<span class="line"></span>
										<div class="profile heading">
						<h1>校园二手商品交易</h1>
						<em>后台管理系统</em>
					</div>
				<%@ include file="/WEB-INF/jsp/public/head.jspf"%>		
				</div>
			</div>
		</div>
	
		<div class="row-fluid rrow main">
			<div class="span12 main col" role="main">
				<div class="row-fluid rrow">
					<div class="span2 col main-left hide login menu-large">
						<div class="rrow scroll-y-left">
							<div class="iScrollWrapper">

							
							</div>
							<span class="navarrow hide">
								<span class="glyphicons circle_arrow_down"><i></i></span>
							</span>
						</div>
					</div>
					<div class="span10 col main-right login">
						<div class="rrow scroll-y" id="mainYScroller">
							<div class="inner topRight"><div class="positionWrapper loginWrapper hide">
	<span class="line"></span>
	<div class="box-1 loginbox">
		<div class="inner">
			<form action="${pageContext.request.contextPath}/main/userAction!login.action" method="post" class="fts" />
				<fieldset>
					<legend>用户 后台 登录</legend>
					<hr class="separator bottom" style="margin-bottom: 10px;" />
					<div class="input-prepend input-full">
						<span class="add-on glyphicons user"><i></i></span>
						<input type="text" name="logName" class="" placeholder="用户名" />
					</div>
					<div class="input-prepend input-full">
						<span class="add-on glyphicons lock"><i></i></span>
						<input type="password" name="password" class="" placeholder="密码" />
					</div>
					<s:fielderror/>
					<a href="" class="glyphicons circle_question_mark forgot">忘记密码 <i></i></a>
					<hr class="separator bottom" style="margin-bottom: 10px;" />
					<button type="submit" class="btn btn-icon btn-block glyphicons right flash btn-primary">登陆<i></i></button>
				</fieldset>
			</form>
		</div>
	</div>
	<div class="btn-register">
		<a href="#" class="btn btn-icon btn-success glyphicons edit"><i></i>用户后台注册</a>
	</div>
</div>

<div>
	<div class="positionWrapper registerWrapper hide">
		<span class="line"></span>
		<div class="box-1 registerbox">
			<div class="inner">
				<form action="${pageContext.request.contextPath}/main/userAction!register.action" method="post" class="fts" />
					<input type="text" name="logName" placeholder="用户名" />
					<input type="password" name="password" placeholder="密码" />
					
					<button type="submit" class="btn btn-icon btn-block glyphicons right edit btn-success">注册<i></i></button>
				</form>
			</div>
		</div>
		<div class="btn-login">
			<a href="#" class="btn btn-icon btn-primary glyphicons unlock"><i></i>登录</a>
		</div>
	</div>
</div>							</div>
						</div>
					</div>
				</div>
			</div>

		<!-- End Content -->
		</div>
		
		<!-- Sticky Footer -->
		<div id="footer" class="hide">
	      	<div class="wrap">
	      		<ul>
	      				      			<li class="active"><span data-toggle="menu-position" data-menu-position="left-menu" class="glyphicons circle_arrow_left" title=""><i></i></span></li>
	      			<li><span data-toggle="menu-position" data-menu-position="right-menu" class="glyphicons circle_arrow_right" title=""><i></i></span></li>
	      			<li><span data-toggle="menu-position" data-menu-position="top-menu" class="glyphicons circle_arrow_top" title=""><i></i></span></li>
	      			<li class="divider"></li>
	      			<li class="active"><span data-toggle="menu-size" data-menu-size="0" class="glyphicons show_big_thumbnails text" title=""><i></i><span class="hidden-phone">大图标</span></span></li>
	      			<li><span data-toggle="menu-size" data-menu-size="1" class="glyphicons show_thumbnails text" title=""><i></i><span class="hidden-phone">小图标</span></span></li>
	      				      			<li><a href="documentation.html" class="glyphicons circle_question_mark text" title=""><i></i><span class="hidden-phone">毕业设计报告</span></a></li>
	      		</ul>
	      	</div>
	    </div>
		
	</div>
	

	<script type="text/javascript">
	var scrollers = [];
	var mainYScroller;
	
	$(function()
	{
		//document.addEventListener('touchmove', function(e){ e.preventDefault(); });
		var xScrollers = $(".scroll-x");
	    for (var i = 0; i < xScrollers.length; i++)
			scrollers.push(new iScroll(xScrollers[i], { 
				vScroll: false, 
				hideScrollbar: true,
				useTransform: $('html').is('.lt-ie9') ? false : true,
				onBeforeScrollStart: function (e) 
				{
					var target;
					if (!e) var e = window.event;
					if (e.target) target = e.target;
					else if (e.srcElement) target = e.srcElement;
					if (target.nodeType == 3) target = target.parentNode;

					if (target.tagName != 'SELECT' && target.tagName != 'INPUT' && target.tagName != 'TEXTAREA')
					{
						if (e.preventDefault) e.preventDefault();
						else e.returnValue = false;
					}
				} 
			}));

		var yScrollers = $('.scroll-y').not('#mainYScroller');
	    $.each(yScrollers, function(i,v)
		{
	    	var scroller = new iScroll($(v).attr('id'),
	    	{
		    	hScroll: false, 
		    	hideScrollbar: true,
		    	useTransform: $('html').is('.lt-ie9') ? false : true,
		    	onBeforeScrollStart: function (e) 
		    	{
		    		var target;
					if (!e) var e = window.event;
					if (e.target) target = e.target;
					else if (e.srcElement) target = e.srcElement;
					if (target.nodeType == 3) target = target.parentNode;
					
					if (target.tagName != 'SELECT' && 
						target.tagName != 'INPUT' && 
						target.tagName != 'TEXTAREA' &&
						$(target).parents('table-responsive').size() == 0)
					{
						if (e.preventDefault) e.preventDefault();
						else e.returnValue = false;
					}
				}
		    });
	    	scrollers.push(scroller);
		});

	    mainYScroller = new iScroll('mainYScroller',
    	{
	    	zoom: true,
	    	hScroll: false, 
	    	hideScrollbar: true,
	    	useTransform: $('html').is('.lt-ie9') ? false : true,
	    	onBeforeScrollStart: function (e) 
	    	{
	    		var target;
				if (!e) var e = window.event;
				if (e.target) target = e.target;
				else if (e.srcElement) target = e.srcElement;
				if (target.nodeType == 3) target = target.parentNode;

				if ($('input:focus, textarea:focus').length) $('input:focus, textarea:focus').blur();

				if ($(target).parents('.table-responsive').size() > 0 ||
					$(target).parents('.google-visualization-table-table').size() > 0 ||
					$(target).parents('#calendar').size() > 0 ||
					$(target).is('.btn'))
					{
						return true;
					}
					
				if (target.tagName != 'SELECT' && 
					target.tagName != 'INPUT' && 
					target.tagName != 'TEXTAREA')
				{
					if (e.preventDefault) e.preventDefault();
					else e.returnValue = false;
				}
			},
			onScrollEnd: function()
			{
				//if (mainYScroller.enabled == false) mainYScroller.enable();
			}
	    });
	    scrollers['mainYScroller'] = mainYScroller;
	});
	</script>
	

	
</body>
</html>