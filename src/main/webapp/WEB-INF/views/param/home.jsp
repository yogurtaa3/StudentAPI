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
	<h1 class="page-header">Send Parameter</h1>
	
	<!-- GET 파라미터 전송 테스트 -->
	<h2>100+200=?</h2>
	<a href="${pageContext.request.contextPath}/param/get.do?answer=100" class="btn btn-primary">100</a>
	<a href="${pageContext.request.contextPath}/param/get.do?answer=200" class="btn btn-primary">200</a>
	<a href="${pageContext.request.contextPath}/param/get.do?answer=300" class="btn btn-primary">300</a>
	<a href="${pageContext.request.contextPath}/param/get.do?answer=400" class="btn btn-primary">400</a>
	<a href="${pageContext.request.contextPath}/param/get.do?answer=500" class="btn btn-primary">500</a>
	<hr />
	
	<!-- POST 파라미터 전송 테스트 -->
	<h2>당신의 이름과 나이를 입력해 주세요.</h2>
	<form name='form' method='post' action="${pageContext.request.contextPath}/param/post.do">
	
		<div class="form-group">
			<label for="user-name">이름</label>
			<input type="text" name='user_name' id='user_name' class='form-control' />
		</div>
		<div class="form-group">
			<label for="user_age">나이</label>
			<input type="text" name='user_age' id='user_age' class='form-control' />
		</div>
		<div class="form-group">
			<button type='submit' class='btn btn-info btn-block'>제출</button>
		</div>
	
	</form>
</div>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>
