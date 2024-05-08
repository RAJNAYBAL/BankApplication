package Bank.Controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bank.Dao.BankInterface;
import Bank.Dao.BankInterfaceImplementation;
import Bank.Model.Registor;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
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
	
		BankInterface b=new BankInterfaceImplementation();
		List<Registor> reg_lst=new LinkedList<Registor>();
		HttpSession session=request.getSession();
		int i=0;
		int accNo=Integer.parseInt(request.getParameter("acc_no"));
		String custName=request.getParameter("cust_nm");
		double panNo=Integer.parseInt(request.getParameter("pan_no"));
		double adhNo=Integer.parseInt(request.getParameter("adh_no"));
		String branch=request.getParameter("branch");
		String gmail=request.getParameter("mail");
		String userName=request.getParameter("user_name");
		String pass=request.getParameter("password");
		System.out.println(accNo);
		Registor r=new Registor(accNo, custName, panNo, adhNo, branch, gmail, userName, pass);
		reg_lst.add(r);
		i=b.insert(reg_lst);
		session.setAttribute("accountNumber", accNo);
		session.setAttribute("Reglst", reg_lst);
		
		if(i>0)
		{
			response.sendRedirect("SucccesfullyRegister.jsp");
		}
		else {
			response.sendRedirect("Error.jsp");
			
		}


	}

}
