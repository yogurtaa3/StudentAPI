<%@page import="study.spring.helper.PageHelper"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="study.spring.hellospring.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="study.spring.helper.WebHelper"%>
<%@page import="study.spring.hellospring.service.StudentService"%>
<%@page import="study.spring.hellospring.service.impl.StudentServiceImpl"%>

<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
<%@ include file="/WEB-INF/views/inc/navbar.jsp" %>
	<div class="container">
		<div class="page-header clearfix">
			<h1 class="pull-left">학생목록</h1>
			<div class="pull-right" style='margin-top: 30px'>
				<form method="get" action="${pageContext.request.contextPath}/student/stud_list.do" style="width: 300px;">
					<div class="input-group">
						<input type="text" name='keyword' class="form-control"
						placeholder="학생이름 검색" value="${keyword}" />
						<span class="input-group-btn">
							<button class="btn btn-success" type="submit">
								<i class='glyphicon glyphicon-search'></i>
							</button>
							<a href="${pageContext.request.contextPath}/student/stud_add.do" class="btn btn-primary">학생추가</a>
						</span>
					</div>
				</form>				
			</div>
		</div>

		<!-- 조회결과를 출력하기 위한 표 시작 -->
		<table class="table">
			<thead>
				<tr>
					<th class="info text-center">학생번호</th>
					<th class="info text-center">이름</th>
					<th class="info text-center">아이디</th>
					<th class="info text-center">학년</th>
					<th class="info text-center">주민번호</th>
					<th class="info text-center">생년월일</th>
					<th class="info text-center">전화번호</th>
					<th class="info text-center">키</th>
					<th class="info text-center">몸무게</th>
					<th class="info text-center">소속학과</th>
					<th class="info text-center">교수번호</th>
				</tr>
			</thead>
			<tbody>
			
<c:choose>
	<c:when test="${fn:length(list) > 0}">
		<c:forEach var="item" items="${list}">
			<tr>
				<td class="text-center">${item.studno}</td>
				<td class="text-center">
					<a href="${pageContext.request.contextPath}/stud/stud_view.do?studno=${item.studno}">
						${item.name}
					</a>						
				</td>
				<td class="text-center">${item.userid}</td>
				<td class="text-center">${item.grade}</td>
				<td class="text-center">${item.idnum}</td>
				<td class="text-center">${item.birthdate}</td>
				<td class="text-center">${item.tel}</td>
				<td class="text-center">${item.height}</td>
				<td class="text-center">${item.weight}</td>
				<td class="text-center">${item.dname}</td>
				<td class="text-center">${item.pname}</td>
					
			</tr>
		</c:forEach>	
	</c:when>
	<c:otherwise>
		<tr>
			<td colspan="12" class="text-center">조회된 데이터가 없습니다.</td>
		</tr>
	</c:otherwise>	
</c:choose>
				

				
			
			</tbody>
		</table>
		<!--// 조회결과를 출력하기 위한 표 끝 -->
		
		<!-- 페이지 번호 -->

		<nav class="text-center">
			<ul class="pagination">
				<!-- 이전 그룹 -->
<c:choose>
	<c:when test="${page.prevPage> 0} ">
				<li>
					<a href="${pageContext.request.contextPath}/student/stud_list.do?page=${page.prevPage}&keyword=${keyword}">
						<span>&laquo;</span>	
					</a>
				</li>
	</c:when>
	<c:otherwise>				
				<li class="disabled">
					<a href="#"><span>&laquo;</span></a>
				</li>
	</c:otherwise>
</c:choose>				
<c:forEach begin="${page.startPage}" end="${page.endPage}" varStatus="s">
	<c:choose>			
		<c:when test="${s.index == page.page}">
				<li class="active">
					<a href="#">
						${s.index}	
					</a>
				</li>
		</c:when>
		<c:otherwise>
				<li>
					<a href="${pageContext.request.contextPath}/student/stud_list.do?page=${s.index}&keyword=${keyword}">${s.index}</a>
				</li>
		</c:otherwise>
	</c:choose>
</c:forEach>				
<c:choose>
	<c:when test="${page.nextPage > 0}">
				<li>
					<a href="${pageContext.request.contextPath}/student/stud_list.do?page=${page.nextPage}&keyword=${keyword}">
						<span>&raquo;</span>	
					</a>
				</li>
	</c:when>
	<c:otherwise>
				<li class="disabled">
					<a href="#"><span>&raquo;</span></a>
				</li>
	</c:otherwise>
</c:choose>
			</ul>
		</nav>
	</div>
</body>
</html>


