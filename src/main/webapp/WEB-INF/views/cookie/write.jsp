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
</head>
<body>
	<div class="container">
		<!-- 쿠키 등록 폼  -->
		<div class="page-header">
			<h1>Cookie 저장</h1>
			<!-- 컨트롤러에서 넘어온 데이터 출력하기 -->
			<c:choose>
				<c:when test="${my_cookie != null}">
					<h2>저장된 쿠키 = ${my_cookie}</h2>				
				</c:when>
				<c:otherwise>
					<h2>저장된 쿠키 없음</h2>
				</c:otherwise>
			</c:choose>
			<!-- jstl을 통한 쿠키 데이터 읽기 -->
			<c:if test="${cookie.my_cookie != null}">
				<h3>${cookie.my_cookie.value}(이)가 저장되었습니다.</h3>
			</c:if>
		</div>
		<form method="post" action="${pageContext.request.contextPath}/cookie/save.do">
			<div class="form-group">
				<input type="text" name="memo" id="memo" class="form-control" />
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary btn-block" value="Cookie 저장" />
			</div>
		</form>
	</div>
</body>
</html>


