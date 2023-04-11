<%@ page language="java" contentType="text/html" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection connection = 
DriverManager.getConnection("jdbc:mysql://localhost/sportyshoes","root","root");
Statement st = null;
ResultSet rs = null;
st = connection.createStatement();
rs = st.executeQuery("select category_name from category"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body align="center">

	<h1>Manage Products</h1>

	<form action="products" method="post">
		<pre>
		
		   Name:<input type="text" name="name" />
		  
            Description:<input type="text" name="description" />
		
		   Price:<input type="number" name="price" />
		   
		 Category : <select name ="category">
<%while(rs.next()){ %>
<option value="<%=rs.getString("category_name")%>"><%=rs.getString("category_name")%></option>
                        <%}%>           
                         </select> 
        </select>
		 <input type="submit" value="submit" />
			</pre>
	</form>

	<p>${message }</p>

	<ul>
		<c:forEach items="${products}" var="product">
			<li>${product.id }| ${product.name } | ${product.description } | ${product.price }</li>
		</c:forEach>
	</ul>


</body>
</html>