package Make_Order_Usecase;

import Make_Order_Usecase.PurchaseOrderManager;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class custOmerInterface
 */
@WebServlet("/CustomerInterface")
public class CustomerInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*private String order = null;
    public custOmerInterface() {
        super();
       
    }
    public String getOrder() {  
        return order;  
    }  
      
    public void setOrder(String order) {  
        this.order = order;  
    }  */


	
	//@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountId = request.getParameter("UserName");
		String password = request.getParameter("Password");
		HttpSession session = request.getSession();
		String order = session.getAttribute("order").toString();
		String quantity = session.getAttribute("quantity").toString();
		String cost = session.getAttribute("cost").toString();
		String updateCard = null;
		if (session.getAttribute("cardNo")!=null) {
		updateCard = session.getAttribute("cardNo").toString();
		}
		PurchaseOrderManager pos = new PurchaseOrderManager(); 
		if(pos.requestOrder(accountId, password, order,quantity,cost)&& updateCard==null) {
		PrintWriter out = response.getWriter();
		out.print("Your order of:"+order+" is placed");
		}
		else if (updateCard!=null) {
			pos.requestOrder_newCardNo(accountId, password, order, quantity, cost, updateCard);
		}
		else {
			PrintWriter out = response.getWriter();
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('incorrect user name or password')");
			   out.println("location='index.jsp'");
			   out.println("</script>");
		}
	}

}
