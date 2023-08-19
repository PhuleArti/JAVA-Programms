<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! int i=100; %> <!-- initialization -->
<h3>index.jsp</h3>
<% 
out.println("welcome to jsp"); 
i++;
%> <!--  Scriplet -->
<br><br>
<%=i %>
</body>
</html>