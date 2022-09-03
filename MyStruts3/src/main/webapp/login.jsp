<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<title>login page</title>
<style>
h1 {text-align: center;}
</style>
</head>
<body>
<form action="login.do" method="post" >
	<fieldset>
	<legend>Login Form</legend>
	<input type="hidden" name="formid" value="login">
    LoginID:<br><input type="number" name='login' value="phone number" required="required"><br />
    Password:<br><input type='password' name='password'><br/>
       <input type='submit' value='Login'>
       </fieldset>
	</form>
</body>
</html>