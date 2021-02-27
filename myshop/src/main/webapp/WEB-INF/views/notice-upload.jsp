<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<div>
		<h1>공지사항 작성</h1>
		<form action="/notice/upload" method="POST" enctype="multipart/form-data">
			제목 : <input name = "title"/><br/>
			내용 : <input name = "content"/><br/>
			사진 : <input name="img" type="file"/><br/>
			<button>업로드</button>
		</form>
	</div>
	<%@ include file="common/footer.jsp" %>
</body>
</html>