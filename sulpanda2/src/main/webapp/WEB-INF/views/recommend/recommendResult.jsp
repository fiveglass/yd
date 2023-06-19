<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/templatemo.css">
<link rel="stylesheet" href="assets/css/custom.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
	<br>
	<div align="center">
		<img src="assets/img/술추천결과.png" width="1340" height="340">
	</div>
	<br>

	<div class="album py-5 bg-light">
		<div class="container">

			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
			
			<c:forEach var="product" items="${products }">
				<div class="col">
					<div class="card shadow-sm">
  						<img src="${product.productImgPath }" width="100%" height="100%"/>

						<div class="card-body" align="center">
							<p class="card-text">${product.productName }</p>
							<p class="card-text">${product.productKind }</p>
							<p class="card-text">${product.productPrice }</p> 
						</div>
					</div>
				</div>
			</c:forEach>
				
			</div>
		</div>
	</div>


</body>
</html>