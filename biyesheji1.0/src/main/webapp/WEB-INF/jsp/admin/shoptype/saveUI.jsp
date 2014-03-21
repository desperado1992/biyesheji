<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>${sessionScope.user.name}欢迎您</title>
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
										<div class="profile">
						<img src="" class="avatar" alt="Profile" />
						<span class="info hidden-phone">
							<strong>${sessionScope.user.logName}</strong>
							<em>后台管理系统</em>
						</span>
					</div>
					<ul class="notif">
						<li><a href="" class="glyphicons chat btn" rel="tooltip" data-placement="bottom" data-original-title="7 new chat message(s)"><i></i><span>7</span></a></li>
						<li><a href="" class="glyphicons shopping_cart btn" rel="tooltip" data-placement="bottom" data-original-title="1 new product(s)"><i></i><span>1</span></a></li>
						<li><a href="" class="glyphicons user_add btn" rel="tooltip" data-placement="bottom" data-original-title="4 new member(s)"><i></i><span>4</span></a></li>
						<li><a href="" class="glyphicons envelope btn" rel="tooltip" data-placement="bottom" data-original-title="3 new email(s)"><i></i><span>3</span></a></li>
					</ul>
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
												<div class="inner topRight"><ul class="breadcrumb">
	<li><a href="" class="glyphicons home"><i></i> 管理后台</a></li>
	<li class="divider"></li>
	<li>商品状态管理</li>
	<li class="divider"></li>
	<li>管理状态</li>
</ul>
<div class="separator"></div>
<s:form action="shopbrandAction!edit"  id="shopform" >
<div class="heading-buttons">
	<h2 class="glyphicons cart_in"><i></i> 商品状态修改</h2>
	<div class="buttons pull-right">
		<a ><center><s:submit value="保存" cssClass="btn btn-primary btn-icon glyphicons ok_2"></s:submit></center></a>
	</div>
</div>
<div class="separator"></div>

<div class="widget widget-2 widget-tabs">
	<div class="widget-head">
		<ul>
			<li class="active"><a href="#productDescriptionTab" data-toggle="tab" class="glyphicons font"><i></i>品牌管理</a></li>
		
		</ul>
	</div>
	<div class="widget-body large">
		<div class="tab-content">
		<s:hidden name="id"></s:hidden>
			<!-- Description -->
			<div class="tab-pane active" id="productDescriptionTab">
				<div class="row-fluid">
					<div class="span3">
						<strong>商品发布时间为${postTime}---更新时间为${updateTime}</strong>
						<p class="muted">商品名称.</p>
					</div>
					<div class="span9">
						<label for="inputEmail">商品名</label>
						<input type="text" id="" class="span6" name="name" value="${name}" placeholder="请输入商品名称" />
						<div class="separator"></div>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span3">
						<strong>商品价格</strong>
						<p class="muted">商品的价格.</p>
					</div>
					<div class="span9">
						<label for="inputEmail">商品价格</label>
						<input type="text" id="" class="span6" name="price" value="${price}" placeholder="请输入商品的价格" />
						<div class="separator"></div>
					</div>
				</div>
					<div class="row-fluid">
					<div class="span3">
						<strong>库存</strong>
						<p class="muted">商品的库存.</p>
					</div>
					<div class="span9">
						<label for="inputEmail">商品库存</label>
						<input type="text" id="" class="span6" name="stock" value="${stock}" placeholder="请输入商品的库存称" />
						<div class="separator"></div>
					</div>
				</div>
		        <div class="row-fluid">
					<div class="span3">
						<strong>状态</strong>
						<p class="muted">商品的状态 1表示上架 0表示 审核中 -1表示商品下架了.</p>
					</div>
					<div class="span9">
						<label for="inputEmail">商品状态</label>
						<input type="text" id="" class="span6" name="status" value="${status}" placeholder="请输入商品的状态1表示上架 0表示 审核中 -1表示商品下架了" />
						<div class="separator"></div>
					</div>
				</div>
		       
				

					
		
			
		      <hr class="separator bottom" />
			
		</div>
	</div>
</div>

<br />							</div>
</s:form>
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
	      				      			<li><a href="documentation.html" class="glyphicons circle_question_mark text" title=""><i></i><span class="hidden-phone">毕业设计文档</span></a></li>
	      		</ul>
	      	</div>
	    </div>
		
	</div>
	
	


	

</body>
</html>