<%@page import="java.util.List"%>
<%@page import="dto.Booking_dto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
List<Booking_dto> list=(List<Booking_dto>)request.getAttribute("list"); %>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Origin</th>
			<th>Destination</th>

		</tr>

		<% for(Booking_dto dto:list)
	{%>
		<tr>
			<th><%=dto.getName() %></th>
			<th><%=dto.getOrigin() %></th>
			<th><%=dto.getDestination() %></th>
			<th><%=dto.getId() %></th>

		</tr>
		<%} %>
	
</body>
</html>