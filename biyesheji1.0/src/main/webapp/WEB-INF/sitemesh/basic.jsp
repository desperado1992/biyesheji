<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/home/style/styles.css" />
<!--Google Webfont -->
<link href='http://fonts.googleapis.com/css?family=Istok+Web' rel='stylesheet' type='text/css' />
<!--Javascript-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/home/scripts/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/home/scripts/jquery.flexslider.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/home/scripts/jquery.easing.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/home/scripts/jquery.jcarousel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/home/scripts/form_elements.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/home/scripts/custom.js"></script>
<!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/resources/home/scripts/html5.js"></script>
<![endif]-->
<!-- mobile setting -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>
   <decorator:title default="校园二手交易" /> 
</title>

   <decorator:head /><!--被装饰页面的head-->
</head>
<body>
   <decorator:body /><!--被装饰页面的body-->
</body>
</html>
