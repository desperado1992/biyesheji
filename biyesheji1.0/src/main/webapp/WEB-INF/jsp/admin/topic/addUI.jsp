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
	            textarea : 'content'//设置提交时编辑器内容的名字，之前我们用的名字是默认的editorValue  
	        };  
	        var editor = new baidu.editor.ui.Editor(option);  
	        editor.render("content");
	 
	 
	 
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
	<li><a href="index.html" class="glyphicons home"><i></i> 首页</a></li>
	<li class="divider"></li>
	<li>【${forum.name}】中的主题列表</li>
	
</ul>
<div class="separator"></div>


<div class="row-fluid">
	
	<div id="MainArea">

	<s:form action="topicAction!add" cssStyle="margin: 0; padding: 0;">
		<s:hidden name="forumtoId"></s:hidden>
		
		<div id="PageHead"></div>
		<center>
			<div class="ItemBlock_Title1">
				<div width=85% style="float:left">
					<font class="MenuPoint"> &gt; </font>
					<s:a action="forumAction!list">论坛</s:a>
					<font class="MenuPoint"> &gt; </font>
					<s:a action="forumAction!show?id=%{#forum.id}">${forum.name}</s:a>
					<font class="MenuPoint"> &gt;&gt; </font>
					发表新主题
				</div>
			</div>
			<div class="ItemBlockBorder">
				<table border="0" cellspacing="1" cellpadding="1" width="100%" id="InputArea">
					<tr>
						<td class="InputAreaBg" height="30"><div class="InputTitle">标题</div></td>
						<td class="InputAreaBg"><div class="InputContent">
							<input type="text" name="title"  style="width:100%" class="InputStyle"/>
							
						</td>
					</tr>
					<tr>
						<td class="InputAreaBg" height="30"><div class="InputTitle">表情</div></td>
						<td class="InputAreaBg"><div class="InputContent">
							<!-- 显示表情符号 -->
							<!--现在在设计单选框(radio)和复选框(checkbox)时都会给选择文字加上label增大选择范围，以提高用户体验。
								但在给单独的图片加label时无法成功。
								解决方法是：给图片img标签加上disabled即可。-->
							<table cellpadding="0" border="0" cellspacing="0">
								<tr>
								<s:iterator begin="1" end="14" var="num">
									<td width="50" style="border-bottom:0 solid #ffffff">
										<input type="radio" name="faceIcon" value="${num}" id="r_${num}"/>
										<label for="r_${num}"><img width="19" height="19" src="${pageContext.request.contextPath}/resources/admin/css/images/face/${num}.gif" disabled="true" align="absmiddle"/></label>
									</td>
								</s:iterator>
								</tr>
							</table></div>
						</td>
					</tr>
					<tr height="240">
						<td class="InputAreaBg"><div class="InputTitle">内容</div></td>
						<td class="InputAreaBg">
							<div class="InputContent">
								 <textarea id="content" name="content"  class="span12"  cols="100" rows="8" style="width: 650px;height: 400px;">${contents}</textarea>
							</div>
						</td>
						
					</tr>
					<tr height="30">
						<td class="InputAreaBg" colspan="2" align="center">
							<input type="submit" style="margin-right:15px;"/>
							<a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/resources/admin/blue/images/button/goBack.png"/></a>
						</td>
					</tr>
				</table>
			</div>
		</center>
	</s:form>
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