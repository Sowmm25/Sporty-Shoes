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
String sql ="SELECT * FROM products";

rs = st.executeQuery(sql);
rs2=st2.executeQuery(sql);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">
Welcome,
<%=request.getAttribute("username") %>

<h1>Purchase Products</h1>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>id</b></td>
<td><b>Product Name</b></td>
<td><b>Description</b></td>
<td><b>Price</b></td>
<td><b>Category</b></td>
</tr>
<%
try{ 


//String sql2="select category_name from category  where category.id=?";



int id1=0;
while(rs.next()){
%>
<tr bgcolor="#DEB887">

<td><%=rs.getInt("id") %></td>
<%int i=rs.getInt("id");%>


<td><%=rs.getString("product_name") %></td>
<td><%=rs.getString("product_description") %></td>
<td><%=rs.getDouble("price") %></td>
<% id1=rs.getInt("cat_id");
%>


<% rs1=st1.executeQuery("select * from category where id='"+id1+"';");%>
<% if(rs1.next()){%>
<td><%=rs1.getString("category_name") %></td>


<%} %>
</tr>
<% 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
<h1>Select Desired Product Id</h1>
<form action="display" method="post">
Select Size<select name="size" id="size">
  <option value="S">S</option>
  <option value="M">M</option>
  <option value="L">L</option>
  <option value="XL">Xl</option>
</select>
	Select	ID: <select name ="id">
<%while(rs2.next()){ %>
<option value="<%=rs2.getString("id")%>"><%=rs2.getString("id")%></option>
                        <%}%>           
                         </select>
                         </select> <br>
                         <br>
                         <br>
                         <button type="submit" name="Buy" style="width: 100px;"><span>BUY</span></button>
        </select>

</form>

</body>
</html>