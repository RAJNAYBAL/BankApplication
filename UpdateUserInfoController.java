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

import Bank.Dao.BankInterfaceImplementation;
import Bank.Model.Registor;

/**
 * Servlet implementation class UpdateUserInfoController
 */
@WebServlet("/UpdateUserInfoController")
public class UpdateUserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    List<Registor>lst=new LinkedList<Registor>();
		BankInterfaceImplementation bdao=new BankInterfaceImplementation();
		lst=bdao.retriveRecordForUpdate();
		HttpSession session=request.getSession();
		session.setAttribute("updatelst", lst);
		if(lst!=null)
		{
			response.sendRedirect("UdateView.jsp");
		}
		else {
			response.sendRedirect("DashBoard.jsp");
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
