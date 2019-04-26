<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>My JSP Page</title>
	<!-- Twitter Bootstrap3 & jQuery -->
	<link rel="icon" href="data:;base64,iVBORw0KGgo=">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" />
	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="http://cdn.ckeditor.com/4.5.10/standard/ckeditor.js"></script>
</head>
<body>
	<div class="container">
		<!-- 제목 -->
		<div class="page-header">
			<h1>Spring 메일 발송 연습</h1>
		</div>
		
		<!-- 메일 폼 영역  -->
		<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/mail/mail_ok.do">
			<div class="form-group">
				<label for="sender" class="control-label col-sm-2">보내는 주소</label>
				<div class="col-sm-10">
					<input type="text" name="sender" id="sender" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="receiver" class="control-label col-sm-2">받는 주소</label>
				<div class="col-sm-10">
					<input type="text" name="receiver" id="receiver" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="subject" class="control-label col-sm-2">메일 제목</label>
				<div class="col-sm-10">
					<input type="text" name="subject" id="subject" class="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="content" class="control-label col-sm-2">메일 내용</label>
				<div class="col-sm-10">
					<textarea name="content" id="content" class="ckeditor"></textarea>
				</div>
			</div>
			
			<div class="col-sm-10 col-sm-offset-2 text-right">
				<input type="submit" class="btn btn-primary" value="메일보내기" />
				<input type="reset" class="btn btn-default" value="다시작성" />
			</div>
		</form>
		
	</div>
</body>
</html>


