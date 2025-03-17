<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Events Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }
    
    h1 {
        text-align: center;
        padding: 20px;
        background-color: #4CAF50;
        color: white;
    }
    
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
    }
    
    th, td {
        padding: 12px;
        text-align: left;
        border: 1px solid #ddd;
    }
    
    th {
        background-color: #4CAF50;
        color: white;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #ddd;
    }
    
    td {
        font-size: 14px;
    }
</style>
</head>
<body>	
	<h1>All Users</h1>
	
	<table>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Password</th>
			<th colspan="2">Action</th>
		</tr>
	<% 
		ResultSet rs = (ResultSet) request.getAttribute("rs"); 
		while(rs.next()){
	%>
		<tr>
			<td><%= rs.getString(1) %></td>
			<td><%= rs.getString(2) %></td>
			<td><%= rs.getString(3) %></td>
			<td><%= rs.getString(4) %></td>
			<td> <a href="updatepage?id=<%= rs.getString(1) %>"><button>Update</button></a> </td>
			<td> <a href="delete?id=<%= rs.getString(1) %>"><button>Delete</button></a> </td>
			
		</tr>
	<%} %>
	</table>
</body>
</html>