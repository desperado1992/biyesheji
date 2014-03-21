<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ taglib prefix="s" uri="/struts-tags"%>
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


	<div align="center" >
	<table border="0">
	<s:form action="channelArticleAction!%{id == null ? 'add' : 'edit'}" >
	<tr><td colspan="2"><h3>文章管理</h3></td></tr>
	<tr><td colspan="2"><center>&nbsp;&nbsp;<input type="submit" value="栏目保存"  /></center></td></tr>

	    <s:hidden name="id"></s:hidden>
		<tr><td >文章标题:</td><td><input type="text"  name="title" value="${title}" /></td></tr>
		<tr><td>文章分类</td>
	     <td>
	     <s:select name="articleCategoryId" cssClass="span12"
                        		list="#cArticleCategoryList" listKey="id" listValue="name"
                        		headerKey="" headerValue="请选择分类"
             />
        </td>
        </tr>
        <tr><td >文章类型:</td>
	    <td>
	     <s:select name="articleType"
           list="@com.zyp.model.ArticlelType@values()"
           listKey="value" listValue="text" />
        </td>
        </tr>
		<tr><td >文章作者:</td><td><input type="text" name=""  value="${author.logName}" /></td></tr>
	    <tr><td >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	  
						<input type="radio" name="state" value="1"  <s:property value="%{state==1 ? 'checked' : ''}"/>  是否发布
						<input type="radio" name="state" value="0" style="display:none;"/>
				
	    
	    
	    </td>
	    <td >
	    
						<input type="radio" name="is_top" value="1"  <s:property value="%{is_top==1 ? 'checked' : ''}"/> 是否置顶
						<input type="radio" name="is_top" value="0" style="display:none;"/>
				
	    
	    
	    </td>
	    
	    </tr>
	      
	    
	      
	     
	     
	     
	  
	   
		<tr>
		<td >内 容:</td>
		<td> <textarea id="content"  name="content" class="span12"  cols="100" rows="8" style="width: 650px;height: 400px;">${contents}</textarea></td>
		</tr>
		</s:form>
	</table>
	
		</div>
		

		
           
		
	


			
	
		
	
	
