<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Declaration Element</title>
</head>
<body>
<%!
	String message(){
	return "Hello World";	
}%>
<%= message() %>
</body>
</html>