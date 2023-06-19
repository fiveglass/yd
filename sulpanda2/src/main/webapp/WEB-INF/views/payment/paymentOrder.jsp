<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<style>
	.cart__list__total {
		background-color: rgba(0, 0, 0, 0.1); /* 회색 불투명 네모 박스의 배경색 지정 */
		padding: 10px; /* 박스 내부의 여백 설정 */
		text-align: center; /* 텍스트 가운데 정렬 */
		margin-top: 20px; /* 네모 박스와 line 사이의 간격 조정 */
		margin-left:auto;
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
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">  
	<link rel="stylesheet" href="assets/css/cart.css">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
<br>
<section class="cart">  
<div><h2> 주문하기</h2></div><br>
<div>    
<form>
	<table class ="cart__list">
		<thead>
	    <tr>
	        <th width="150">상품명</th>
	        <th width="150">개수</th>
	        <th width="150">단가</th>
	    </tr>
		</thead>
			
		<tbody>
			<tr class="cart__list__detail">
			<c:set var = "sum" value = "0" />
				<c:forEach var="order" items="${cartproducts }">
					<tr>
						<td width="150" name="productName" align="center">${order.productName}</td>
						<td width="150" name="productCount" align="center">${order.productCount }</td>
						<td width="150" align="center">${order.productFee }</td>
					</tr>
					<c:set var= "sum" value="${sum + order.productCount * order.productFee}"/>
				</c:forEach>
			</tr>
			<input type="hidden" id="cartId" value="${cartId }">
		</tbody>
		
		<tfoot>
			<tr>
				<td colspan="3">
				<div class="cart__list__total">
					총 주문 금액 <span id="sum2"><c:out value="${sum} 원"/> </span>
				</div>
				</td>
			</tr>
		</tfoot>
	 </table>
</form>
</div>
<br>
<div><h2> 배송정보 </h2></div>
<hr>
  <div class="mb-3 row">
    <label for="memberId" class="col-sm-2 col-form-label">주문자</label>
    <div class="col-sm-10">
		<c:set var="firstVO" value="${cartproducts[0]}" />
		<c:set var="memberId" value="${firstVO.memberId}" />
      <input type="text" readonly class="form-control-plaintext" id="memberId" value="${memberId }">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="ample6_postcode" class="col-sm-2 col-form-label">주소</label>
      <div class="col-auto">
    <label for="ample6_postcode" class="visually-hidden">우편번호</label>
    <input type="text" class="form-control" id="sample6_postcode" name="sample6_postcode" placeholder="우편번호">
  </div>
  <div class="col-auto">
    <button type="submit" class="btn btn-secondary mb-3" onclick="sample6_execDaumPostcode()">우편번호 검색</button>
  </div>
   <div class="mb-3 row">
    <label for="sample6_address" class="col-sm-2 col-form-label"></label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="sample6_address" name="sample6_address" placeholder="주소">
    </div>
  </div>
   <div class="mb-3 row">
    <label for="sample6_detailAddress" class="col-sm-2 col-form-label"></label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="sample6_detailAddress" name="sample6_detailAddress" placeholder="상세주소">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="sample6_extraAddress" class="col-sm-2 col-form-label"></label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="sample6_extraAddress" name="sample6_extraAddress" placeholder="참고주소">
    </div>
  </div>
  </div>
  <div class="mb-3 row">
    <label for="membertel" class="col-sm-2 col-form-label">휴대전화</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="membertel">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="deliveryMessage" class="col-sm-2 col-form-label">배송메세지</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="deliveryMessage">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="paymentType" class="col-sm-2 col-form-label">결제수단</label>
	    <div class="col-sm-10">
		  <div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="paymentType" id="kakao" value="kakao">
			  <label class="form-check-label" for="inlineRadio1">카카오결제</label>
		  </div>
		  <div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="paymentType" id="deposit" value="deposit">
			  <label class="form-check-label" for="inlineRadio2">무통장입금</label>
		  </div>
	</div>
  </div><hr>
  <div align ="center">
  	<button type="button" onclick="movePayment()" class="btn btn-secondary btn-lg">결제하기</button>
  </div>

</section>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수
                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }
                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>
