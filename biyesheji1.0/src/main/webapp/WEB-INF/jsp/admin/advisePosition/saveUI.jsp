<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ taglib prefix="s" uri="/struts-tags"%>
<script src="${pageContext.request.contextPath}/resources/admin/theme/scripts/jquery-1.8.2.min.js"></script>


	<div align="center" style="margin-top:150px;">
	<table border="0">
	<s:form action="advisePositionAction!%{id == null ? 'add' : 'edit'}"   >
	
	<tr><td colspan="2"><center>&nbsp;&nbsp;<input type="submit" value="保存"  /></center></td></tr>

	    <s:hidden name="id"></s:hidden>
		<tr><td >名称:</td><td><input type="text"  name="name" value="${name}" /></td></tr>
		
		<tr><td >宽度:</td><td><input type="text" name="wh.key1"  value="${wh.key1}" /></td></tr>
		<tr><td >高度:</td><td><input type="text" name="wh.key1"  value="${wh.value1}" /></td></tr>

		<tr>
		<td >描述:</td>
		<td> <textarea  name="description" class="span12"  cols="30" rows="8" >${description}</textarea></td>
		</tr>
		</s:form>
	</table>
	
		</div>
		

		
           
		
	


			
	
		
	
	
