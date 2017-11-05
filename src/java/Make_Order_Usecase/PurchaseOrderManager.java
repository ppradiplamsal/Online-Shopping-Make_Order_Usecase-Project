package Make_Order_Usecase;

import Make_Order_Usecase.DeliveryOrder;
import Make_Order_Usecase.CustomerAccount;



public class PurchaseOrderManager {
	public boolean requestOrder (String accountID,String password, String orderContents,String quantity,String cost) {
		CustomerAccount CA = new CustomerAccount();
		if (CA.readAccountInfo(accountID, password)) {
			BankInterface bank = new BankInterface();
			if(bank.authorise(accountID)==false) {
				return false;
			}
			int total = Integer.parseInt(quantity)* Integer.parseInt(cost);
			String totalPrice = Integer.toString(total);
			DeliveryOrder delivery = new DeliveryOrder();
			delivery.createOrder(accountID, orderContents, quantity, totalPrice);
			EmailServerInterface email = new EmailServerInterface();
			email.emailConf(accountID);
			return true;
		}
		return false;
	}
	public boolean createACCRequestOrder( String AccountID,String password, String cardNO, String email) {
		CustomerAccount ca = new CustomerAccount();
		BankInterface bank = new BankInterface();
		if (bank.justAuthorise(cardNO)) {
			if(ca.createAccount(AccountID, password, cardNO, email)) {
				return true;
			}
		}
		return false;
	}
	public boolean requestOrder_newCardNo(String AccountID, String password, String orderContents,
			String quantity,String cost,String cardNo) {
			CustomerAccount ca = new CustomerAccount();
			if(ca.updateCardNo(AccountID, password, cardNo)) {
				ca.readAccountInfo(AccountID, password);
			}
		return false;
	}
}