<script>
	function movePayment() {
		
		let orderNo = getOrderNo();
		let totalPrice = getTotalPrice();
		let totalQuantity = getTotalQuantity();
		let productName = getProductName();
		let encodedProductName = encodeURIComponent(productName);
	    let radios = document.getElementsByName("paymentType");
	    let selectedPaymentType = Array.from(radios).find(radio => radio.checked);
	    let address = document.getElementById('sample6_address').value + ", " + document.getElementById('sample6_detailAddress').value;
	    let encodedAddress = encodeURIComponent(address);
	    let membertel = document.getElementById('membertel').value;
	    let deliveryMessage = document.getElementById('deliveryMessage').value;
	    let encodedDeliveryMessage = encodeURIComponent(deliveryMessage);
	    let cartId = document.getElementById("cartId").value;
	    
		if(selectedPaymentType.value == 'kakao') {
			location.href = "/meddle/kakaopay.do?orderNo=" + orderNo + "&totalPrice=" + totalPrice + "&productName=" + encodedProductName + "&totalQuantity=" + totalQuantity + '&address=' + encodedAddress + '&membertel=' + membertel + '&deliveryMessage=' + encodedDeliveryMessage + '&cartId=' + cartId;
			
			
		} else if(selectedPaymentType.value == 'deposit') {
			location.href = "/meddle/depositMessage.do?orderNo=" + orderNo + "&totalPrice=" + totalPrice + '&address=' + encodedAddress + '&membertel=' + membertel + '&deliveryMessage=' + encodedDeliveryMessage + '&cartId=' + cartId;
		}
		
		
	}
	
	// 주문번호 생성
	function getOrderNo() {
		let now = new Date();
		let year = now.getFullYear();
		let month = ('0' + (now.getMonth() + 1)).slice(-2);
		let day = ('0' + now.getDate()).slice(-2);
		
		let randomNum = getRandomNumber();
		let formattedNum = formatNumber(randomNum);
		
		let orderNo = year + month + day + '_' + formattedNum;
		
		return orderNo;
	}
	
	function getTotalPrice() {
		let totalPrice = document.getElementById('sum2').innerText;
		totalPrice = totalPrice.replaceAll(' ', '');	//	공백 제거
		totalPrice = totalPrice.replaceAll('원', '');	//	'원' 문자 제거
		
		return totalPrice;
	}
	
	function getTotalQuantity() {
		  let tdElements = document.getElementsByName("productCount"); // name 속성이 "productCount"인 모든 <td> 요소를 선택
		  let sum = 0; // 합산을 저장할 변수
		  
		  for (var i = 0; i < tdElements.length; i++) {
		    let tdValue = parseInt(tdElements[i].innerText); // <td> 요소의 내용을 숫자로 변환하여 가져옴
		    sum += tdValue; // 숫자를 합산
		  }
		  
		  return sum;
	}
	
	function getProductName() {
		let productElements = document.getElementsByName("productName");
		let productName;
		
		if(productElements.length == 1) {
			productName = productElements[0].innerText;
			
			return productName;
		}
		
		productName = productElements[0].innerText + ' 외 ' + (productElements.length - 1) + '건';
		
		return productName;
	}
	
	function getCartId() {
		let cartIdElements = document.getElementsByName("cartId");
		let cartId;
		
		for (var i = 0; i < cartIdElements.length; i++) {
			cartId = cartIdElements[i].value + ",";
		}
		cartId.slice(0, -1);
		
		return cartId;
	}
	
	// 1부터 999999까지의 숫자를 랜덤으로 뽑는 함수
	function getRandomNumber() {
	  // Math.random() 함수를 사용하여 0 이상 1 미만의 랜덤한 소수를 생성
	  let randomDecimal = Math.random();
	  
	  // 0 이상 999998 미만의 랜덤한 정수를 생성
	  let randomNumber = Math.floor(randomDecimal * 999998);
	  
	  // 생성된 정수에 1을 더하여 1부터 999999까지의 숫자를 얻음
	  let result = randomNumber + 1;
	  
	  return result;
	}
	
	// 숫자를 랜덤으로 생성하여 6자리로 표현하고 앞에 0을 채우는 형식으로 변환
	function formatNumber(number) {
	  return number.toString().padStart(6, '0');
	}

</script>
</body>
</html>