<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="com.books.demo.entities.*"%>


<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Profile Page</title>


</head>

<body>
	<div align=center>

		<%
		String name = (String) request.getAttribute("name");
		session.setAttribute("name", name);
		
		String bookName = (String) request.getAttribute("bookName");
		String likeBook = (String) request.getAttribute("likeBook");
		%>

		<%if(bookName!=null){ %>
		<h1 style="font-size: 15px"><%=bookName%>
			is added to read later...
		</h1>
		<% }%>
		
		<%if(likeBook!=null){ %>
		<h1 style="font-size: 15px"><%=likeBook%>
			is added to Like...
		</h1>
		<%} %>
		
		<h1 style="font-size: 80px">Welcome To Bookess</h1>
		
		<h1>Hello <%=name%></h1>

		<p>
			<a href="showReadLater?name=<%=name%>&amp"
				style="font-size: 30px"> Read Later </a> 
			<br>	
			<a href="showLikeBooks?name=<%=name%>&amp" 
				style="font-size: 30px">Like </a> 
			<br>	
			<a href="logout" style="font-size: 30px">Logout </a>
		</p>

		<div align=center>

			<form method="post" action="saveBooks">

				<table border="1" style="background-color: #BDB76B">

					<tr>
						<td>Sr. NO</td>
						<td>Book_ID</td>
						<td>Book_Name</td>
						<td>Total_Pages</td>
						<td>Rating</td>
						<td>ISBN</td>
						<td>Read_Later</td>
						<td>Loved_Book</td>
					</tr>


					<%
					@SuppressWarnings("unchecked")
					List<Book> book = (List<Book>) request.getAttribute("list");
					%>

					<%
					int i =1;
					for (Book b : book) {
					%>

					<tr>
						<td><%=i++%>
						<td><%=b.getBook_id()%></td>
						<td><%=b.getTitle()%></td>
						<td><%=b.getTotal_pages()%></td>
						<td><%=b.getRating()%></td>
						<td><%=b.getIsbn()%></td>
						<td><a
							href="saveReadLater?name=<%=name%>&amp;book_id=<%=b.getBook_id()%>&amp;title=<%=b.getTitle()%>&amp;total_pages=<%=b.getTotal_pages()%>&amp;rating=<%=b.getRating()%>&amp;isbn=<%=b.getIsbn()%>&amp"><button
									type="button">Read Later</button></a></td>
						<td><a
							href="saveLikeBook?name=<%=name%>&amp;book_id=<%=b.getBook_id()%>&amp;title=<%=b.getTitle()%>&amp;total_pages=<%=b.getTotal_pages()%>&amp;rating=<%=b.getRating()%>&amp;isbn=<%=b.getIsbn()%>&amp"><button
									type="button">Like</button></a></td>
					</tr>
					<%
					}
					%>
				</table>
			</form>
		</div>
	</div>
</body>
</html>