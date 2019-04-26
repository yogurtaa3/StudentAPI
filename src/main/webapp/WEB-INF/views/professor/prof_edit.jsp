<!-- 
	author : 임형진
	fileName : MVC구현평가_교수.pdf
	content : 교수 정보를 수정하는 JSP
	lastUpdate : 2019-03-26

-->

<%@page import="study.spring.hellospring.model.Department"%>
<%@page import="java.util.List"%>
<%@page import="study.spring.hellospring.service.impl.DepartmentServiceImpl"%>
<%@page import="study.spring.hellospring.service.DepartmentService"%>
<%@page import="study.spring.hellospring.service.impl.ProfessorServiceImpl"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="study.spring.hellospring.model.Professor"%>
<%@page import="study.spring.hellospring.service.ProfessorService"%>
<%@page import="study.spring.helper.WebHelper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%


%>
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
		<h1 class="page-header">교수수정</h1>

		<!-- 수정을 위한 HTML 폼 시작 -->
		<form action="${pageContext.request.contextPath}/professor/prof_edit_ok.do" method="POST" class="form-horizontal">
			<input type="hidden" name="profno" value="${item.profno}" />
			

			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">교수이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name" value="${item.name}" />
				</div>
			</div>
	
			
	
			<div class="form-group">
				<label for="userid" class="col-sm-2 control-label">아이디</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="userid" name="userid" value="${item.userid}" />
				</div>
			</div>

			<div class="form-group">
				<label for="position" class="col-sm-2 control-label">직급</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="position" name="position" value="${item.position}" />
				</div>
			</div>

			<div class="form-group">
				<label for="sal" class="col-sm-2 control-label">급여</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="sal" name="sal" 
					value="${item.sal}" />
				</div>
			</div>

			<div class="form-group">
				<label for="comm" class="col-sm-2 control-label">보직수당</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="comm" name="comm" value="${item.comm}" />
				</div>
			</div>

			<div class="form-group">
				<label for="hiredate" class="col-sm-2 control-label">입사일</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="hiredate" name="hiredate" value="${item.hiredate}" />
				</div>
			</div>

			<div class="form-group">
				<label for="deptno" class="col-sm-2 control-label">소속학과</label>
				<div class="col-sm-10">
					<select name="deptno" class="form-control">
						<option value="">---- 소속학과를 선택하세요 ----</option>
<c:forEach var="k" items="${deptList}">						
	<c:choose>					
		<c:when test="${k.deptno == item.deptno}">					
						<option value='${k.deptno}' selected>${k.dname}</option>
						
		</c:when>				
		<c:otherwise>
						<option value='${k.deptno}'>${k.dname}</option>
													
		</c:otherwise>				
	</c:choose>				
</c:forEach>	
					</select>
				</div>
			</div>	
		
				
		
			<div class="form-group">
				<div class="col-sm-10 col-sm-offset-2">
					<button type="submit" class="btn btn-primary">저장하기</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>


