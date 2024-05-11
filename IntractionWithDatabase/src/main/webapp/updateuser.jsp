<jsp:include page="include/header.jsp"/>




<br/>
<br/>
<br/>
<br/>
<br/>
<form action = "${pageContext.request.contextPath}/site" method = "post">
 User Name = <input type = "text" name = "username" value ="${param.username}" required="required" ><br/>
 Email Id = <input type = "email" name = "email_id" value ="${param.email_id}" required="required" ><br/>
 <input type = "hidden" name = "form" value = "updateuseroperation">
 <input type = "hidden" name = "user_id" value = "${param.user_id}">
 <input type = "submit" value = "Update User">

</form>

<br/>
<br/>
<br/>


<jsp:include page="include/footer.jsp"/>