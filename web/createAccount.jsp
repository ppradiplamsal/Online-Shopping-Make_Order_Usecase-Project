<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>create Account</title>
</head>
<body>
<form action="CustomerCreateAccountInteface" method="post">
UserName: <input type="text" name="UserName" required ><br>
Password: <input type="password" name="Password" required ><br>
Card Number: <input type="number" name="card_number" required ><br>
Email: <input type="email" name="email" required ><br>
<input type="submit" value = "submit">
</form>
</body>
</html>