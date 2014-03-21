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
	<li><a href="index.html" class="glyphicons home"><i></i> 管理后台</a></li>
	<li class="divider"></li>
	<li>会员管理</li>
	<li class="divider"></li>
	<li>会员信息</li>
</ul>
<div class="separator"></div>
<s:form action="memberAction!%{id == null ? 'add' : 'edit'}"  id="shopform"  enctype="multipart/form-data">
<div class="heading-buttons">
	<h2 class="glyphicons cart_in"><i></i> 会员信息添加（修改）</h2>
	<s:hidden name="id"></s:hidden>
	 <div class="buttons pull-right">
		
	</div>
	 
</div>
<div class="separator"></div>

	<div class="widget-body" style="padding-bottom: 0;">
						<div class="row-fluid">
							<div class="span6">
								<div class="control-group">
									<label class="control-label">用户名:</label>
									<div class="controls">
										<input type="text" name="logName" value="${logName}" class="span10" "<s:property value="%{id!=null ? 'readonly=readonly' : ''}"/>" style="border: 1px;"/>
										<span style="margin: 0;" class="btn-action single glyphicons circle_question_mark" rel="popover" data-placement="top" data-original-title="Help" data-content="First name is mandatory"><i></i></span>
									
									</div>
								</div>
									<div class="control-group">
									<label class="control-label">真实姓名:</label>
									<div class="controls">
										<input type="text" name="name" value="${name}" class="span10" />
										<span style="margin: 0;" class="btn-action single glyphicons circle_question_mark" rel="popover" data-placement="top" data-original-title="Help" data-content="First name is mandatory"><i></i></span>
									
									</div>
								</div>
									<div class="control-group">
									<label class="control-label">会员账号状态:</label>
									<div class="controls">
										<input type="text" name="status" value="${status}" class="span10" />
										<span style="margin: 0;" class="btn-action single glyphicons circle_question_mark" rel="popover" data-placement="top" data-original-title="Help" data-content="First name is mandatory"><i></i></span>
									<input type="text" name="password" value="${password}" class="span10" />
									</div>
								</div>
								
								
								<div class="control-group">
									<label class="control-label">联系地址</label>
									<div class="controls">
									<s:iterator value="addresses" var="address">
										<span class="span10">${address.name}+${address.phone}+${address.postcode}</span>
										<span style="margin: 0;" class="btn-action single glyphicons circle_question_mark" rel="popover" data-placement="top" data-original-title="Help" data-content="Last name is mandatory"><i></i></span>
									</s:iterator>	
										
									
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">email</label>
									<div class="controls">
										<input type="text" value="${email}" name="email" class="span10" />
										<span style="margin: 0;" class="btn-action single glyphicons circle_question_mark" rel="popover" data-placement="top" data-original-title="Help" data-content="Last name is mandatory"><i></i></span>
									</div>
								</div>
								
							</div>
							<div class="span6">
								<div class="separator"></div>
							
								<div class="control-group">
									<label class="control-label">会员头像上传</label>
									<div class="controls">
								
							<div class="fileupload fileupload-new" data-provides="fileupload">
								<div class="fileupload-new thumbnail" style="width: 200px; height: 150px;"><s:if test="face!=null"><img src="${pageContext.request.contextPath}/${face}" /></s:if><s:else><img src="http://www.placehold.it/200x150/EFEFEF/AAAAAA&text=no+image" /></s:else></div>
							  	<div class="fileupload-preview fileupload-exists thumbnail" style="max-width: 200px; max-height: 150px; line-height: 20px;"></div>
							  	<div>
									<span class="btn btn-file"><span class="fileupload-new">选取头像</span><span class="fileupload-exists">修改</span><input type="file" name="userImg" /></span>
							    	<a href="#" class="btn fileupload-exists" data-dismiss="fileupload">移除</a>
							  	</div>
						
							</div>
							
							
					             
									</div>
								</div>
							
								
							</div>
							
						</div>
						<hr class="separator bottom" />
							<div class="control-group">
							<label class="control-label">会员角色</label>
							<div class="controls">
								
							<s:select name="roleIds"  cssClass="selectpicker wysihtml5 span12" id="mustHaveId"
                        		multiple="true" size="10" 
                        		list="#roleList" listKey="id" listValue="name">
                            </s:select>
							按住Ctrl键可以多选或取消选择
							<hr>
							<a ><center><s:submit value="保存" cssClass="btn btn-primary btn-icon glyphicons ok_2"></s:submit></center></a>
							</div>
						</div>
						
					</div>
</s:form>
	 
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