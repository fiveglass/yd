<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<tiles:insertAttribute name="header" />
	<hr>
	<tiles:insertAttribute name="body" />
	<hr>
	<tiles:insertAttribute name="footer" />

</body>
</html>