

<%@page import="study.spring.hellospring.model.Department"%>
<%@page import="java.util.List"%>
<%@page import="study.spring.hellospring.service.impl.DepartmentServiceImpl"%>

<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="study.spring.helper.WebHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 
	author : 임형진
	fileName : 서버구현평가.pdf
	content : 교수 정보를 추가하는 View
	lastUpdate : 2019-01-18

-->
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
		<h1 class="page-header">교수추가</h1>
		
		<!-- 추가를 위한 HTML 폼 시작 -->
		<form action="${pageContext.request.contextPath}/professor/prof_add_ok.do" method="POST" class="form-horizontal">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">교수이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name">
				</div>
			</div>
	
			
	
			<div class="form-group">
				<label for="userid" class="col-sm-2 control-label">아이디</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="userid" name="userid">
				</div>
			</div>

			<div class="form-group">
				<label for="position" class="col-sm-2 control-label">직급</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="position" name="position">
				</div>
			</div>

			<div class="form-group">
				<label for="sal" class="col-sm-2 control-label">급여</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="sal" name="sal">
				</div>
			</div>

			<div class="form-group">
				<label for="comm" class="col-sm-2 control-label">보직수당</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="comm" name="comm">
				</div>
			</div>

			<div class="form-group">
				<label for="hiredate" class="col-sm-2 control-label">입사일</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="hiredate" name="hiredate">
				</div>
			</div>

			<div class="form-group">
				<label for="deptno" class="col-sm-2 control-label">소속학과</label>
				<div class="col-sm-10">
					<select name="deptno" class="form-control">
						<option value="">---- 소속학과를 선택하세요 ----</option>
			<c:forEach var="k" items="${deptList}" varStatus="s">
					<option value="${k.deptno}">${k.dname}</option>
			</c:forEach>	
					</select>
				</div>
			</div>

			<div class="form-group">				
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">저장하기</button>
				</div>
			</div>
		</form>
		
		<!-- 추가를 위한 HTML 폼 끝 -->
	</div>
</body>
</html>


