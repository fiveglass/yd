<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<jsp:include page="../main/menu.jsp" />
		<div><h1>로 그 인</h1></div>
		<form id="frm" action="memberLogin.do" onsubmit = "return formCheck()" method="get">
			<div>
				<table border="1">
					<tr>
						<th width="150"> 아이디 </th>
						<td width="300">
							<input type="email" id="memberId" name="memberId">
						</td>
					</tr>
					<tr>
						<th width="150"> 비밀번호 </th>
						<td width="300">
							<input type="password" id="memberPassword" name="memberPassword" >
						</td>
					</tr>
				</table><br>
				<div>
				<input type="submit" value="로그인"> &nbsp; &nbsp;
				<input type="reset" value="취소"> &nbsp; &nbsp;
				</div>	
			</div>
		</form>
		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
</body>
</html>