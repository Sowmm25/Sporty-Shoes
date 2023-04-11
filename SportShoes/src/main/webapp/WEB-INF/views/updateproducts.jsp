<%@ page language="java" contentType="text/html" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = 
DriverManager.getConnection("jdbc:mysql://localhost/sportyshoes","root","root");
Statement st = null;
Statement st2=null;
ResultSet rs = null;
ResultSet rs2=null;
st = connection.createStatement();
rs = st.executeQuery("select id from products"); 
st2 = connection.createStatement();
rs2 = st2.executeQuery("select id from products"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body align="center">

	<h1>Update Products</h1>

	<form action="updateproducts" method="post">
		<pre>
		
		Name:<input type="text" name="name" /><br>
	Description:<input type="text" name="description" /><br>
		Price:<input type="number" name="price" /><br>
Select ID: <select name ="id">
<%while(rs.next()){ %>
<option value="<%=rs.getString("id")%>"><%=rs.getString("id")%></option>
                        <%}%>           
                         </select> 
        </select>
		<button type="submit" name="update" style="width: 100px;"><span>Update</span></button>
		 
			</pre>
	</form>
	<form action="updateproducts" method="post">
	<h1>Delete Products</h1>
	Select	ID: <select name ="id">
<%while(rs2.next()){ %>
<option value="<%=rs2.getString("id")%>"><%=rs2.getString("id")%></option>
                        <%}%>           
                         </select>
                         </select> <br>
                         <br>
                         <br>
                         <button type="submit" name="delete" style="width: 100px;"><span>Delete</span></button>
        </select>
	</form>

	<p>${message }</p>

	<ul>
		<c:forEach items="${products}" var="product">
			<li>${product.id }| ${product.name } | ${product.description } | ${product.price }</li>
		</c:forEach>
	</ul>


</body>
</html>