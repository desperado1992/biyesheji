<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style type="text/css">
html{height:100%}
body{
float:left;

color:white;
width:100%;
height:100%;
}

</style>
<script src="${pageContext.request.contextPath}/resources/admin/theme/scripts/jquery-1.8.2.min.js"></script>
<%@ include file="/WEB-INF/jsp/public/common.jspf"%>
</head>
<body>
<div style="width: 100%;height:70px;background-color: white;">



</div>


<div style="text-align:center;line-height: 30px;width: 100%;height: 30px;background-color: white;"></div>


<div style="text-align: center;vertical-align: middle;float:left;width: 99%;height: 100%;border:1px solid red;background-color: white;">
<%@ include file="/WEB-INF/jsp/admin/channel/saveUI.jspf"%>
</div>
</body>
</html>

