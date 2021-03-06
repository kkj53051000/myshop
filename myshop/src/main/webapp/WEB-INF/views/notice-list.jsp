<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Notice</title>
	</head>
	<style>
		.wrap{
			width: 100%;
		
			display: flex;
			flex-direction: column;
			align-items: center;
			
		}
	</style>
<body>
	<%@ include file="common/header.jsp" %>
	<div class="wrap">
		<h1>공지사항</h1>
		<div class="main">
			<c:forEach var="notice" items="${notices}">
				글 번호 : ${notice.id} 제목 : ${notice.title} 내용 : ${notice.content} <br/>
			</c:forEach>
			<a href="/notice-upload">공지 작성</a>
		</div>
		
	</div>
	<%@ include file="common/footer.jsp" %>
</body>
</html>