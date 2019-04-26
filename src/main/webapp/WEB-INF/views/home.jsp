<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
	<title>Home</title>
</head>
<body>
<div class="container">
	<h1 class="page-header">Hello Spring</h1>
	
	<a href="${pageContext.request.contextPath}/param/home.do"
	class="btn btn-block btn-primary">Send Parameter</a>
	
	
	<a href="${pageContext.request.contextPath}/cookie/write.do"
	class="btn btn-block btn-success">Cookie</a>
	
	<a href="${pageContext.request.contextPath}/session/write.do"
	class="btn btn-block btn-info">Session</a>
	
	<a href="${pageContext.request.contextPath}/calc.do"
	class="btn btn-block btn-warning">AOP</a>
	
	<a href="${pageContext.request.contextPath}/mail/write.do"
	class="btn btn-block btn-danger">Mail Helper</a>
	
	<a href="${pageContext.request.contextPath}/upload/upload.do"
	class="btn btn-block btn-primary">Upload Helper</a>
	
	<a href="${pageContext.request.contextPath}/professor/prof_list.do"
	class="btn btn-block btn-success">Professor List</a>
	
	<a href="${pageContext.request.contextPath}/student/stud_list.do"
	class="btn btn-block btn-info">Student List</a>
	
</div>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
