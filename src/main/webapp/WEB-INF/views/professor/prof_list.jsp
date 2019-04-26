<!-- 
	author : 임형진
	fileName : MVC구현평가_교수.pdf
	content : 교수 목록을 조회하는 jsp
	lastUpdate : 2019-03-26

-->

<%@page import="java.net.URLEncoder"%>
<%@page import="study.spring.helper.PageHelper"%>
<%@page import="study.spring.hellospring.model.ProfessorDepartment"%>
<%@page import="study.spring.hellospring.service.impl.ProfessorJoinServiceImpl"%>
<%@page import="study.spring.hellospring.service.ProfessorJoinService"%>
<%@page import="java.util.List"%>
<%@page import="study.spring.helper.WebHelper"%>
<%@page import="study.spring.hellospring.service.impl.ProfessorServiceImpl"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
			<h1 class="pull-left">교수목록</h1>
			
			<div class="pull-right" style='margin-top: 30px'>
				<form method="get" action="${pageContext.request.contextPath}/professor/prof_list.do" style="width: 300px;">
					<div class="input-group">
						<input type="text" name='keyword' class="form-control"
						placeholder="교수이름 검색" value="${keyword}" />
						<span class="input-group-btn">
							<button class="btn btn-success" type="submit">
								<i class='glyphicon glyphicon-search'></i>
							</button>
							<a href="${pageContext.request.contextPath}/professor/prof_add.do" class="btn btn-primary">교수추가</a>
						</span>
					</div>
				</form>				
			</div>
		</div>
	

		<!-- 조회결과를 출력하기 위한 표 시작 -->
		<table class="table">
			<thead>
				<tr>
					<th class="info text-center">교수번호</th>
					<th class="info text-center">이름</th>
					<th class="info text-center">아이디</th>
					<th class="info text-center">직급</th>
					<th class="info text-center">급여</th>
					<th class="info text-center">보직수당</th>
					<th class="info text-center">입사일</th>
					<th class="info text-center">소속학과</th>					
				</tr>
			</thead>
			<tbody>
<c:choose>
	<c:when test="${fn:length(list) > 0}">
		<c:forEach var="item" items="${list}">
				<tr>
					<td class="text-center">${item.profno}</td>
					<td class="text-center">
						<c:url var="readUrl" value="/professor/prof_view.do">
							<c:param name="profno" value="${item.profno}" />
						</c:url>
						<a href="${readUrl}">
							${item.name}
						</a>						
					</td>
					<td class="text-center">${item.userid}</td>
					<td class="text-center">${item.position}</td>
					<td class="text-center">${item.sal}</td>
					<td class="text-center">${item.comm}</td>
					<td class="text-center">${item.hiredate}</td>
					<td class="text-center">${item.dname}</td>
					
				</tr>
		</c:forEach>
	</c:when>

	<c:otherwise>
				<tr>
					<td colspan="8" class="text-center">조회된 데이터가 없습니다.</td>
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
	<c:when test="${page.prevPage> 0}">
		<!-- 이전 그룹에 대한 페이지 번호가 존재한다면?  -->
		<!-- 이전 그룹으로 이동하기 위한 URL을 생성해서 "prevUrl"에 저장 -->
				<c:url var="prevUrl" value="/professor/prof_list.do">
					<c:param name="keyword" value="${keyword}" />
					<c:param name="page" value="${page.prevPage}" />
				</c:url>
				
				<li>
					<a href="${prevUrl}">
						<span>&laquo;</span>	
					</a>
				</li>
	</c:when>
	<c:otherwise>				
				<li class="disabled">
					<a href="#">&laquo;</a>
				</li>
	</c:otherwise>
</c:choose>				
<c:forEach var="i" begin="${page.startPage}" end="${page.endPage}" varStatus="s" step="1">
	<!-- 각 페이지 번호로 이동할 수 있는 URL을 생성하여 page_url에 저장 -->
	<c:url var="pageUrl" value="/professor/prof_list.do">
					<c:param name="keyword" value="${keyword}" />
					<c:param name="page" value="${i}" />
	</c:url>
	
	
	<c:choose>			
		<c:when test="${page.page == i}">
				<li class="active">
					<a href="#">
						${i}	
					</a>
				</li>
		</c:when>
		<c:otherwise>
				<li>
					<a href="${pageUrl}">${i}</a>
				</li>
		</c:otherwise>
	</c:choose>
</c:forEach>				
<c:choose>
	<c:when test="${page.nextPage> 0}">
		<!-- 다음 그룹에 대한 페이지 번호가 존재한다면?  -->
		<!-- 다음 그룹으로 이동하기 위한 URL을 생성해서 "nextUrl"에 저장  -->
		
		<c:url var="nextUrl" value="/professor/prof_list.do">
					<c:param name="keyword" value="${keyword}" />
					<c:param name="page" value="${page.nextPage}" />
		</c:url>
				<li>
					<a href="${nextUrl}">
						&raquo;	
					</a>
				</li>
	</c:when>
	<c:otherwise>
				<li class="disabled">
					<a href="#">&raquo;</a>
				</li>
	</c:otherwise>
</c:choose>
			</ul>
		</nav>
	</div>
</body>
</html>


