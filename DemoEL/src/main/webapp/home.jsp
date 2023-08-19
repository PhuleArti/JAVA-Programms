<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> home.jsp</h2>
<h2>
Welcome<%= request.getParameter("username") %>
</h2>
<h1> with EL</h1>
<H2> Welcome ${param.username}</H2>
</body>
</html>