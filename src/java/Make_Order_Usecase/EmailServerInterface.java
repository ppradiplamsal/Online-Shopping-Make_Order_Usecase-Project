package Make_Order_Usecase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmailServerInterface {
	public String emailConf(String accountId) {
		String email=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/make_order_db?useSSL=false","root","root");
			PreparedStatement ps=myConn.prepareStatement(  
					"select CustEmail from customer_account where ACCOUNT_ID='"+ accountId + "'" );
			ResultSet rs = ps.executeQuery();
			rs.next();
			 email = rs.getString("CustEmail");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return email;
	}
}
