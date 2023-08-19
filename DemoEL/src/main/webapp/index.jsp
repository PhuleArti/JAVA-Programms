<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> index.jsp</h2>
<h2> Demo EL</h2>
<H1>
   $("Demo for EL")<br>
   $("4*5")<br>
   $(4==5 ? 8:9)<br>
</H1>
<form action="home.jsp">
Enter username<input type="text" name="username"/>
<input type="submit" value="submit"/>
</form>
</body>
</html>