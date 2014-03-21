<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>${sessionScope.user.name}欢迎您</title>

			<script src="${pageContext.request.contextPath}/resources/admin/theme/scripts/jquery-1.8.2.min.js"></script>
	
			
	
<style>
	

	img{border:none;}
	a{text-decoration:none;}
	
	.PopupLayer{width:100%;height:100%;z-index:99999;padding:10px;position:fixed;left:30%;margin-left:-300px;background:#fff;background-clip:padding-box;border-radius:10px;border:10px solid #666;border:15px solid rgba(0,0,0,0.2);}
	
	
	.PopupLayer div.spanIframe{list-style:none;width:100%;height:89%;margin:10px auto 0;border:1px dashed #e4e4e4;overflow:hidden;}
	
	
	.btn_content{ margin:50px auto;top:327px;width:204px;height:25px;}
	.btn_content button{width:100px;height:25px;line-height:25px;background:#F60;border:1px solid #989898;margin-right:2px;}
	.btn_content button:hover{color:#fff;}
	
</style>

			<script type="text/javascript">
$(document).ready(function(){
	
	
	if($.browser.msie && $.browser.version<=6)
	{
		$(".PopupLayer").css("position","absolute");
	}
	$(".PopupLayer").css({"top":$(".PopupLayer").outerHeight()*-1+"px","opacity":0});//载入页面时将元素置于页面可见区域的顶部达到自上而下显示效果（PS：还有隐藏效果）
	function notice_show(link)//显示
	{
		var browser_visible_region_height=document.documentElement.clientHeight;//获取浏览器可见区域高度
		var element_height=$(".PopupLayer").outerHeight();//获取元素高度:height+paelement_heighting+margin
		//计算元素显示时的top值
		var element_show_top=(browser_visible_region_height-element_height)/2;
	
		$("#iFrame1").attr("src",link);
		$(".PopupLayer").stop(true).animate({top:element_show_top,opacity:1},1800);
	}
	
	function notice_hidden()//隐藏
	{
		var element_height=$(".PopupLayer").outerHeight();//获取元素高度:height+paelement_heighting+margin
		var ee=-element_height;//元素隐藏时的top值
		$(".PopupLayer").stop(true).animate({top:ee,opacity:0},1000);
	}
	
	$("a.close").click(function(){
		var element_height=$(".PopupLayer").outerHeight();//获取元素高度:height+paelement_heighting+margin
		var ee=-element_height;//元素隐藏时的top值
		$(".PopupLayer").animate({opacity:0},1000).animate({top:ee},0);
	})//点击关闭按钮隐藏
	
	$("a.btn").click(function(){
		$(".PopupLayer").animate({top:$(document).height(),opacity:0},1000)
	})
	
	$(".open").click(function(e){
		e.preventDefault();
		notice_show($(this).attr("href"));
	})//单击按钮触发显示
	
	$("#close").click(function(e){
		e.preventDefault();
		notice_hidden();
	})//单击按钮触发隐藏
	
	function check()
	{
		var kk=$(".PopupLayer").outerHeight()*-1;//获取元素高度:height+paelement_heighting+margin
		var ww=$(document).height();
		var qq=parseInt($(".PopupLayer").css("top"));//获取元素当前的top值，String类型转换为number类型
		
		if(qq == kk || qq == ww)
		{
			return;
		}
		else//弹出层自适应浏览器窗口大小。
		{
			var browser_visible_region_height=document.documentElement.clientHeight;//获取浏览器可见区域高度
			var element_height=$(".PopupLayer").outerHeight();//获取元素高度:height+paelement_heighting+margin
			//计算元素显示时的top值
			var element_show_top=(browser_visible_region_height-element_height)/2;
			$(".PopupLayer").stop(true).animate({top:element_show_top},1500);
		}
	}
	
	$(window).resize(function(){
		check();
	})//自适应浏览器窗口大小
	
});
</script>

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
										<div class="profile">
						<img src="" class="avatar" alt="Profile" />
						<span class="info hidden-phone">
							<strong>${sessionScope.user.logName}</strong>
							<em>后台管理系统</em>
						</span>
					</div>
					
						<%@ include file="/WEB-INF/jsp/public/head.jspf"%>
				</div>
			</div>
		</div>
	
		<div class="row-fluid rrow main">
			<div class="span12 main col" role="main">
				<div class="row-fluid rrow">
					<div class="span2 col main-left hide hidden-phone menu-large">
						<div class="rrow scroll-y-left">
							<div class="iScrollWrapper">
								<%@include file="/WEB-INF/jsp/admin/center.jsp" %>
							</div>
							<span class="navarrow hide">
								<span class="glyphicons circle_arrow_down"><i></i></span>
							</span>
						</div>
					</div>
					<div class="span10 col main-right">
						<div class="rrow scroll-y" id="mainYScroller">
								<div class="inner topRight">
								<ul class="breadcrumb">
	<li><a href="javascript:history.back()" class="glyphicons home"><i></i> 后台管理</a></li>
	<li class="divider"></li>
	<li>欢迎页面</li>
</ul>
<div class="separator"></div>

<h2 class="glyphicons display"><i></i> 系统信息显示</h2>
<div class="separator"></div>
<!--  <a href="" class="glyphicons edit" id="chat2"><i></i> 版本1</a> -->
 <%@include file="/WEB-INF/jsp/admin/channel/pages.jspf" %>
 

 
											</div>
						</div>
					</div>
				</div>
			</div>

		<!-- End Content -->
		</div>
		
		<%@include file="/WEB-INF/jsp/public/footer.jspf" %>
		
	</div>
	
	


	

</body>
</html>