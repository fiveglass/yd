<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<tiles:insertAttribute name="header"/>
</head>
<header>
	<jsp:include page = "productmenu.jsp"></jsp:include>
</header>
<body>

</body>
<tiles:insertAttribute name="footer"/>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>


    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">

    
        <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">

</head>
<body>
	<tiles:insertAttribute name="header" />
	
	<div align="center">
	<div><h1>제 품 등 록</h1></div>
	<div>
		<form id="frm" action="productInsert.do" method="post" enctype="multipart/form-data">
			<div>
				<table border="1">
					<tr>
						<th width="100">상품 번호</th>
						<td width="100">
							<input type="text" id="productId" name="productId" required="required">
						</td>
					</tr>
					<tr>
						<th>상품 이름</th>
						<td>
							<input type="text" id="productName" name="productName" required="required">
						</td>
					</tr>
					<tr>
						<th>상품 종류</th>
						<td>
							<input type="text" id="productKind" name="productKind" required="required">
						</td>
					</tr>
					<tr>
						<th>상품 이미지</th>
						<td>
							<input type="file" id="pfile" name="pfile">
						</td>
					</tr>
					<tr>
						<th>상품 가격</th>
						<td>
							<input type="text" id="productPrice" name="productPrice" required="required">
						</td>
					</tr>
					<tr>
						<th>상품 당도</th>
						<td>
							<input type="text" id="productTaste" name="productTaste" required="required">
						</td>
					</tr>
					<tr>
						<th>탄산 유무</th>
						<td>
							<input type="text" id="productSparkling" name="productSparkling" required="required">
						</td>
					</tr>
					<tr>
						<th>상품 도수</th>
						<td>
							<input type="text" id="productABV" name="productABV" required="required">
						</td>
					</tr>
					
				</table>
			</div><br>
			<div>
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="취소">&nbsp;&nbsp;
			</div>
		</form>
	</div>
</div>
	
	<tiles:insertAttribute name="footer" />
</body>


</html>