<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>${sessionScope.user.name}欢迎您</title>
			<script src="${pageContext.request.contextPath}/resources/admin/theme/scripts/jquery-1.8.2.min.js"></script>
				<script  src="${pageContext.request.contextPath}/editor/ueditor.config.js"></script>  
<script  src="${pageContext.request.contextPath}/editor/ueditor.all.min.js"></script>  
<link rel="stylesheet" href="${pageContext.request.contextPath}/editor/themes/default/css/ueditor.css">  
 <script language="javascript" type="text/javascript">
 $(function(){
	 var option = {  
	            initialContent : '',//初始化编辑器的内容  
	            minFrameHeight : 400,//设置高度  
	            textarea : 'contents'//设置提交时编辑器内容的名字，之前我们用的名字是默认的editorValue  
	        };  
	        var editor = new baidu.editor.ui.Editor(option);  
	        editor.render("contents");
	 
	 
	 
 });
          
</script> 
				<!--[if IE]><script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/theme/scripts/excanvas/excanvas.js"></script><![endif]-->
	
	<%@ include file="/WEB-INF/jsp/public/common.jspf"%>

	<!-- Modernizr -->
	<script src="${pageContext.request.contextPath}/resources/admin/theme/scripts/modernizr.custom.76094.js"></script>
	
	<!--[if IE]><script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/theme/scripts/excanvas/excanvas.js"></script><![endif]-->

<script type="text/javascript">



</script>



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
	<li>添加分类</li>
</ul>
<div class="separator"></div>
<s:form action="shopAction!%{id == null ? 'add' : 'edit'}"  id="shopform" enctype="multipart/form-data">
<div class="heading-buttons">
	<h2 class="glyphicons cart_in"><i></i> 商品添加</h2>
	<div class="buttons pull-right">
		<a ><center><s:submit value="保存" cssClass="btn btn-primary btn-icon glyphicons ok_2"></s:submit></center></a>	
		
	
	</div>
</div>
<div class="separator"></div>

<div class="widget widget-2 widget-tabs">
	<div class="widget-head">
		<ul>
			<li class="active"><a href="#productDescriptionTab" data-toggle="tab" class="glyphicons font"><i></i>商品信息</a></li>
			<li><a href="#productPhotosTab" data-toggle="tab" class="glyphicons picture"><i></i>商品图片</a></li>
			<li><a href="#productAttributesTab" data-toggle="tab" class="glyphicons adjust_alt"><i></i>商品描述管理</a></li>
			<li><a href="#productPriceTab" data-toggle="tab" class="glyphicons table"><i></i>价格 规格 库存管理</a></li>
			<li><a href="#productSeoTab" data-toggle="tab" class="glyphicons podium"><i></i>品牌 折扣管理</a></li>
		</ul>
	</div>
	<div class="widget-body large">
		<div class="tab-content">
		  
		    <s:hidden name="id"></s:hidden>
			<!-- Description -->
			<div class="tab-pane active" id="productDescriptionTab">
				<div class="row-fluid">
					<div class="span3">
						<strong>商品名称</strong>
						
						<p class="muted">商品的名称.</p>
					</div>
					<div class="span9">
						<label for="inputEmail">商品名</label>
						<input type="text" id="" class="span6" value="${name}" name="name" placeholder="请输入商品名称" />
						<div class="separator"></div>
					</div>
				</div>
				
				<div class="row-fluid">
					<div class="span3">
						<strong>商品介绍</strong>
						<p class="muted">商品的介绍说明.</p>
					</div>
					<div class="span9">
						<label for="inputEmail">商品说明</label>
						<textarea id="mustHaveId" name="description"  class="wysihtml5  span12" rows="5">${description}</textarea>
					</div>
				</div>
		
				

					
					<div class="row-fluid">
				<div class="span3">
						<strong>商品分类</strong>
						<p class="muted">商品分类 </p>
					</div>
					<div class="span9">
						<select class="span12" name="categoryId" >
						<s:iterator value="categorys" var="category">
							<optgroup label="${category.name}">
								<s:iterator value="childrens">
								<option value="${id}"/>${name}
								
							    </s:iterator>	
							</optgroup>
						</s:iterator>	       
							
						</select>
						</div>
					</div>
			
		      <hr class="separator bottom" />
			<!-- Description END -->
			<div class="heading-buttons">
	<div class="buttons pull-right" style="margin-top: 0;">
		<a href="javascript:window.history.back()" class="btn btn-default btn-icon glyphicons share"><i></i> 返回</a>
		
	</div>
	<div class="clearfix"></div>
