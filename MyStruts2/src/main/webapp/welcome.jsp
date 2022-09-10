<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("Name ")==null){
	response.sendRedirect("login.jsp");
}
%>
<h1>Welcome,
</h1>
   <form action="logout.do" method="post">

    <input type=submit value="">
	</form>

</body>
</html>