package Bank.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import Bank.Dao.BankInterface;
import Bank.Dao.BankInterfaceImplementation;
import Bank.Model.ErrorLogin;
import Bank.Model.Login;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int AccNO;
	HttpSession session=request.getSession();
		String usernm=request.getParameter("unm");
		String pass=request.getParameter("password");
		Login l=new Login();
		l.setPassword(pass);
		l.setUser_name(usernm);
		List<Login>lst =new ArrayList<Login>();
	
		BankInterface b=new BankInterfaceImplementation();
		lst=b.Login(l);
		Login log=lst.get(0);
		AccNO=log.getAccNo();
		session.setAttribute("AccNo",AccNO);
		
		System.out.println(log.getUser_name()+"\t "+log.getPassword());
		if(usernm.equals(log.getUser_name()))		
		{
			if( pass.equals(log.getPassword()))
			{
				

			session.setAttribute("AccNo",AccNO);
			response.sendRedirect("DashBoard.jsp");
			}
			else {
				ErrorLogin e1=new ErrorLogin( 2,"Account Number Wrong");
				session.setAttribute("errorPass",e1);

			}
		}
		else {
			ErrorLogin e=new ErrorLogin(1, "User Name Not Found");
			session.setAttribute("errorAcNo",e);
			response.sendRedirect("LoginError.jsp");
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