</div>
<br />
	  	
			<!-- Photos -->
				<div class="row-fluid">
						<strong>商品图片</strong>
						<p class="muted">商品的相册列表展示 </p>
					</div>
						<div class="row-fluid gallery paper " >
			

		<ul>
		
						<li class="span3">
				<span class="thumb view">
					<span class="back">
						<span class="btn btn-mini btn-primary">edit</span>
						<a href="" class="arr">&rarr;</a>
					</span>
					<img src='${pageContext.request.contextPath}/resources/admin/theme/images/gallery/rs/1.jpg'  alt="Album" />
				</span>
				<span class="name"></span>
			</li>
					
					</ul>
	

	
			</div>
					
					</div>
				<hr class="separator bottom" />	
				<br />
					<!-- Attributes -->
			<div class="tab-pane" id="productPhotosTab">
	
	                  <h5>Image upload previews</h5>
							<div class="fileupload fileupload-new" data-provides="fileupload">
								<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;"><img src="" /></div>
							  	<div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
							  	<div>
									<span class="btn btn-file"><span class="fileupload-new">选择图片</span><span class="fileupload-exists">更改</span><input type="file" name="shopImg" /></span>
							    	<a href="#" class="btn fileupload-exists" data-dismiss="fileupload">移除</a>
							  	</div>
							</div>
			
			</div>
				
		
			
			<!-- Photos END -->
			
			<!-- Attributes -->
			<div class="tab-pane"  id="productAttributesTab">



               <div class="relativeWrap">
	<div class="widget widget-gray">

		<div class="widget-head">
			<h4 class="heading">商品详细信息</h4>
		</div>
		<div class="widget-body">
		     <textarea id="contents" name="contents" class="span12"  cols="100" rows="8" style="width: 1000px;height: 600px;">${contents}</textarea>
			
          
</script> 

		</div>
	</div>
         </div>

           </div>

			<!-- Attributes END -->
			
			<!-- Price -->
			<div class="tab-pane" id="productPriceTab">
			    <h5>价格</h5>
					<div class="row-fluid">
						<input type="text" placeholder="请输入价格" name="price" class="span12" value="${price}"/>
					</div>
					<s:if test="id==null">
			<h5>规格</h5>
					<div class="row-fluid">
					
						<select class="selectpicker span6" name="specifId" data-style="btn-primary" multiple="multiple">
						<s:iterator value="specifications" var="specification">
							<option value="${id}" selected="selected"/>颜色:${color}&nbsp;尺码:${measures}&nbsp;规格名称:${name}
						</s:iterator>
						</select> 
					</div>
					</s:if>
			<h5>库存</h5>
					<div class="row-fluid">
						<input type="text" placeholder="库存" class="span12"  name="stock"  value="${stock}" />
					</div>				
			</div>
			<!-- Price END -->
			
			<!-- SEO -->
			<div class="tab-pane" id="productSeoTab">
			  <h5>折扣（小于1为百分比 大于1 为差价）</h5>
					<div class="row-fluid" >
						<input type="text" placeholder="折扣类型  0为 百分比 1为 价格直接减少" name="discount.type" class="span12" value="0"/>
					</div>
			       <div class="row-fluid">
						<input type="text" placeholder="折扣名称 " name="discount.name" class="span12" value="优惠"/>
					</div>
			          <div class="row-fluid">
						<input type="text" placeholder="折扣值" name="discount.point" class="span12" value="0.95"/>
					</div>
			</div>
			<!-- SEO END -->
		</div>
	
</div>
<div class="heading-buttons">
	<div class="buttons pull-right" style="margin-top: 0;">
		<a href="javascript:window.history.back()" class="btn btn-default btn-icon glyphicons share"><i></i> 返回</a>
	
	</div>
	<div class="clearfix"></div>
</div>
<br />							</div>
						</div>
					</div>
				</div>
			</div>
		
		<!-- End Content -->
		</div>
	</s:form>
	
		
	</div>
	</div>
	<script>
	$(function()
	{
		
		var $container = $(".gallery.paper ul");
		$container
			.imagesLoaded( function(){
				$container.masonry({
					gutterWidth: 50,
			    	itemSelector : 'li',
			    	columnWidth: $(".gallery.paper li:first").width()
			  	});
			});
	});
	</script>


	<!-- Load -->
	<script>
	Modernizr.load({
		test: Modernizr.csstransforms3d && Modernizr.csstransitions,
		yep : ["${pageContext.request.contextPath}/resources/admin/theme/scripts/paperGallery/jquery.paperGallery.js"],
		nope: "${pageContext.request.contextPath}/resources/admin/theme/scripts/paperGallery/fallback.css",
		callback : function( url, result, key ) 
		{
			if( url === "${pageContext.request.contextPath}/resources/admin/theme/scripts/paperGallery/jquery.paperGallery.js" ) {
				$( ".gallery.paper" ).paperGallery();
			}
		}
	});
	</script>	



</body>
</html>