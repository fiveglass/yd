<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<jsp:include page="../main/menu.jsp" />
	<div><h1>회원목록보기</h1></div>
	<div>
		<c:forEach items = "${members }" var = "m">
			${m.memberId } : ${m.memberPassword } : ${m.memberAge } :
			${m.memberTel } : ${m.memberGender } <br>
		</c:forEach>
	</div>
		<div>
			<a href="memberJoin.do">회원가입</a>
		</div>
	</div>
</body>
</html>