<jsp:include page="include/header.jsp"/>




<br/>
<br/>
<br/>
<br/>
<br/>
<form action = "${pageContext.request.contextPath}/site" method = "post">
 User Name = <input type = "text" name = "username" required="required" ><br/>
 Email Id = <input type = "email" name = "email_id" required="required" ><br/>
 <input type = "hidden" name = "form" value = "adduseroperation">
 <input type = "submit" value = "Add User">

</form>

<br/>
<br/>
<br/>


<jsp:include page="include/footer.jsp"/>