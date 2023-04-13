<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% session.invalidate(); %>
You are now logged out!!

<!-- <a href="${pageContext.request.contextPath}/login">go back</a> -->
</body>
</html>