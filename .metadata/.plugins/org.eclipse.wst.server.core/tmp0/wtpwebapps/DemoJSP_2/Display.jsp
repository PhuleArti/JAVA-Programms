<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>
<%
String num=request.getParameter("number");
int Num=Integer.parseInt(num);
for(int j=1;j<=10;j++){
%>
<h3> <%= (j*Num) %></h3>
<%
 }
%>
</p>
</body>
</html>