<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to the Online Shopping System</title>
</head>
<body>

  
<form action="loginPage.jsp"  method="post">
Order Name: <input type="text" name="order"  required ><br>
Quantity: <input type="number" name="quantity" min="1" required><br>
Cost: <input type="number" name="cost" required><br>
Card Number: <input type="number" name="cardNo" required><br>

 <input type="submit" value = "submit">
 </form>
 
<form action="updateCredCard.jsp"  method="post">
<input type="submit" value = "Update Your Credit Card Number">
</form>


</body>
</html>