package Make_Order_Usecase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BankInterface {
	public boolean authorise(String accountId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/make_order_db?useSSL=false","root","root");
			PreparedStatement ps=myConn.prepareStatement(  
					"select CardNo from customer_account WHERE ACCOUNT_ID='" + accountId +"'");
			ResultSet rs = ps.executeQuery();
			rs.next();
			String cardNo = rs.getString("CardNo");
			if(cardNo.matches("[0-9]+")) {
				return true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		 
		return false;
	}
	public boolean justAuthorise(String cardNo) {
		if(cardNo.matches("[0-9]+")) {
			return true;
	}
		return false;
	}
}
