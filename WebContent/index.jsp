<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Calculatrice</title>
</head>
<body>

	<!-- Check if the number is null. If it is null show empty string  -->
	<% if (request.getAttribute("add") == null) {
			out.print("");
		} else { %>
	<%=request.getAttribute("num1")%> + <!-- Show the number 1 from input field by jsp getAttribute -->
	<%=request.getAttribute("num2")%> = <!-- Show the number 2 from input field by jsp getAttribute -->
	<%=request.getAttribute("add")%>	<!-- Show the Addition, We pass the add object from Servlet to JSP -->
	<% } %>
	
	<% if (request.getAttribute("sub") == null) {
			out.print("");
		} else { %>
	<%=request.getAttribute("num1")%> -
	<%=request.getAttribute("num2")%> =
	<%=request.getAttribute("sub")%>	<!-- Show the Subtraction, We pass the sub object from Servlet to JSP -->
	<% } %>
	
	<%if (request.getAttribute("mul") == null) {
			out.print("");
		} else { %>
	<%=request.getAttribute("num1")%> * 
	<%=request.getAttribute("num2")%> =
	<%=request.getAttribute("mul")%>	<!-- Show the Multiplication, We pass the mul object from Servlet to JSP -->
	<% } %>
	
	<%if (request.getAttribute("div") == null) {
			out.print("");
		} else { %>
	<%=request.getAttribute("num1")%> / 
	<%=request.getAttribute("num2")%> = 
	<%=request.getAttribute("div")%> <!-- Show the Division, We pass the div object from Servlet to JSP -->
	<% } %>

<!-- Html form from where we get the two number. calculator is the servlet name and it is post method. By this we pass all the information in form field  -->
	<form action="calculator" method="POST">
		<hr />
		<h4>
		<!-- get the number one -->
			Nombre 1 : <input type="text" name="nombre1" value="" />
		</h4>
		<h4>
		<!-- get the number two -->
			Nombre 2 : <input type="text" name="nombre2" value="" />
		</h4>
		<hr />
		<input type="reset" value="Effacer" /> <!-- Reset all the values in the input field -->
		<input type="submit" value="+" name="bouton" /> <!-- Add the number -->
		<input type="submit" value="-" name="bouton" /> <!-- Subtract the number -->
		<input type="submit" value="*" name="bouton" /> <!-- Multiply the number -->
		<input type="submit" value="/" name="bouton" /> <!-- Divide the number -->
	</form>


</body>
</html>