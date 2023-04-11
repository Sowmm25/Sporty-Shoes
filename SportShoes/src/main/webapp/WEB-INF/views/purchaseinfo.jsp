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
Statement st3=null;
ResultSet rs3=null;
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
<body align="center">
<h1>Products Purchase Report</h1>


<table align="center" cellpadding="10" cellspacing="0" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>id</b></td>
<td><b>username</b></td>
<td><b>size</b></td>
<td><b>Product Id</b></td>
<td><b>Product Name</b></td>
<td><b>Product Description</b></td>
<td><b>Price</b></td>
</tr>

<%
int id1=0;
while(rs.next()){%>
<tr>
<td><%=rs.getString("id") %></td>
<td><%=rs.getString("username") %></td>
<% id1=rs.getInt("id");

%>
<% rs2=st2.executeQuery("select * from purchase  where id='"+id1+"';");

//rs2=s.executeQuery();
%>
<%int id2=0;
if(rs2.next()){ %>
<td><%=rs2.getString("size") %></td>

<% id2=rs2.getInt("product_id");%>
<td><%=id2 %></td>
<%} 

rs1=st1.executeQuery("select * from products where id='"+id2+"';");
while(rs1.next()){;
%>
<td><%=rs1.getString("product_name") %></td>
<td><%=rs1.getString("product_description") %></td>
<td><%=rs1.getString("price") %></td>
<%} %>

</tr>
<%}%>

</table>

	

</body>
</html>