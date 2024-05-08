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
import Bank.Model.NetBankingNft;

/**
 * Servlet implementation class NFTController
 */
@WebServlet("/NFTController")
public class NFTController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NFTController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<NetBankingNft> lst=new LinkedList<NetBankingNft>();
		HttpSession session=request.getSession();
		int i=0;
		String nftAccNo=request.getParameter("AccNo");
		String Name=request.getParameter("Name");
		String ifsc=request.getParameter("Ifsc");
		int amt=Integer.parseInt(request.getParameter("amount"));
		int ac_no=(int) session.getAttribute("AccNo");

		NetBankingNft nft=new NetBankingNft(nftAccNo, Name, ifsc, amt, ac_no);
		lst.add(nft);
		BankInterfaceImplementation bdao=new BankInterfaceImplementation();
		i=bdao.InsertNft(lst);
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
