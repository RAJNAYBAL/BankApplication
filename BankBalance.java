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
import Bank.Model.Balance;

/**
 * Servlet implementation class BankBalance
 */
@WebServlet("/BankBalance")
public class BankBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankBalance() {
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
       List<Balance> blst=new LinkedList<Balance>();
		BankInterface bdao=new BankInterfaceImplementation();
		HttpSession session=request.getSession();
		int rechargeAmt=(int)session.getAttribute("amt");
		int acNo=(int) session.getAttribute("AccNo");
		blst=bdao.BalanceShow(acNo);
		session.setAttribute("balancelst", blst);
		Balance b=blst.get(0);
		int balance=b.getTotalbalance();
		session.setAttribute("AvailbleBal", balance);
		
		
		
		

	}

}
