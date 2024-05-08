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

import Bank.Dao.BankInterface;
import Bank.Dao.BankInterfaceImplementation;
import Bank.Model.Balance;
import Bank.Model.Recharge;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
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
	
		int i;
		BankInterfaceImplementation bdao=new BankInterfaceImplementation();

		List<Recharge> lst=new ArrayList<>();
		HttpSession session=request.getSession();
		int acc_num=(int)session.getAttribute("AccNo");
		/*
		 * int recharge_index=(int)session.getAttribute("recharge_index");
		 * bal=(int)session.getAttribute("AvailbleBal");
		 */
		lst =bdao.RetriewRechargeHis(acc_num);
		Recharge r=lst.get(0);
		long bal=r.getBalance();
		int recharge_amt=(int)session.getAttribute("amt");
		bal=bal-recharge_amt;
		
		i=bdao.UpdateBalance(r);
		if(i>0)
		{
			response.sendRedirect("SuccesfullyRecharge.jsp");
		}
		else {
			response.sendRedirect("Error.jsp");
		}
		
	}

}
