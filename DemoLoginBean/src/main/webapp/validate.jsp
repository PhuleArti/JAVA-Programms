<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> validate page</h3>
<jsp:useBean id="lb" class="com.demo.bean.LoginBean" scope="request"></jsp:useBean>
<jsp:setProperty property="user" name="lb"/>
<jsp:setProperty property="pass" name="lb"/>
<h2><%=lb %></h2>

</body>
</html>