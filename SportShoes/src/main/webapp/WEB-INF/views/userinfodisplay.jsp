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
Statement st1=null;
ResultSet rs1=null;
st1=connection.createStatement();
Statement st2=null;
ResultSet rs2=null;
st2=connection.createStatement();
String sql ="SELECT * FROM users";
String sql2="select * from userinfo";

rs = st.executeQuery(sql);
//rs2=st2.executeQuery(sql2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>To Search Users</h1>
<form action="/search" method="post">
Enter UserName<input type="text" name="username"/>
<input type="submit" value="search"/></form>
<h3>Registered User Details<h3>
<table align="center" cellpadding="10" cellspacing="0" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>id</b></td>
<td><b>First Name</b></td>
<td><b>Last Name</b></td>
<td><b>Username</b></td>
<td><b>Mobile No</b></td>
<td><b>Email</b></td>
<td><b>State</b></td>
<td><b>City</b></td>
<td><b>Log Time</b></td>
</tr>

<%
int id1=0;
while(rs.next()){%>
<tr>
<td><%=rs.getString("id") %></td>
<td><%=rs.getString("firstname")%></td>
<td><%= rs.getString("lastname")%></td>
<td><%=rs.getString("username") %></td>
<td><%=rs.getString("mobno") %></td>
<td><%=rs.getString("email") %></td>
<td><%=rs.getString("state") %></td>
<td><%=rs.getString("city") %></td>
<% id1=rs.getInt("id");

%>
<% rs2=st2.executeQuery("select logtime from userinfo  where id='"+id1+"';");
PreparedStatement s=connection.prepareStatement("select logtime from userinfo where id=?");
s.setInt(1,id1);
//rs2=s.executeQuery();
%>
<%while(rs2.next()){ %>
<td><%=rs2.getString("logtime") %></td>

<%} %>
</tr>
<%}%>

</table>

	

</body>
</html>