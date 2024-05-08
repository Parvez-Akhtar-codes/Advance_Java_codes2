<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submit</title>
</head>
<body>
Name : <%= request.getParameter("name") %><br/>
Gender : <%= request.getParameter("gender") %><br/>
Languages : <% 
String[] array = request.getParameterValues("language");
if(array!=null){
	for(String values : array){
		out.print(values+ " ");
	}
}

%><br/>
Country : <%= request.getParameter("Country") %> 
</body>
</html>