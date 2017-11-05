package Make_Order_Usecase;

import java.io.PrintWriter;
import java.sql.*;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
public class CustomerAccount {
	public boolean readAccountInfo (String accountID,String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/make_order?useSSL=false","root","12345");
			PreparedStatement ps=myConn.prepareStatement(  
					"select Customer_id from customer_account where ACCOUNT_ID='" + accountID+"' and Password='"+password+"'" );
			ResultSet rs = ps.executeQuery();
			//String cardNo = rs.getString("CardNo");
			//verify card in bank interface class
			//verify cardno in bank class then do if true insert in database
			//check here if customer exist in database then return true or false
			if(rs.next()) {
				if (rs.getString("Customer_id")!=null) {
					return true;
					/*HttpSession session = request.getSession();
					session.setAttribute("uname", userName);
					response.sendRedirect("make_order.jsp");*/
				}
				else {
					return false;
				}
				
			}
			/*else {
				HttpServletResponse response = null;
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('User or password incorrect');");
				   out.println("location='login.jsp';");
				   out.println("</script>");
				}*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean createAccount(String accountId,String password, String cardNo,String email) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/make_order?useSSL=false","root","12345");
			String sql = "Insert into CUSTOMER_ACCOUNT(ACCOUNT_ID,Password,CardNo,CustEmail) VALUES (?,?,?,?)";
			PreparedStatement ps;
			 ps = myConn.prepareStatement(sql);
		ps.setString(1, accountId);
		ps.setString(2, password);
		ps.setString(3, cardNo);
		ps.setString(4,email);
			ps.executeUpdate();
			return true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateCardNo(String accountId,String password, String cardNo) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/make_order_db?useSSL=false","root","root");
			String update = "update customer_account set CardNo = ? where ACCOUNT_ID = ? and Password = ?";
			PreparedStatement ps;
			 ps = myConn.prepareStatement(update);
			 ps.setString(1, cardNo);
			 ps.setString(2, accountId);
			 ps.setString(3, password);
			 return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
