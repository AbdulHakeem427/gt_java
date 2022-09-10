<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="WEB-INF/mytags2.tld" prefix="my" %>
    <%@ include file="register.jsp" %>
    <style>h3 {text-align: center; color: red;}</style>
<h3><my:registerUser 
Name="<%=request.getParameter(\"Name\")%>" 
LoginID="<%=request.getParameter(\"loginId\")%>"
PassWord="<%=request.getParameter(\"password\")%>" 
Address="<%=request.getParameter(\"address\")%>"
Flag="<%=request.getParameter(\"flag\")%>"/></h3>

