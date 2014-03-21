<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ taglib prefix="s" uri="/struts-tags"%>


	<div align="center" style="margin-top:100px;">
	<table border="0">
	<s:form action="carticleCategoryAction!%{id == null ? 'add' : 'edit'}"   >
	<tr><td colspan="2"><h3>文章分类管理</h3></td></tr>
	

	    <s:hidden name="id"></s:hidden>
		<tr><td >文章分类标题:</td><td><input type="text"  name="name" value="${name}" /></td></tr>
		<tr><td>文章分类描述 </td>
		<td>
	    <textarea rows="8" cols="100" name="description">${description}</textarea>
	    </td>
       
        </tr>
		<tr><td >排序:</td><td><input type="text" name="sort"  value="${sort}" /></td></tr>
	    </tr>
		<br />
		<br />
		<tr><td colspan="2"><center>&nbsp;&nbsp;<input type="submit" value="保存"  /></center></td></tr>
		
		</s:form>
	   </table>
		</div>
		

		
           
		
	


			
	
		
	
	
