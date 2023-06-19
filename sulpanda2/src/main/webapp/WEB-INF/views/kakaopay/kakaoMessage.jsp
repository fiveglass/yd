<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<c:if test="${status == 'success' }">
	<br>
	<div align ="center">
		<h2> 요청하신 ${orderNo }건의</h2>
		<h2> 결제 완료 되었습니다. </h2>
	</div>
	<br>
</c:if>
	
<c:if test="${status == 'cancel' }">
	<br>
	<div align ="center">
		<h2> 결제가 취소되었습니다. </h2>
	</div>
	<br>
</c:if>

<c:if test="${status == 'fail' }">
	<br>
	<div align ="center">
		<h2> 결제가 실패하였습니다. </h2>
		<h2> 다시 결제를 시도해주세요.</h2>
	</div>
	<br>
</c:if>

</body>
</html>