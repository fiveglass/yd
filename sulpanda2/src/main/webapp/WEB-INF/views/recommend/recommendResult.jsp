<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/templatemo.css">
    <link rel="stylesheet" href="assets/css/custom.css">
</head>
<body>
 결과창
 <%-- ${option1 }, ${option2 }, ${option3 }
 
 	<c:forEach var=product items=${productVoList }>
 		${product.name }
 		${product.price }
 	</c:forEach>
 	
 	--%>
 	
  <div class="album py-5 bg-light">
    <div class="container">

      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
	      <div class="col">
	          <div class="card shadow-sm">
	            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
	
	            <div class="card-body" align="center">
	              <p class="card-text">술이름</p>
	              <p class="card-text">술이름2</p>
	              <p class="card-text">술이름3</p>
	            </div>
	          </div>
	        </div>
		   		      <div class="col">
		          <div class="card shadow-sm">
		            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
		
		            <div class="card-body">
		              <p class="card-text">술이름</p>
		              <p class="card-text">술이름4</p>
		              <p class="card-text">술이름5</p>
		            </div>
		          </div>
		        </div>		      <div class="col">
		          <div class="card shadow-sm">
		            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
		
		            <div class="card-body">
		              <p class="card-text">술이름</p>
		            </div>
		          </div>
		        </div>
		        
        
      </div>
    </div>
  </div>
 	
 	
</body>
</html>