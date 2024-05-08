<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
</head>
<body>
<form action="submit.jsp" method="post">
Full Name : <input type="text" name="name"><br/><br/>
Gender :  <input type="radio" name = "gender" value = "Male" >Male
		<input type = "radio" name = "gender" value = "Female">Female<br/><br/>
Languages : <input type = "checkbox" name = "language" value= "English">English
			<input type = "checkbox" name = "language" value = "Hindi">Hindi
			<input type = "checkbox" name = "language" value = "Frenh">French<br/><br/>
Country : <select name = "Country">
			<option value = India>India</option>
			<option value = UAE>UAE</option>
			<option value = UK>UK</option>
			<option value = USA>USA</option> 
			</select><br/><br/>
			
		<input type = "submit" value = "Submit"> 
</form>
</body>
</html>