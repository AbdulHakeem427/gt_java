<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> REGISTER PAGE</h1>
	<form action="register.do" method="post">   
	<input type="hidden" name=formid  value="register">
	
	Uid:<<input type="text" name="uid"><br>
	UserName:<input type="text" name="uname"><br>
	PassWord:<input type="text" name="upass"><br>
	City:<input type="text" name="city"><br>
	Flag:<input type="text" name="flag"><br>
	
	<input type="submit" value="register...">
	
	</form>
</body>
</html>