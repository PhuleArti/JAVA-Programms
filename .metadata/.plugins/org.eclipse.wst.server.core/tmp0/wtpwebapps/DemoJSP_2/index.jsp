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
<h3>index.jsp</h3>
<form action="Display.jsp">
Enter number<input type="text" name="number"><br><br>
<input type="submit" value="display">
</form>
<%@include file="Info.jsp" %>
</body>
</html>