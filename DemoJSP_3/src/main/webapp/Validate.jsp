<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String user=request.getParameter("username");
String pass= request.getParameter("password");
if(user.equals("seed") && pass.equals("seed")){ 
	 out.println("welcome"+user);
}
else{
	 out.println("invalid");
}
%>
</body>
</html>