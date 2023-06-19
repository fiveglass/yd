<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<style>
	.cart__list__checkbox {
		margin-bottom: 10px; /* 간격을 늘리고자 하는 값으로 조정 */
	}
	
	.cart__list__total {
		background-color: rgba(0, 0, 0, 0.1); /* 회색 불투명 네모 박스의 배경색 지정 */
		padding: 10px; /* 박스 내부의 여백 설정 */
		text-align: center; /* 텍스트 가운데 정렬 */
		margin-top: 20px; /* 네모 박스와 line 사이의 간격 조정 */
	}

	.cart__list__total p {
		margin: 0; /* 문단의 위아래 여백 제거 */
	}

	.cart__list__line {
		border-top: 1px solid #ccc; /* line의 스타일 설정 */
		margin-top: 20px; /* line 위쪽 간격 조정 */
		margin-bottom: 20px; /* line 아래쪽 간격 조정 */
	}



</style>

<head>
	<link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">  
	<link rel="stylesheet" href="assets/css/cart.css">

<meta charset="UTF-8">
<title>장바구니</title>
</head>

<body>

    <section class="cart">
    
        <div class="cart__information">
            <ul>
                <li>장바구니예여</li>
                <li>장바구니 배송 안내문구</li>
            </ul>
        </div>
        
        <div><h2>장바구니</h2></div>
<div>
	<table class ="cart__list">
			<form>
			
		<thead>
	    <tr>
	        <th width="50" class="cart__list__checkbox"> <!-- Reduce width to 50px -->
	            <input type="checkbox" class="individual_cart_checkbox input_size_" onclick="checkAll()">
	        </th>
	        <th width="150">상품명</th>
	        <th width="150">개수</th>
	        <th width="150">단가</th>
	    </tr>
		</thead>
			
		<tbody>
			<tr class="cart__list__detail">
			<c:set var = "sum" value = "0" />
				<c:forEach items="${carts}" var="c">
					<tr>
						<td width="150" align="center" class="cartCheckbox"><input type="checkbox" value="${c.cartId }" name="checkBox">&nbsp;</td>
						<td width="150" align="center">${c.productName}</td>
						<td width="150" align="center"><input type='button' onclick='minus(${c.cartId}, ${c.productFee }, event)' value='-'/><input value="${c.productCount}"><input type='button' onclick='plus(${c.cartId}, ${c.productFee }, event)' value='+'/></td>
						<td width="150" align="center">${c.productFee}</td>
					</tr>
					<c:set var= "sum" value="${sum + c.productCount * c.productFee}"/>
				</c:forEach>
			</tr>
		</tbody>
		
		<tfoot>
			<tr>
				<td>
					
					<button class="cart__list__optionbtn" onclick="deleteItem()">선택상품 삭제</button>
				</td>
				<td>
					<div class="cart__list__total">
						총 주문 금액: <p id="sum2"><c:out value="${sum}"/> </p>
					</div>
				</td>
			</tr>
		</tfoot>

		</form>
	</table>
</div>

    <div class="cart__mainbtns">
        <a href="cartList.do"><button class="cart__bigorderbtn left">쇼핑 계속하기</button></a>
        <a><button class="cart__bigorderbtn right"onclick="order()">주문하기</button></a>
    </div>   
    </section>
    <script>
    	function minus(id, price, event){
    		if(event.target.nextSibling.value <= 1){
    			alert("더이상 내릴 수 없습니다.");
    		} else {
    			//앞단(수량, 총가격)
    			let num = parseInt(event.target.nextSibling.value)-1;
    			event.target.nextSibling.value = num;
    			let sum2 = document.getElementById("sum2");
    			num = parseInt(sum2.textContent);
    			num = num-price;
    			
    			sum2.textContent = num;
    			
    			//뒷단
    			let url = "ajaxCountMinus.do?id=" + id;
    			
    			fetch(url)
    				.then(response => reseponse.text());
    		}
    		
    	}
    	
    	function plus(id, price, event){
    		//앞단(수량, 총가격)
    		let num = parseInt(event.target.previousSibling.value)+1;
    		event.target.previousSibling.value = num;
    		let sum2 = document.getElementById("sum2");
			num = parseInt(sum2.textContent);
			num = num+price;
			
			sum2.textContent = num;
	
    		//뒷단
    		let url = "ajaxCountPlus.do?id=" + id;
    		
    		fetch(url)
    			.then(response => response.text());
    	}
    	
    	 function deleteItem(){
             let ckb = document.querySelectorAll('input[type=checkbox]:checked');
          
             //기본 반복문
             for(let i = ckb.length-1; i>=0; i--){
                 let id = ckb[i].value;
                 let url = "ajaxCartDelete.do?id=" + id;
                 
                 fetch(url)
                 	.then(response => response.text())
                  	.then(text=>htmlProcess(text));
           
             }
             for(let i = ckb.length-1; i>=0; i--){
                 
                 ckb[i].parentNode.remove();
             }
             
            
         }
    	 
    	 function checkAll(){
    		 let ckb = document.querySelectorAll('input[type=checkbox]');
    		 
    		 for(let i = 0; i<ckb.length; i++){
             	if(ckb[i].checked){
             		ckb[i].checked = false;
             	} else if(!ckb[i].checked) {
             		ckb[i].checked = true;
             	}
             }
    	 }
    	 
    	 function htmlProcess(data){
    		 
    	 }
    	 
    	 function order(){
    		 let query = 'input[name="checkBox"]:checked';
    		 let selectProduct = document.querySelectorAll(query);
    		 
    		 let selectProductLength = selectProduct.length;
    		 if(selectProductLength == 0) {
    			alert('구매하실 제품을 선택해주세요.');	 
    			return;
    		 }
    		 
    		 let cartId = '';
    		 selectProduct.forEach((el)  => {
    			 cartId += el.value + ',';
    		 });
    		 
    		 cartId = cartId.slice(0, -1);
    		 
    		 location.href = "/meddle/paymentOrder.do?cartId="+cartId;
    		 
    	 }
    </script>

</body>
</html>