<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.product_wrap{
			height: 1300px;
			width: 100%;
			min-width: 1600px;
			
			margin-top: 50px;
			
			display: flex;
			flex-direction: column;
			align-items: center;
		}
		.product_top{
			width: 100%;
			
			display: flex;
			flex-direction: row;
			justify-content: center;
		}
		.product_main{
			width: 80%;
			
			min-width: 1600px;
			
			display: flex;
			flex-direction: row;
			
			flex-wrap: wrap;
			
		}
		.prdout_img{
			box-sizing: border-box;
			
			height: 449px;
			width: 348px;
		}
		.product{
			width: 25%;
			display: flex;
			flex-direction: column;
			align-items: center;
			margin-bottom: 20px;
		}
		.product_info{
			width: 348px;
		}
	</style>
</head>
<body>
	<%@ include file="common/header.jsp" %>
	
	<div class="product_wrap">
		<div class="product_top">
			<h1>${category}</h1>
		</div>
		<br/>
		<div class="product_main">
			<c:forEach var="product" items="${products}">
				<div class="product">
					<div>
						<a href="/product?id=${product.id}"><img class="prdout_img" src="${product.img_src}"/></a>
					</div>
					<div class="product_info">
						<div>
							<a href="/product?id=${product.id}">${product.name}</a>
						</div><br/>
						<div class="pr_price" style="font-weight: bold">
							${product.price}원
						</div>
					</div>
					
				</div>
				
			</c:forEach>
		</div>
		
	</div>
  
	<script type="text/javascript">
			/*
			const price = document.getElementById(pr_price).value;
			console.log(price)
			alert(price.textContent)
			
			const items = document.querySelectorAll('.pr_price')
			for(let i = 0; i < items.length; i++){
			    items[i].innerText = items[i].innerText + "구분기호가 들어간 텍스트"
			}
			*/
	</script>
	
	<%@ include file="common/footer.jsp" %>
</body>
</html>