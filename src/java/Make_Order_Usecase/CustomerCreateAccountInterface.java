package Make_Order_Usecase;

import Make_Order_Usecase.PurchaseOrderManager;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class custOmerInterface1
 */
@WebServlet("/custOmerInterface1")
public class CustomerCreateAccountInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerCreateAccountInterface() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountId = request.getParameter("UserName");
		String password = request.getParameter("Password");
		String cardNo = request.getParameter("card_number");
		String email = request.getParameter("email");
		PurchaseOrderManager pos = new PurchaseOrderManager();
		if(pos.createACCRequestOrder(accountId, password, cardNo, email)){
			PrintWriter out = response.getWriter();
			out.print("you have created an account");
			response.sendRedirect("login.jsp");
		}
		
	}

}
