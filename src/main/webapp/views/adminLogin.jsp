<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Here</title>

</head>
<body>
	<div align=center>
	
		<%
		String message = (String) request.getAttribute("message");
		session.setAttribute("message", message);
		%>
		<%if(message!=null){ %>
		<h1 style="font-size: 15px"><%=message%> </h1>
		<% }%>
	
		<h1>Login Account</h1>
		<form:form id="loginForm" modelAttribute="admin" action="adminLogin"
			method="post">
			<table>
				<tr>
					<td><form:label path="name">Username: </form:label></td>
					<td><form:input path="name" name="name" id="name" />
					</td>
				</tr>
				<tr>
					<td><form:label path="password">Password:</form:label></td>
					<td><form:password path="password" name="password"
							id="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td align="left"><form:button id="adminLogin" name="adminLogin">Login</form:button>
					</td>
				</tr>
			</table>
		</form:form>

		<p>
			<a href="adminRegister">Create New Account</a>
		</p>
		<p>
			<a href="index">Go To Index</a>
		</p>
	</div>
</body>
</html>