<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body>	

	<% ResultSet rs = (ResultSet) request.getAttribute("rs"); %>


	<h1>Update Enter Details</h1>
	<form action="update">
		<input type="text" value="<%= rs.getString(1) %>" name="id" placeholder="Enter Id">
		<input type="text" value="<%= rs.getString(2) %>" name="fname" placeholder="Enter fname">
		<input type="text" value="<%= rs.getString(3) %>" name="lname" placeholder="Enter lname">
		<input type="text" value="<%= rs.getString(4) %>" name="password" placeholder="Enter Password">
		<button type="submit">Update</button>
	</form>
</body>
</html>