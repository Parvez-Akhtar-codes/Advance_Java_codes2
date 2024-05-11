<jsp:include page="include/header.jsp"/>
<%@ page import="java.util.List" %>
<%@ page import="SqlTesting.entity.User" %>
<h3> List Users </h3>

<br/>
<br/>
<br/>
<br/>
   <table border="1">
<thead>
<th>User Id</th>
<th>User Name</th>
<th>Email Id</th>
<th>Operations</th>

</thead>
<%
List<User> listusers  = (List)request.getAttribute("listusers");
for(User _user : listusers){
	out.println("<tr>");
	out.println("<td>"+_user.getUser_id()+"</td>");
	out.println("<td>"+_user.getUsername()+"</td>");
	out.println("<td>"+_user.getEmail_id()+"</td>");
	out.println("<td> <a href="+request.getContextPath()+"/site?page=updateuser&user_id="
	+_user.getUser_id()+"&username="
			+_user.getUsername()+"&email_id="
					+_user.getEmail_id()+">Update</a>");
	out.println(" | ");
	out.println("<a href="+request.getContextPath()+"/site?page=deleteuser&user_id="
			+_user.getUser_id()+">Delete</a></td>");
	
	out.println("<tr>");
}


%>


</table>
<br/>
<br/>
<br/>
<br/>
<jsp:include page="include/footer.jsp"/>