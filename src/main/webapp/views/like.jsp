<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="com.books.demo.entities.*"%>

<jsp:include page="userLink.jsp" />

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">
<title>Show Like Books</title>

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
				
			<a href="logout" style="font-size: 30px"> Logout </a>
		
		
		<table border="1" style="background-color: #BDB76B">
			<tr>
				<td>Sr. No</td>
				<td>User Name</td>
				<td>Book_ID</td>
				<td>Book_Name</td>
				<td>Total_Pages</td>
				<td>Rating</td>
				<td>ISBN</td>
				<td>Delete</td>
			</tr>


			<%
			@SuppressWarnings("unchecked")
			List<Like> like = (List<Like>) request.getAttribute("list");
			%>

			<%
			int i = 1;
			for (Like l : like) {
			%>

			<tr>
				<td><%=i++%></td>
				<td><%=l.getName()%>
				<td><%=l.getBook_id()%>
				<td><%=l.getTitle()%></td>
				<td><%=l.getTotal_pages()%></td>
				<td><%=l.getRating()%></td>
				<td><%=l.getIsbn()%></td>
				<td><a
						href="deleteFromLike?liked_book_id=<%=l.getLiked_book_id()%>&amp;name=<%=l.getName()%>&amp;book_id=<%=l.getBook_id()%>&amp;title=<%=l.getTitle()%>&amp;total_pages=<%=l.getTotal_pages()%>&amp;rating=<%=l.getRating()%>&amp;isbn=<%=l.getIsbn()%>&amp" onclick="return confirm('Are you sure?')"><button
									type="button">Delete</button></a></td>
			</tr>

			<%
			}
			%>
		</table>
	</div>
</body>
</html>