<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login success</title>
</head>
<%
	if(session.getAttribute("uname") == null){
		response.sendRedirect("input.jsp");
	}
%>
<body>
<h1>welcome, <%= session.getAttribute("uname") %></h1>
<h1> Login Success:</h1>
<form action = "logout.jsp">
<button > logout </button>
</form>
</body>
</html>