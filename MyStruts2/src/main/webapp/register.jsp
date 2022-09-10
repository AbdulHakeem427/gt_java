<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form style="margin: auto; width: 220px;" action="register.do" method="post">
		<input type="hidden" name="formid" value="register">
	<table style="with: 50%">
				<h1>Register Form</h1>
				<tr>
					<td> Name</td>
					<td><input type="text" name="last_name" /></td>
				</tr>
				<tr>
					<td>LoginId</td>
					<td><input type="number" name="user_no." /></td>
				</tr>
					<tr>
					<td>PassWord</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>Flag</td>
					<td><input type="number" name="contact" /></td>
				</tr></table>
			<input type="submit" value="Submit" /></form>
</body>
</html>
	

</body>
</html>