<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ taglib prefix="s" uri="/struts-tags"%>
<script src="${pageContext.request.contextPath}/resources/admin/theme/scripts/jquery-1.8.2.min.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/admin/css/manhuaDate.1.0.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/manhuaDate.1.0.js"></script>	
	<script type="text/javascript">
		$(function(){
			name为指定值的textarea
			$("input.mh_date").manhuaDate({					       
				Event : "click",//可选				       
				Left : 0,//弹出时间停靠的左边位置
				Top : -16,//弹出时间停靠的顶部边位置
				fuhao : "-",//日期连接符默认为-
				isTime : false,//是否开启时间值默认为false
				beginY : 2010,//年份的开始默认为1949
				endY :2015//年份的结束默认为2049
			});
		
		}
		);
	</script>
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


	<div align="center" style="margin-top: 150px;">
	<table border="0">
	<s:form action="adviseAction!%{id == null ? 'add' : 'edit'}"   >

	<tr><td colspan="2"><center>&nbsp;&nbsp;<input type="submit" value="保存"  /></center></td></tr>

	    <s:hidden name="id"></s:hidden>
		<tr><td >标题:</td><td><input type="text"  name="name" value="${name}" /></td></tr>
		<tr><td colspan="2">广告位
	    <s:select name="adPositionId" 
                        		list="#advisePositionList" listKey="id" listValue="name"
                        		headerKey="" headerValue="请选择广告位"
                        	/>
	     
        </td>
        </tr>
		
	     <tr><td >广告类型:</td>
	    <td>
	     <s:select name="adviseTypeType"
           list="@com.zyp.model.AdviseType@values()"
           listKey="value" listValue="text" />
        </td>
        </tr>
        <tr><td ><label class="control-label">起始日期</label></td>
        <td>
        
        	<input type="text"  value="" name="startTime" class="mh_date" readonly="true"/>
        
        </td>
        </tr>
        <tr><td ><label class="control-label">终止日期</label></td>
        <td>
        
        	<input type="text"  value="" name="stopTime" class="mh_date" readonly="true"/>
        
        </td>
        </tr>
	  	   
		<tr>
		<td >脚本:</td>
		<td> <textarea id="contents" name="contents" class="span12"  cols="100" rows="8" style="width: 650px;height: 400px;">${contents}</textarea></td>
		</tr>
		</s:form>
	</table>
	</div>
		

		
           
		
	


			
	
		
	
	
