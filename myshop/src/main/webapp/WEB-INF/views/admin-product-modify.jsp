<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		.product_wrap{
			height: 1000px;
			width: 100%;
			
			display: flex;
			flex-direction: column;
		}
		.product_top{
			width: 100%;
			margin-top: 50px;
			
			display: flex;
			flex-direction: row;
			justify-content: center;
		}
		.prdout_img{
			height: 700px;
			width: 600px;
		}
		.product_data{
			margin-left: 100px;
		}
		.product_bottom{
			width: 100%;
			
			display: flex;
			flex-direction: column;
			justify-content: center;
		}
	</style>
</head>
<body>
<%@ include file="common/header.jsp" %>
<div class="product_wrap">
	<div class="product_top">
		<div>
			<img class="prdout_img" src="${product.img_src}"/>
		</div>
		<div class="product_data">
			<div class="product_name">
				<h1>${product.name}</h1>
			</div>
			<div class="product_info">
				<p>제품 설명</p>
				<p>감각적인 프론트 디자인으로 베이직하면서도 캐주얼한 감성도 갖췄습니다.</p>
				<b>가격</b> <p>${product.price}</p>
			</div>
		</div>
	</div>
	<div class="product_bottom">
		<form action="/productinfo" method="POST">
			<span>컬러</span>
		    <select name="color">
		        <option value="BLACK">블랙</option>
		        <option value="WHITE">화이트</option>
		        <option value="BLUE">블루</option>
		    </select>
		    <span>사이즈</span>
		    <select name="size">
		        <option value="S">S</option>
		        <option value="M">M</option>
		        <option value="L">L</option>
		    </select>
		    <br/>
		    <span>수량</span> <input name="amount"/><br>
		    <span>추가 가격</span> <input name="add_price" value="0">
		    <input type="hidden" name="id" value="${product.id}">
		    <button class="add_btn">추가</button>
		</form>
		<h1>상품 상세목록</h1>
		<c:forEach var="info" items="${productinfos}">
			색상 : ${info.color} 사이즈 : ${info.size} 수량 : ${info.amount}<br/>
		</c:forEach>
	</div>
</div>
	
	
	<%@ include file="common/footer.jsp" %>
	
	<!-- 
	<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
	
	<script type="text/javascript">

    

    document.querySelector('.add_btn').addEventListener('click', function() {
        const color_target = document.getElementById("color");
        const color_targetValue = document.getElementById("color").options.selectedIndex;
        
        const size_target = document.getElementById("size");
        const size_targetValue = document.getElementById("size").options.selectedIndex;

        const color_value = color_target.options[color_targetValue].value;
        const size_value = size_target.options[size_targetValue].value;

        const amount_value = document.getElementById("amount").value;

        console.log(color_value)
        console.log(size_value)
        console.log(amount_value)
        
        $.ajax({
				type : 'GET',
				data : {color : color_value, size : size_value, amount : amount_value },
				url : 'http://localhost:8080/colorsize',
				error : function(error){
				},
				success : function(data){
					
				},
				
			});
        
        })
    </script>
    
     -->
</body>
</html>