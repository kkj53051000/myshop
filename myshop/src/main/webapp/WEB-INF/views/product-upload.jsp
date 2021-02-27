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
	<br>
	<div>
		<h1>상품 등록</h1>
		<form action="/product/upload" method="POST" enctype="multipart/form-data">
			제품명 : <input name="name"/><br/>
			카테고리
			<SELECT name="category" size=1>
		        <OPTION VALUE="OUTER" SELECTED>OUTER</OPTION>
		        <OPTION VALUE="TOP">TOP</OPTION>
		        <OPTION VALUE="SHIRT">SHIRT</OPTION>
		        <OPTION VALUE="PANTS">PANTS</OPTION>
		    </SELECT><br/>
		   	제품 설명 :<br/> <textarea name="info" cols="50" rows="10"></textarea><br/>
			가격 : <input name="price"/><br/>
			제품 이미지 : <input name="img" type="file"/><br/>
			<button>등록</button>
		</form>
	</div>
	<br>
	<%@ include file="common/footer.jsp" %>
</body>
</html>