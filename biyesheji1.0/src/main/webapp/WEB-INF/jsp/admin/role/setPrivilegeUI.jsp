<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>${sessionScope.user.name}欢迎您</title>
			<script src="${pageContext.request.contextPath}/resources/admin/theme/scripts/jquery-1.8.2.min.js"></script>
			
		  <script language="javascript" src="${pageContext.request.contextPath}/resources/admin/jquery_treeview/jquery.treeview.js"></script>

	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/admin/jquery_treeview/jquery.treeview.css" />
	<script type="text/javascript">
		$(function(){
			
			// 给所有的权限复选框添加事件
			$("[name=privilegeIds]").click(function(){

				// 自己选中或取消时，把所有的下级权限也都同时选中或取消
				$(this).siblings("ul").find("input").attr("checked", this.checked);
				
				// 当选中一个权限时，也要同时选中所有的直系上级权限
				if(this.checked){
					$(this).parents("li").children("input").attr("checked", true);
				}
				// 当取消一个权限时，同级没有选中的权限了，就也取消他的上级权限，再向上也这样做。
				else{
					if( $(this).parent().siblings("li").children("input:checked").size() == 0 ){
						$(this).parent().parent().siblings("input").attr("checked", false);
						
						var start = $(this).parent().parent();
						if( start.parent().siblings("li").children("input:checked").size() == 0 ){
							start.parent().parent().siblings("input").attr("checked", false);
						}
					}
				}
			});
			
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
								<div class="inner topRight">
								<ul class="breadcrumb">
	<li><a href="javascript:history.back()" class="glyphicons home"><i></i> 后台管理</a></li>
	<li class="divider"></li>
	<li>用户信息</li>
</ul>
<div class="separator"></div>

<h2 class="glyphicons display"><i></i> 用户信息显示</h2>
<div class="separator"></div>
 <s:form action="roleAction!setPrivilege">
    	<s:hidden name="id"></s:hidden>
<div class="separator"></div>


<center><s:submit value="保存" cssClass="btn btn-primary  btn-icon glyphicons ok_2"></s:submit></center>
 
<div class="separator"></div>
 <%@ include file="/WEB-INF/jsp/admin/role/privilege.jspf"%>
 
 

</s:form>
											</div>
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