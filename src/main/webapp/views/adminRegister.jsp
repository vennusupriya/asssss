<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Account</title>

</head>

<body>
	<div align=center>

		<h1>Register Account</h1>

		<form method="post" action="adminRegister">

			<p>Username</p>
			<input type="text" placeholder="name" name="name" required>

			<p>Useremail</p>
			<input type="text" placeholder="email" name="email" required>

			<p>Password</p>
			<input type="password" placeholder="password" name="password"
				required>

			<p>System Code</p>
			<input type="text" placeholder="systemCode" name="systemCode"
				required>

			<p>
				<input type="submit" value="adminRegister">
			</p>

			<p>
				<a href="adminLogin">Already have Account?</a>
			</p>

			<p>
				<a href="index">Go To Index</a>
			</p>

		</form>
	</div>
</body>
</html>
