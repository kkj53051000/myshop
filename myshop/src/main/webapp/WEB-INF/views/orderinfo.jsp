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
		<c:forEach var="info" items="${orderinfos}">
			
			주문번호 : ${info.order.id} 상품명 : ${info.productinfo.product.name} 주문수량 : ${info.amount}
		</c:forEach>
	</div>
	<%@ include file="common/footer.jsp" %>
</body>
</html>