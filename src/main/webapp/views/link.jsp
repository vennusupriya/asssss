<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.io.IOException"%>

<center>
<h1 style="font-size: 80px">Welcome To Bookess</h1>

<%
session=request.getSession();   
if(null != session && null != session.getAttribute("name")){  
String name=(String)session.getAttribute("name");  
session.setAttribute("name", name);
  
out.print("<h1>Hello, "+name+"</h1>");
}
%>
</center>
z