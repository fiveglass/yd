<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		header {
	    text-align: center;
	}
	nav {
	    background-color: black;
	    overflow: hidden;
	}
	.nav {
	    float: right;
	}
	nav ul {
	    list-style: none;
	    padding: 0;
	    margin: 0;
	}
	nav ul li {
	    float: left;
	}
	nav a {
	    color: white;
	    text-decoration: none;
	    font-weight: bold;
	    padding: 10px;
	    display: inline-block;
	}
	nav a:hover {
	    color: black;
	    background-color: pink;
	}
</style>
</head>
<body>
	 <header>
      
         <nav>
             <ul>
                 <li><a href="main.do">main</a></li>
                 <li><a href="noticeList.do">notice</a></li>
                 <li><a href="memberList.do">memberlist</a></li>
                 <c:if test="${empty id }">
                 	<li><a href="memberJoin.do">join</a></li>
                 </c:if>
                 <c:if test="${empty id }">
                 	<li><a href="memberLoginForm.do">login</a></li>
                 </c:if>
                 <c:if test="${not empty id }">
                 	<li><a href="memberLogout.do">logout</a></li>
                 </c:if>
                 <c:if test="${not empty name }">
                 	<li><a href="">${name }님 로그인</a></li>
                 </c:if>
             </ul>
         </nav>
     </header>
</body>
</html>