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

	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/admin/blue/forum.css" />
	
	

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
	
	</ul>
<div class="separator"></div>
<div class="row-fluid">

<!--内容显示-->	
<div id="MainArea">
	<div id="PageHead"></div>
	<center>
		<div class="ItemBlock_Title1" style="width: 98%">
			<font class="MenuPoint"> &gt; </font>
			<s:a action="forumAction_list">论坛</s:a>
			<font class="MenuPoint"> &gt; </font>
			<s:a action="forumAction!show?id=%{#topic.forum.id}">${topic.forum.name}</s:a>
			<font class="MenuPoint"> &gt;&gt; </font>
			帖子阅读
			<span style="margin-left:30px;">
				<s:a action="topicAction!addUI?forumtoId=%{#topic.forum.id}">
					<img align="absmiddle" src="${pageContext.request.contextPath}/resources/admin/blue/images/button/publishNewTopic.png"/>
				</s:a>
			</span>
		</div>
		
		<div class="ForumPageTableBorder dataContainer" datakey="replyList">
		
			<!--显示主题标题等-->
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr valign="bottom">
				<td width="3" class="ForumPageTableTitleLeft">&nbsp;</td>
					<td class="ForumPageTableTitle"><b>本帖主题：${topic.title}</b></td>
					<td class="ForumPageTableTitle" align="right" style="padding-right:12px;">
						<s:a cssClass="detail" action="replyAction!addUI?topicId=%{#topic.id}">
							<img border="0" src="${pageContext.request.contextPath}/resources/admin/css/images/reply.gif" />
							回复
						</s:a>
						<a href="moveUI.html"><img border="0" src="${pageContext.request.contextPath}/resources/admin/css/images/edit.gif" />移动到其他版块</a>
						<a href="#" onClick="return confirm('要把本主题设为精华吗？')"><img border="0" src="${pageContext.request.contextPath}/resources/admin/css/images/topicType_1.gif" />精华</a>
						<a href="#" onClick="return confirm('要把本主题设为置顶吗？')"><img border="0" src="${pageContext.request.contextPath}/resources/admin/css/images/topicType_2.gif" />置顶</a>
						<a href="#" onClick="return confirm('要把本主题设为普通吗？')"><img border="0" src="${pageContext.request.contextPath}/resources/admin/css/images/topicType_0.gif" />普通</a>
					</td>
					<td width="3" class="ForumPageTableTitleRight">&nbsp;</td>
				</tr>
				<tr height="1" class="ForumPageTableTitleLine"><td colspan="4"></td></tr>
			</table>

			<!-- ~~~~~~~~~~~~~~~ 显示主帖（主帖只在第1页显示） ~~~~~~~~~~~~~~~ -->
			<s:if test="currentPage == 1">
			<div class="ListArea">
				<table border="0" cellpadding="0" cellspacing="1" width="100%">
					<tr>
						<td rowspan="3" width="130" class="PhotoArea" align="center" valign="top">
							<!--作者头像-->
							<div class="AuthorPhoto">
							<s:if test="#topic.author.face==null">
								<img border="0" width="110" height="110" src="${pageContext.request.contextPath}/resources/admin/css/images/defaultAvatar.gif" 
									onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/resources/admin/css/images/defaultAvatar.gif';" />
							</s:if>
							<s:else>
                           <img border="0" width="110" height="110" src="${pageContext.request.contextPath}/${topic.author.face}" 
									onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/${topic.author.face}';" />
                            </s:else>
							</div>
							<!--作者名称-->
							<div class="AuthorName">${topic.author.name}</div>
						</td>
						<td align="center">
							<ul class="TopicFunc">
								<!--操作列表-->
								<li class="TopicFuncLi">
									<a class="detail" href=""><img border="0" src="${pageContext.request.contextPath}/resources/admin/css/images/edit.gif" />编辑</a>
									<a class="detail" href="#" onClick="return confirm('确定要删除本帖吗？')"><img border="0" src="${pageContext.request.contextPath}/resources/admin/css/images/delete.gif" />删除</a>
								</li>
								<!-- 文章表情与标题 -->
								<li class="TopicSubject">
									<img width="19" height="19" src="${pageContext.request.contextPath}/resources/admin/css/images/face/${topic.faceIcon}.gif"/>
									${topic.title}
								</li>
							</ul>
						</td>
					</tr>
					<tr><!-- 文章内容 -->
						<td valign="top" align="center">
							<div class="Content">${topic.content}</div>
						</td>
					</tr>
					<tr><!--显示楼层等信息-->
						<td class="Footer" height="28" align="center" valign="bottom">
							<ul style="margin: 0px; width: 98%;">
								<li style="float: left; line-height:18px;"><font color=#C30000>[楼主]</font>
									<s:date name="%{#topic.postTime}" format="yyyy-MM-dd HH:mm:ss"/>
								</li>
								<li style="float: right;"><a href="javascript:scroll(0,0)">
									<img border="0" src="${pageContext.request.contextPath}/resources/admin/css/images/top.gif" /></a>
								</li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
			</s:if>
			<!-- ~~~~~~~~~~~~~~~ 显示主帖结束 ~~~~~~~~~~~~~~~ -->


			<!-- ~~~~~~~~~~~~~~~ 显示回复列表 ~~~~~~~~~~~~~~~ -->
			<s:iterator value="recordList" status="status"> 
			<div class="ListArea template">
				<table border="0" cellpadding="0" cellspacing="1" width="100%">
					<tr>
						<td rowspan="3" width="130" class="PhotoArea" align="center" valign="top">
							<!--作者头像-->
							<div class="AuthorPhoto">
							<s:if test="#topic.author.face==null">
								<img border="0" width="110" height="110" src="${pageContext.request.contextPath}/resources/admin/css/images/defaultAvatar.gif" 
									onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/resources/admin/css/images/defaultAvatar.gif';" />
							</s:if>
							<s:else>
                           <img border="0" width="110" height="110" src="${pageContext.request.contextPath}/${topic.author.face}" 
									onerror="this.onerror=null; this.src='${pageContext.request.contextPath}/${topic.author.face}';" />
                            </s:else>
							</div>
							<!--作者名称-->
							<div class="AuthorName">${author.name}</div>
						</td>
						<td align="center">
							<ul class="TopicFunc">
								<!--操作列表-->
								<li class="TopicFuncLi">
									<a class="detail" href=""><img border="0" src="${pageContext.request.contextPath}/resources/admin/css/images/edit.gif" />编辑</a>
									<a class="detail" href="#" onClick="return confirm('确定要删除本帖吗？')"><img border="0" src="${pageContext.request.contextPath}/resources/admin/css/images/delete.gif" />删除</a>
								</li>
								<!-- 文章表情与标题 -->
								<li class="TopicSubject">
									<img width="19" height="19" src="${pageContext.request.contextPath}/resources/admin/css/images/face/${faceIcon}.gif"/>
									${title}
								</li>
							</ul>
						</td>
					</tr>
					<tr><!-- 文章内容 -->
						<td valign="top" align="center">
							<div class="Content">${content}</div>
						</td>
					</tr>
					<tr><!--显示楼层等信息-->
						<td class="Footer" height="28" align="center" valign="bottom">
							<ul style="margin: 0px; width: 98%;">
								<li style="float: left; line-height:18px;"><font color=#C30000>[${(currentPage - 1) * pageSize + status.count}楼]</font>
									<s:date name="%{postTime}" format="yyyy-MM-dd HH:mm:ss"/>
								</li>
								<li style="float: right;"><a href="javascript:scroll(0,0)">
									<img border="0" src="${pageContext.request.contextPath}/resources/admin/css/images/top.gif" /></a>
								</li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
			</s:iterator>
			<!-- ~~~~~~~~~~~~~~~ 显示回复列表结束 ~~~~~~~~~~~~~~~ -->
		</div>

		<!--分页信息-->
		<s:form action="topicAction!show?id=%{id}"> </s:form>
		<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>
		

		<div class="ForumPageTableBorder" style="margin-top: 25px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr valign="bottom">
					<td width="3" class="ForumPageTableTitleLeft">&nbsp;</td>
					<td class="ForumPageTableTitle"><b>快速回复</b></td>
					<td width="3" class="ForumPageTableTitleRight">&nbsp;</td>
				</tr>
				<tr height="1" class="ForumPageTableTitleLine">
					<td colspan="3"></td>
				</tr>
			</table>
		</div>
	</center>
			
	<!--快速回复-->
	<div class="QuictReply">
	<!-- 标题显示 -->
   <div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/resources/admin/css/images/title_arrow.gif"/> 帖子回复
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">

	<s:form action="replyAction!add?topicId=%{#topic.id}" cssStyle="margin: 0; padding: 0;">
		
		
		<div id="PageHead"></div>
		<center>
			<div class="ItemBlock_Title1">
				<div width=85% style="float:left">
					<font class="MenuPoint"> &gt; </font>
					<s:a action="forumAction_list">论坛</s:a>
					<font class="MenuPoint"> &gt; </font>
					<s:a action="forumAction!show?id=%{#topic.forum.id}">${topic.forum.name}</s:a>
					<font class="MenuPoint"> &gt;&gt; </font>
					帖子回复
				</div>
			</div>
			<div class="ItemBlockBorder">
				<table border="0" cellspacing="1" cellpadding="1" width="100%" id="InputArea">
					<tr>
						<td class="InputAreaBg" height="30"><div class="InputTitle">帖子主题</div></td>
						<td class="InputAreaBg"><div class="InputContent">${topic.title}</div></td>
					</tr>
					<tr>
						<td class="InputAreaBg" height="30"><div class="InputTitle">标题</div></td>
						<td class="InputAreaBg"><div class="InputContent">
                                 <input type="text" name="title"  style="width:100%" class="InputStyle" value="回复：${topic.title}"/>  </div>
							
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
							<input type="image" src="${pageContext.request.contextPath}/resources/admin/blue/images/button/submit.PNG" style="margin-right:15px;"/>
						
						</td>
					</tr>
				</table>
			</div>
		</center>
	</s:form>
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