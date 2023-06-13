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
	<a  href="productInsert.do"><img src="assets/img/005.png"></a>
	<a  href="productInsert.do"><img src="assets/img/004.png"></a>
	<a  href="productInsert.do"><img src="assets/img/006.png"></a>
</div><br><br>
<!-- 	<a class="nav-link" href="productInsert.do">상품관리</a>
	<a class="nav-link" href="about.html">회원 관리</a>
	<a class="nav-link" href="about.html">게시판 관리</a> -->
	
	</div><p>

	<br><br>
	<div align="center">
	 <div class="col-sm-6 mb-3 mb-sm-0">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">판매내역(정산)</h5>
        <p class="card-text">
        <c:forEach items = "${member}" var = "m">
					
						하루 정산 금액 : <p>
						어쩌고 저쩌고
						
						
						<%-- <td>${m.memberName } </td>
						<td>${m.memberTel }</td>
						<td>${m.memberAddress }</td>
						<td>${m.memberGrade }</td> --%>
					
				</c:forEach></p>
       </div>
      </div>
    </div>
  </div>
  <br><br>
	</section>
<tiles:insertAttribute name="footer"/>
</body>
</html>