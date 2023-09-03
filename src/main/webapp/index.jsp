<%@page import="dao.Student_dao"%>
<%@page import="dto.Student_dto"%>
<html>
<body>
	<center>
		<h1>WELCOME TO TRAVELERS</h1>

		<% 
Student_dto student=(Student_dto)session.getAttribute("student");
if(student==null)
{
%>
		<a href="loginn.html"><button>Login</button></a><br> <a
			href="signupp.html"><button style="margin-top: 10px">Signup</button></a><br>

		<%} %>

	</center>
</body>
</html>
