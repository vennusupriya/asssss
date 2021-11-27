<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="com.books.demo.entities.*"%>

<jsp:include page="link.jsp" />

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">
<title>Users</title>

</head>

<body>
	<div align=center>

		<%
		String name = (String) request.getAttribute("name");
		session.setAttribute("name", name);
		
		String username = (String) request.getAttribute("username");
		session.setAttribute("username", username);
		
		%>

		<%if(username!=null){ %>
		<h1 style="font-size: 15px"><%=username%>
			is removed...
		</h1>
		<% }%>
		
		<h1 style="font-size: 30px">Showing Register Users</h1>

		<br>				
			<a href="logout" style="font-size: 30px"> Logout </a>
		

		<table border="1" style="background-color: #BDB76B">
			<tr>
				<td>Sr. No</td>
				<td>User Name</td>
				<td>User Email Id</td>
				<td>Password</td>
			</tr>


			<%
			@SuppressWarnings("unchecked")
			List<User> users = (List<User>) request.getAttribute("list");
			%>

			<%
			int i = 1;
			for (User user : users) {
			%>

			<tr>
				<td><%=i++%></td>
				<td><%=user.getName()%>
				<td><%=user.getEmail()%>
				<td><%=user.getPassword()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>