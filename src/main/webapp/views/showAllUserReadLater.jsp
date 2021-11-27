<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="com.books.demo.entities.*"%>

<jsp:include page="link.jsp" />

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">
<title>Read Later</title>

</head>

<body>
	<div align=center>

		<%
		String name = (String) request.getAttribute("name");
		session.setAttribute("name", name);
		%>

		<h1 style="font-size: 30px">Showing Read Later Books</h1>
		<br>		
			<a href="logout" style="font-size: 30px"> Logout </a>

		<table border="1" style="background-color: #BDB76B">
			<tr>
				<td>Sr. No</td>
				<td>User Name</td>
				<td>Book Name</td>
				<td>Total Pages</td>
				<td>Rating</td>
				<td>ISBN</td>
			</tr>


			<%
			@SuppressWarnings("unchecked")
			List<ReadLater> readLater = (List<ReadLater>) request.getAttribute("list");
			%>

			<%
			int i = 1;
			for (ReadLater rl : readLater) {
			%>

			<tr>
				<td><%=i++%></td>
				<td><%=rl.getName()%>
				<td><%=rl.getTitle()%></td>
				<td><%=rl.getTotal_pages()%></td>
				<td><%=rl.getRating()%></td>
				<td><%=rl.getIsbn()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>