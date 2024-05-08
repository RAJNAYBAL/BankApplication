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
import Bank.Model.Recharge;

/**
 * Servlet implementation class RechargeHistoryController
 */
@WebServlet("/RechargeHistoryController")
public class RechargeHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeHistoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
	BankInterfaceImplementation bdao=new BankInterfaceImplementation();
		List<Recharge> lst=new LinkedList<Recharge>();
		int acc_num=(int) session.getAttribute("AccNo");
		lst=bdao.RetriewRechargeHis(acc_num);
		session.setAttribute("Rechargelst", lst);
		Recharge r=lst.get(0);
		int index_recharge=r.getIndex();
		session.setAttribute("recharge_index",index_recharge );
		
		
		if(lst!=null)
		{
			response.sendRedirect("RechargeHistoryView.jsp");
		}
		else {
			response.sendRedirect("RechargeError.jsp");
		}
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
