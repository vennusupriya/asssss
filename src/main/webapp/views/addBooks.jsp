<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<jsp:include page="link.jsp" />

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Books</title>

</head>

<body>

	<div align=center>

	   <%
		String name = (String) request.getAttribute("name");
		session.setAttribute("name", name);
		
		String bookName = (String) request.getAttribute("bookName");
		%>

		<%if(bookName!=null){ %>
		<h1 style="font-size: 15px"><%=bookName%> is added successfully...</h1>
		<% }%>
			
			<a href="logout" style="font-size: 30px"> Logout </a>
		
		<form method="post" action="add">
		
		<h1>Add Books</h1>
		
			<p>Book Title</p>
			<input type="text" placeholder="title" name="title" required>
			<p>Total Pages</p>
			<input type="text" placeholder="total_pages" name="total_pages" required>
			<p>Rating</p>
			<input type="text" placeholder="rating" name="rating"required>
			<p>ISBN</p>
			<input type="text" placeholder="isbn" name="isbn"required>
			<p>
				<input type="submit" value="save">
			</p>
			
		</form>
	</div>
</body>
</html>
