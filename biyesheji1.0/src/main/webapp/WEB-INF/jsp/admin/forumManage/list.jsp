<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>${sessionScope.user.name}欢迎您</title>
			<script src="${pageContext.request.contextPath}/resources/admin/theme/scripts/jquery-1.8.2.min.js"></script>
	<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/admin/blue/pageCommon.css" />
    <style type="text/css">
    	.disabledA{
    		color: gray; 
    		/** text-decoration: underline; */ 
    		cursor: pointer;
    	}
    </style>
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
	<li><a href="index.html" class="glyphicons home"><i></i> 首页</a></li>
	<li class="divider"></li>
	<li>论坛列表</li>
	</ul>
<div class="separator"></div>
<div class="row-fluid">
<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="250px">版块名称</td>
                <td width="300px">版块说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="forumList">
        
        <s:iterator value="#forumList" status="status">
			<tr class="TableDetail1 template">
				<td>${name}&nbsp;</td>
				<td>${description}&nbsp;</td>
				<td>
					<s:a action="forumManagerAction!delete?id=%{id}" onclick="return delConfirm()">删除</s:a>
					<s:a action="forumManagerAction!editUI?id=%{id}">修改</s:a>
					
					<!-- 最上面的不能用上移 -->
					<s:if test="#status.first">
						<span class="disabledA">上移</span>
					</s:if>
					<s:else>
						<s:a action="forumManagerAction!moveUp?id=%{id}">上移</s:a>
					</s:else>
					
					<!-- 最下面的不能用下移 -->
					<s:if test="#status.last">
						<span class="disabledA">下移</span>
					</s:if>
					<s:else>
						<s:a action="forumManagerAction!moveDown?id=%{id}">下移</s:a>
					</s:else>
					
				</td>
			</tr>
		</s:iterator>	
		
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a action="forumManagerAction!addUI"><img src="${pageContext.request.contextPath}/resources/admin/css/images/createNew.png" /></s:a>
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