<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
	.container {
		display: flex;
		justify-content: center;
	}

	.container img {
		flex: 1;
		max-width:200px;
		max-height: 200px;
		object-fit: cover; /* 이미지 비율 유지 및 정사각형으로 표시 */
		width:200px; /* 이미지 너비를 100px로 지정 */
		height: 200px; /* 이미지 높이를 100px로 지정 */
		margin: 20px;
	}
</style>
<head>
<link rel="apple-touch-icon" href="assets/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">

    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
    
<link rel="stylesheet" href="assets/css/cart.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<tiles:insertAttribute name="header"/>

	<section>
	<br>
	<div class="container">
	<a  href="주문내역"><img src="assets/img/002.png"></a>
	<a  href="회원 정보 수정"><img src="assets/img/003.png"></a>
	<a  href="회원탈퇴"><img src="assets/img/001.png"></a>
</div><br><br>
	
	
	
	<div class="row">
  <div class="col-sm-6 mb-3 mb-sm-0">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">회원 이름</h5>
        <p class="card-text"><c:forEach items = "${member}" var = "m">
					<tr>
						<td>김예담</td><p>
						<td>010123456</td><p>
						<td>대구시 수성구</td><p>
						<td>1등급</td>
						
						
						<%-- <td>${m.memberName } </td>
						<td>${m.memberTel }</td>
						<td>${m.memberAddress }</td>
						<td>${m.memberGrade }</td> --%>
					</tr>
				</c:forEach></p>
       
      </div>
    </div>
  </div>
  
  
  <div class="col-sm-6">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">총 주문 건수</h5>
        <p class="card-text">총 주문 금액</p>
        
      </div>
    </div>
  </div>
</div>


	
	</div>
	</div>
	
	<br><br>
	</section>
<tiles:insertAttribute name="footer"/>
</body>
</html>