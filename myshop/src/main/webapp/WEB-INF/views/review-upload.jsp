<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>
		<div>
			<form action="/review/uplaod" method="POST">
				내용 : <input name="content"/><br/>
				<input name="img" type="file" multiple="multiple"/><br/>
				<input name="productid" type="hidden" value="${product.id}"/><br/>
				<button>작성</button>
			</form>
		</div>
	</div>
	
</body>
</html>