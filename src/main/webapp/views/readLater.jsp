<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="com.books.demo.entities.*"%>

<jsp:include page="userLink.jsp" />

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

		String title = (String) request.getAttribute("title");
		%>

		<%
		if (title != null) {
		%>
		<h1 style="font-size: 15px"><%=title%>
			is removed from read later...
		</h1>
		<%
		}
		%>

		<h1 style="font-size: 30px">Showing Read Later Books</h1>
		<br>		
			<a href="logout" style="font-size: 30px"> Logout </a>
		
		<form method="post" action="deleteBooks">
			<table border="1" style="background-color: #BDB76B">
				<tr>
					<td>Sr. No</td>
					<td>User Name</td>
					<td>Book ID</td>
					<td>Book Name</td>
					<td>Total Pages</td>
					<td>Rating</td>
					<td>ISBN</td>
					<td>Delete</td>
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
					<td><%=rl.getBook_id()%>
					<td><%=rl.getTitle()%></td>
					<td><%=rl.getTotal_pages()%></td>
					<td><%=rl.getRating()%></td>
					<td><%=rl.getIsbn()%></td>
					<td><a
						href="deleteFromReadLater?readID=<%=rl.getReadID()%>&amp;name=<%=rl.getName()%>&amp;book_id=<%=rl.getBook_id()%>&amp;title=<%=rl.getTitle()%>&amp;total_pages=<%=rl.getTotal_pages()%>&amp;rating=<%=rl.getRating()%>&amp;isbn=<%=rl.getIsbn()%>&amp" onclick="return confirm('Are you sure?')"><button
									type="button">Delete</button></a></td>
				</tr>

				<%
				}
				%>

			</table>
		</form>
	</div>
</body>
</html>