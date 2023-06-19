<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<style>
  .table {
    max-width: 50%; /* 원하는 크기로 조정 */
    margin: 0 auto; /* 가운데 정렬을 위해 margin을 auto로 설정 */
  }
</style>
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
	<div align ="center">
		<h1> 주문이 완료되었습니다.</h1>
		<h3> 아래를 참고하시어 결제 바랍니다.</h3>
		<br>
		<table class="table">
  			<thead class="table-dark bordered">
			   <tr>
			   	   <th colspan="2" style="text-align: center;">주문정보</th>
			   <tr>
			</thead>
			<tbody>
			    <tr>
			    	<td>주문번호</td>
			    	<td>${orderId }</td>
			    </tr>
			    <tr>
			    	<td>주문금액</td>
			    	<td>${orderPrice }</td>
			    </tr>
			    <tr>
			    	<td>입금은행</td>
			    	<td>예담은행</td>
			    </tr>
			    <tr>
			    	<td>계좌번호</td>
			    	<td>1234-1234-1234</td>
			    </tr>
			</tbody>
		</table>
	</div>
</body>
</html>