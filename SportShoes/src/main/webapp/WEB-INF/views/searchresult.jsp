<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.*"%>
<%@page import="java.sql.Connection"%>
    <%
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = 
DriverManager.getConnection("jdbc:mysql://localhost/sportyshoes","root","root");
Statement st = null;
ResultSet rs = null;
st = connection.createStatement();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
<h3>User Found</h3>
<p></p>
<%=request.getAttribute("result")%>
<%
//out.println("hi"+request.getAttribute("result")) ;
String s="select * from users where id='"+request.getAttribute("result")+"';";
rs=st.executeQuery(s);
while(rs.next()){%>
<div>First name: <% out.println(rs.getString("firstname"));%></div>
<div>Last name: <% out.println(rs.getString("lastname"));%></div>
<div>Email: <% out.println(rs.getString("email"));%></div>
<div>City: <% out.println(rs.getString("city"));%></div>
<div>State: <% out.println(rs.getString("state"));%></div>
<div>Mobno: <% out.println(rs.getString("mobno"));%></div>
<% }%>

</body>
</html>