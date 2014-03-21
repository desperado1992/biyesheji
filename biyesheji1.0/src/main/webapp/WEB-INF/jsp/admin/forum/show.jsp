<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<title>${sessionScope.user.name}欢迎您</title>
			<script src="${pageContext.request.contextPath}/resources/admin/theme/scripts/jquery-1.8.2.min.js"></script>
	<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
	
	
		
	<script type="text/javascript">
		function onSortByChange( selectedValue ){
			if(selectedValue == 0){
				$("select[name=asc]").attr("disabled", "disabled");	
			}else{
				$("select[name=asc]").removeAttr("disabled");	
			}
		}
		$(function(){
			if($("select[name=orderBy]").val() == '0'){
				$("select[name=asc]").attr("disabled", "disabled");		
			}
		});
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
<s:form action="forumAction!show?id=%{id}">
<div id="MainArea">
	
	
		<div class="ItemBlock_Title1" style="width: 98%;">
			<font class="MenuPoint"> &gt; </font>
			<s:a action="forumAction_list">论坛</s:a>
			<font class="MenuPoint"> &gt; </font>
			${forum.name}
			<span style="margin-left:30px;">
				<s:a action="topicAction!addUI?forumtoId=%{#forum.id}">
					<img align="absmiddle" src="${pageContext.request.contextPath}/resources/admin/blue/images/button/publishNewTopic.png"/>
				</s:a>
			</span>
		</div>
		<div class="separator"></div>
		<div class="ForumPageTableBorder">
			<table width="100%" border="0" cellspacing="0"  class="table table-bordered table-condensed table-striped table-primary " cellpadding="0">
				<!--表头-->
				<tr align="center" valign="middle">
					<td width="3" class="ForumPageTableTitleLeft">
						<img border="0" width="1" height="1" src="${pageContext.request.contextPath}/resources/admin/css/images/blank.gif" />
					</td>
					<td width="50" class="ForumPageTableTitle"><!--状态/图标-->&nbsp;</td>
					<td class="ForumPageTableTitle">主题</td>
					<td width="130" class="ForumPageTableTitle">作者</td>
					<td width="100" class="ForumPageTableTitle">回复数</td>
					<td width="130" class="ForumPageTableTitle">最后回复</td>
					<td width="3" class="ForumPageTableTitleRight">
						<img border="0" width="1" height="1" src="${pageContext.request.contextPath}/resources/admin/css/images/blank.gif" />
					</td>
				</tr>
				<tr height="1" class="ForumPageTableTitleLine"><td colspan="8"></td></tr>
				<tr height=3><td colspan=8></td></tr>
					
				<!--主题列表-->
				<tbody class="dataContainer" datakey="topicList">
				
				<s:iterator value="recordList">
					<tr height="35" id="d0" class="template">
						<td></td>
						<td class="ForumTopicPageDataLine" align="center"><img src="${pageContext.request.contextPath}/resources/admin/css/images/topicType_${type}.gif" /></td>
						<td class="Topic">
							<s:a cssClass="Default" action="topicAction!show?id=%{id}">${title}</s:a>
						</td>
						<td class="ForumTopicPageDataLine">
							<ul class="ForumPageTopicUl">
								<li class="Author">${author.name}</li>
								<li class="CreateTime"><s:date name="postTime" format="yyyy-MM-dd HH:mm:ss"/> </li>
							</ul>
						</td>
						<td class="ForumTopicPageDataLine Reply" align="center"><b>${replyCount}</b></td>
						<td class="ForumTopicPageDataLine">
							<ul class="ForumPageTopicUl">
								<li class="Author">${lastReply.author.name}</li>
								<li class="CreateTime"><s:date name="lastReply.postTime" format="yyyy-MM-dd HH:mm:ss"/></li>
							</ul>
						</td>
						<td></td>
					</tr>
				</s:iterator>	
					
				</tbody>
				<!--主题列表结束-->	
					
				<tr height="3"><td colspan="9"></td></tr>
				
			</table>
			<div class="separator"></div>
			<!--其他操作-->
			<div id="TableTail" style="float:right;">
				<div id="TableTail_inside">
					<table border="0" cellspacing="0" cellpadding="0" height="100%" align="left">
						<tr valign=bottom>
							<td></td>
							<td>

								<s:select name="viewType" list="#{0:'全部主题', 1:'全部精华贴'}" cssClass="span9"/>
								<s:select name="orderBy" onchange="onSortByChange(this.value)"
									list="#{0:'默认排序(所有置顶帖在前面，并按最后更新时间降序排列)', 1:'只按最后更新时间排序', 2:'只按主题发表时间排序', 3:'只按回复数量排序'}"
								 cssClass="span9" />
								<s:select name="asc" list="#{false:'降序', true:'升序'}" cssClass="span9"/>
								&nbsp;&nbsp;&nbsp;
								<input type="IMAGE" src="${pageContext.request.contextPath}/resources/admin/blue/images/button/submit.PNG" align="ABSMIDDLE" cssClass="span9"/>
							
							</td>
						</tr>
					</table>
				</div>
			</div>
			
		</div>
	
</div>
</s:form>
<center>
<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>
</center>
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