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
 * Servlet implementation class UpdateData
 */
@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int i=0;
	HttpSession session = request.getSession();

	String nm=request.getParameter("nm");
	String mail=request.getParameter("email");
	String unm=request.getParameter("unm");
	String pass=request.getParameter("pass");
	Registor r=new Registor(nm, mail, unm, pass);
	int acc_num = (int) session.getAttribute("AccNo");
		BankInterfaceImplementation bdao=new BankInterfaceImplementation();
		i=bdao.UpdateData(r,acc_num);
		if(i>0)
		{
			response.sendRedirect("DashBoard.jsp");
		}
		else {
			response.sendRedirect("Error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
