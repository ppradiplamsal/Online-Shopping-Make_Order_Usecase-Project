package Make_Order_Usecase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DeliveryOrder {

	public void createOrder(String accountId, String item, String quantity, String totalPrice) {
		String authNo = ""+((int)(Math.random()*9000)+1000);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/make_order_db?useSSL=false","root","root");
			PreparedStatement ps=myConn.prepareStatement(  
					"Insert into delivery_order(ACCOUNT_ID,item,Quantity,TotalPrice,AuthorizationNo) VALUES (?,?,?,?,?)" );
			ps.setString(1, accountId);
			ps.setString(2, item);
			ps.setString(3, quantity);
			ps.setString(4, totalPrice);
			ps.setString(5, authNo);
				ps.executeUpdate();
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
