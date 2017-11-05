<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>

  <%
  String order = request.getParameter("order");
  String quantity = request.getParameter("quantity");
  String cost = request.getParameter("cost");
  String cardNo = request.getParameter("cardNo");
  session.setAttribute("order", order);
  session.setAttribute("quantity", quantity);
  session.setAttribute("cost", cost);
  session.setAttribute("cardNo", cardNo);
  %>

<form action="CustomerInterface" method="post">
UserName: <input type="text" name="UserName" required ><br>
Password: <input type="password" name="Password" required ><br>
<input type="submit" value = "submit">
</form>
  
<form action="createAccount.jsp" method="post">
<input type="submit" value = "If you do not have an account, here!"/>

</form>

</body>
</html>