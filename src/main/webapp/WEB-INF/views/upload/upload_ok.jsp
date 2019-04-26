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
	<div class="container">
		<h1 class="page-header">Upload Result</h1>
		
		<h2>${memo}</h2>
		
		<!-- 업로드 된 파일 목록 출력 처리 -->
		<c:forEach var="item" items="${fileList}" varStatus="status">
			<!-- 원본 파일명 + 다운로드 링크  -->
			<h3>
				<c:url value="/download.do" var="download_url">
					<c:param name="file" value="${item.fileDir}/${item.fileName}"></c:param>
				</c:url>
				<a href="${download_url}">${item.originName}</a>
			</h3>
			<!-- 파일 정보 표시 -->
			<div class="alert alert-info">
				fileDir: ${item.fileDir}<br />
				fileName: ${item.fileName}<br />
				contentType: ${item.contentType}<br />
				fileSize: ${item.fileSize}
				
				<!-- 이미지인 경우 썸네일 요청 -->
				<c:if test="${fn:indexOf(item.contentType, 'image') > -1}">
					<c:url value="../download.do" var="download_url">
						<c:param name="file" value="${item.fileDir}/${item.fileName}"></c:param>
						<c:param name="width" value="240"></c:param>
						<c:param name="height" value="240"></c:param>
					</c:url>
					<hr />
					<img src="${download_url}" class="img-responsive" />
				</c:if>
			</div>
			<hr />
		</c:forEach>
	</div>
</body>
</html>


