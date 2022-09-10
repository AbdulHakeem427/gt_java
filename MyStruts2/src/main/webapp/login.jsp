<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form style="margin: auto; width: 220px;" action="login.do" method="post">
		<input type="hidden" name="formid" value="login">
	<table style="with: 50%" >
				<h1>User Login</h1>
				<tr>
					<td> LoginID</td>
					<td><input type="text" name="uname" /></td>
				</tr>
				<tr>
					<td>PassWord</td>
					<td><input type="password" name="upass" /></td>
				</tr></table>
				
	
			<input type="submit" value="Login" />Don't have an account?  <a href="register.jsp">Register Here</a>
  </form>
  </td>
 </body>
</html>

   