package Bank.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bank.Dao.BankInterfaceImplementation;
import Bank.Model.Registor;

/**
 * Servlet implementation class AddMoneyController
 */
@WebServlet("/AddMoneyController")
public class AddMoneyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMoneyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int i=0;
	HttpSession session=request.getSession();
		int amount=Integer.parseInt(request.getParameter("amount"));
		int acno=Integer.parseInt(request.getParameter("accNo"));
	String pass=request.getParameter("Password");
	Registor r=new Registor();
	r.setPassword(pass);
	r.setAc_no(acno);
	BankInterfaceImplementation bdao=new BankInterfaceImplementation();

	i=bdao.addMoney(r,amount);
	if(i>0)
	{
		response.sendRedirect("DashBoard.jsp");
	}
	else {
		response.sendRedirect("Error.jsp");
		}
	
	}

}
