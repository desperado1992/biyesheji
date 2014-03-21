<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>${sessionScope.user.name}欢迎您</title>
	<script src="${pageContext.request.contextPath}/resources/admin/theme/scripts/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/picbox.js"></script>
	                    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/admin/css/picbox.css" type="text/css" media="screen" />
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
	<li><a href="index.html" class="glyphicons home"><i></i> 管理后台</a></li>
	<li class="divider"></li>
	<li>商品管理</li>
	<li class="divider"></li>
	<li>商品列表</li>
</ul>
<div class="separator"></div>

<div class="heading-buttons">
	<h2 class="glyphicons shopping_cart"><i></i> 商品管理</h2>
	<div class="buttons pull-right">
		<a href="${pageContext.request.contextPath}/main/shoptypeAction!racking.action" class="btn btn-primary btn-icon glyphicons circle_plus"><i></i> 上架所有商品</a>
		<a href="" class="btn btn-default btn-icon glyphicons inbox"><i></i> 管   理    </a>
	</div>
</div>
<div class="separator"></div>

<div class="row-fluid">
	<div class="span9">
		<div class="widget widget-2">
			<div class="widget-head">
				<h4 class="heading glyphicons list"><i></i> 列     表</h4>
			</div>
			<div class="widget-body">
				<div class="separator bottom form-inline small">
				
					<span class="pull-right">
						<label class="strong">排序:</label>
						<select class="selectpicker" data-style="btn-default btn-small">
							<option />默 认
							<option />层 数
							<option />字段名
						</select>
					</span>
				</div>
				<table class="table table-bordered table-condensed table-striped table-primary table-vertical-center checkboxs js-table-sortable">
					<thead>
						<tr>
						
							<th width="1%" class="uniformjs"><input type="checkbox" /></th>
							<th width="1%" class="center">序   号</th>
							<th>商品名称</th>
							<th width="1%" class="center">拖拽</th>
							<th class="center">商品品牌</th>
							<th class="center">商品分类</th>
						
							
							
							
							<th class="center">商品状态</th>
							<th class="center" width="60">操 作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="goods" status="stats">
						
                        
																		<tr class="selectable">
																		
							<td class="center uniformjs"><input type="checkbox" /></td>
							
							<td class="center"><s:property value="#stats.index"/></td>
							<td><strong>${name}</strong></td>
							<td class="center js-sortable-handle"><span class="glyphicons btn-action single move" style="margin-right: 0;"><i></i></span></td>
							<td class="center">${brand.name}</td>
							<td class="center">${category.name}</td>
							
							
							
							<td><strong><s:if test="status==1">已经上架</s:if><s:elseif test="status==0">正在审核</s:elseif><s:else>已经下架</s:else> </strong></td>
							<td class="center">
								<a href="${pageContext.request.contextPath}/main/shoptypeAction!editUI.action?id=${id}" class="btn-action glyphicons pencil btn-success"><i></i></a>
								<a href="${pageContext.request.contextPath}/main/shoptypeAction!outstock.action?id=${id}"  onclick="return window.confirm('您确定要下架或者重新审核？')" class="btn-action glyphicons remove_2 btn-danger"><i></i></a>
								
							</td>
							
						</tr>
						</s:iterator>			
											
			       </tbody>
				</table>
				<div class="separator top form-inline small">
					<div class="pull-left checkboxs_actions hide">
						<label class="strong">选 中:</label>
						<select class="selectpicker" data-style="btn-default btn-small">
							<option />选中最顶层分类
							<option />选中最底层分类
							<option />选中所有分类
						</select>
					</div>
					<div class="pagination pagination-small pull-right" style="margin: 0;">
						<ul>
							<li class="disabled"><a href="#">&laquo;</a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
						
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="span3">
		<div class="widget widget-2 primary widget-body-white">
			<div class="widget-head">
				<h4 class="heading glyphicons cogwheel"><i></i> 分类查询过滤</h4>
			</div>
			<div class="widget-body list list-2 fluid js-filters form-inline small">
				<ul>
					<li>
						<div class="input-append block">
							<input type="text" placeholder="输入要查询的商品 ..." />
							<span class="add-on glyphicons search"><i></i></span>
						</div>
					</li>
					<li class="right">
						<label class="span4">常用标签:</label>
						<div class="right">
							<select class="js-filter-category" name="category" style="width: 120px;">
								<option />电脑
								<option />手机
								<option />日常用品
							</select>
						</div>
					</li>
				<li class="js-filter-categories center">
						<span class="label label-important">书本 <strong>&times;</strong></span>
						<span class="label label-important">电器 <strong>&times;</strong></span>
						<span class="label label-important">日常用品 <strong>&times;</strong></span>
					</li>
				<li>
						<label class="span4">Select:</label>
						<div class="right">
							<select class="" name="from" style="width: 120px;">
								<option />Some option
								<option />Other option
								<option />Some other option
							</select>
						</div>
					</li>
					<li>
						<label>From:</label>
						<div class="right">
							<div class="input-append">
								<input type="text" name="from" id="dateRangeFrom" class="input-mini" value="08/05/13" style="width: 85px;" />
								<span class="add-on glyphicons calendar"><i></i></span>
							</div>
						</div>
					</li>
					<li>
						<label>To:</label>
						<div class="right">
							<div class="input-append">
								<input type="text" name="to" id="dateRangeTo" class="input-mini" value="08/18/13" style="width: 85px;" />
								<span class="add-on glyphicons calendar"><i></i></span>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="widget-body list list-2">
				<ul>
					<li class="active"><a href="" class="glyphicons link"><i></i>查看商品</a></li>
					<li><a href="" class="glyphicons link"><i></i>产看商品品牌</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<br />							</div>
						</div>
					</div>
				</div>
			</div>

		<!-- End Content -->
		</div>
		
		<!-- Sticky Footer -->
	<%@include file="/WEB-INF/jsp/public/footer.jspf" %>
		
	</div>



</body>
</html>