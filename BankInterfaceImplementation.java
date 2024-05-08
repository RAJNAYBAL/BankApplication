package Bank.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Bank.DbConnection.MyConnection;
import Bank.Model.Registor;
import Bank.Model.Balance;
import Bank.Model.Login;
import Bank.Model.NetBankingNft;
import Bank.Model.Recharge;
public class BankInterfaceImplementation implements BankInterface,RechargeInterface,NetbankingInterface{

	@Override
	public int insert(List<Registor> lst) {

		int i=0;
		Connection con=null;
		Registor r=lst.get(0);
		con=MyConnection.Connect();

		try {
			PreparedStatement pst=con.prepareStatement("insert into Registor values(?,?,?,?,?,?,?,?,Balance)");
			//long account_number=generateAccNo();
			//pst.setInt(1,(int) account_number);
			pst.setInt(1,r.getAc_no());

			pst.setString(2, r.getCust_name());
			pst.setDouble(3, r.getPan_no());
			pst.setDouble(4, r.getAdhar_no());
			pst.setString(5, r.getBank_branch());
			pst.setString(6, r.getMail());
			pst.setString(7, r.getUser_name());
			pst.setString(8, r.getPassword());
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public long generateAccNo() {
		Connection con=null;
		ResultSet rs;
		con=MyConnection.Connect();
		try {
			PreparedStatement pst=con.prepareStatement("select acc_number from registor order by acc_number DESC LIMIT 1");
			rs=pst.executeQuery();

			if(rs.next())
			{
				long acc_numGenerate=rs.getInt("acc_number");
				return acc_numGenerate+1;	
			}
			else
			{
				return 100100;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 100100;
	}

	public List<Registor> ShowData(int accNo){
		List<Registor> lst=new LinkedList<Registor>();
		ResultSet rs;
		Connection con=null;
		Registor r=new Registor();
		con=MyConnection.Connect();


		try {


			Statement pst=con.createStatement();
			rs=pst.executeQuery("select * from Registor where acc_number="+accNo);


			while(rs.next())
			{
				int ac_no=rs.getInt(1);
				String cust_name=rs.getString(2);
				double pan_no=rs.getDouble(3);
				double adhar_no=rs.getDouble(4);
				String bank_branch=rs.getString(5);
				String mail=rs.getString(6);
				String user_name=rs.getString(7);
				String password=rs.getString(8);
				Registor r1=new Registor(ac_no, cust_name, pan_no, adhar_no, bank_branch, mail, user_name, password);
				lst.add(r1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;	
	}

	@Override
	public List<Bank.Model.Login> Login(Login lst) {
		int i;

		ResultSet rs;
		Login l;
		Connection con=null;
		Registor r=new Registor();
		List<Login> loginlst=new ArrayList<Login>();
		con=MyConnection.Connect();



		try {
			//				Statement st=con.createStatement();
			//				rs=st.executeQuery("select user_name,password from Registor where  user_name='?'");
			//				
			PreparedStatement pst=con.prepareStatement("select acc_number,user_name,password from Registor where  user_name=?");
			pst.setString(1,lst.getUser_name());
			rs=pst.executeQuery();
			while(rs.next())
			{
				int acNO=rs.getInt(1);
				String userName=rs.getString(2);
				String password=rs.getString(3);
				l=new Login(acNO,userName, password);
				loginlst.add(l);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return loginlst;
	}

	@Override
	public int Recharge(Recharge r,int ac_no) {
		//		int i=1;
		ResultSet rs;
		Connection con;
		con=MyConnection.Connect();
		int balance=0;
		double bnc=GetBalance(ac_no);

		System.out.println("Balance"+bnc );


		try {
			PreparedStatement ps=con.prepareStatement("UPDATE recharge set current_balance=(select Balance from registor where acc_number=?) where acc_num=? order by Index_number desc limit 1");

			ps.setInt(1,ac_no);
			ps.setInt(2,ac_no);

			ps.executeUpdate();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}






		String s="select Current_balance from recharge  where acc_num=? order by Index_Number DESC LIMIT 1";
		try {
			PreparedStatement psts=con.prepareStatement(s);
			psts.setInt(1,ac_no);
			rs=psts.executeQuery();
			while(rs.next())
			{
				balance=rs.getInt("Current_balance");
				balance=(int) (balance-r.getAmont());
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String str="insert into Recharge(contact_no,card_name,amount,acc_num) values(?,?,?,?)";
		try {
			PreparedStatement pst=con.prepareStatement(str);
			pst.setString(1, r.getPhNo());
			pst.setString(2, r.getCard());
			pst.setDouble(3, r.getAmont());
			pst.setInt(4,r.getAc_num());
			//		pst.setLong(5, r.getBalance());
			pst.execute();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if(true)
			{
				PreparedStatement st=con.prepareStatement("Update recharge set Current_balance=? where acc_num=? And contact_no=?");
				st.setDouble(1,balance);
				st.setInt(2, ac_no);
				st.setString(3, r.getPhNo());
				st.executeUpdate();
				System.out.println(r.getPhNo());
			}
			else {
				System.out.println("NOT UPDATED");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		if(true) {
			try {
				PreparedStatement ps=con.prepareStatement("Update registor set Balance=(select Current_balance from recharge  where acc_num=? order by Index_Number DESC LIMIT 1) where acc_number=?");
				ps.setInt(1,ac_no);
				ps.setInt(2,ac_no);
				ps.executeUpdate();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}

		return 1;
	}





	/*
	 * public int updateBalance() { int bal; ResultSet rs; Connection con =
	 * MyConnection.Connect(); String str="select * from Balance"; PreparedStatement
	 * pst=con.prepareStatement(str); rs=pst.executeQuery(); while(rs.next()) { //
	 * bal=rs.ge }
	 * 
	 * return bal; }
	 */

	@Override
	public List<Recharge> RetriewRechargeHis(int ac_no) {

		List<Recharge> lst=new LinkedList<Recharge>();
		ResultSet rs;
		Connection con = MyConnection.Connect();
		String str="select * from Recharge where acc_num="+ac_no;
		try {
			PreparedStatement st=con.prepareStatement(str);
			rs=st.executeQuery();
			while(rs.next())
			{
				int index=rs.getInt(1);
				String phNo=rs.getString(2);
				String card=rs.getString(3);
				double amont=rs.getDouble(4);	
				String date=rs.getDate("date_of_Recharge").toString();
				int ac_num=rs.getInt(6);
				long balance=rs.getInt("Current_balance");
				Recharge r=new Recharge(index, phNo, card, amont, date,ac_no,balance);
				lst.add(r);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lst.size() > 0 ? lst : null;
	}

	@Override
	public List<Balance> BalanceShow(int id) {
		List<Balance> lst=new LinkedList<Balance>();
		ResultSet rs; 
		Balance b;
		Connection con =MyConnection.Connect(); 
		String str="SELECT reg.acc_number, reg.cust_name, r.contact_no, r.card_name, r.amount, r.date_of_Recharge,b.Balance FROM Recharge r JOIN Balance b ON r.acc_num = b.recharge_index JOIN registor reg ON reg.acc_number = r.acc_num;"; 
		try {
			PreparedStatement st=con.prepareStatement(str); 
			rs=st.executeQuery();
			while(rs.next()) 
			{ 
				int acc_number=rs.getInt(1);
				String Cust_name=rs.getString(2);
				String Contact_no=rs.getString(3);
				String Card_name=rs.getString(4);
				long amount=rs.getInt(6);
				String date_of_recharge=rs.getString(7);
				long Balance=rs.getLong(8);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return lst;
	}

	public List<Registor> retriveRecordForUpdate()
	{
		List<Registor> lst=new LinkedList<Registor>();
		ResultSet rs;
		Registor r;
		Connection con =MyConnection.Connect(); 

		try {
			PreparedStatement pst=con.prepareStatement("select cust_name,mail,user_name,password from registor");
			rs=pst.executeQuery();
			while(rs.next())
			{
				String nm=rs.getString("cust_name");
				String mail=rs.getString("mail");
				String unm=rs.getString("user_name");
				String pass=rs.getString("password");
				r=new Registor(nm, mail, unm, pass);
				lst.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;

	}


	@Override
	public int UpdateBalance(Recharge b) {
		int i=0;

		try {
			Connection con =MyConnection.Connect(); 
			String str="update recharge set Balance=? where acc_num=?"; 
			PreparedStatement pst=con.prepareStatement(str);
			pst.setLong(1,b.getBalance());
			pst.setInt(2,b.getAc_num());
			i=pst.executeUpdate();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int addMoney(Registor r,int amount) {
		int i=0;
		List<Registor> lst=new LinkedList<Registor>();
		ResultSet rs; 
		Balance b;
		Connection con =MyConnection.Connect(); 

		Registor r1=new Registor();
		int ac=r.getAc_no();
		String pass=r.getPassword();
		String str="select * from Registor where acc_number=? and password=?";
		try {
			PreparedStatement pst=con.prepareStatement(str);
			pst.setInt(1, ac);
			pst.setString(2, pass);
			rs=pst.executeQuery();
			AddBalance(amount, ac);
			while(rs.next())
			{
				int acc=rs.getInt("acc_number");
				String s="update balance set Balance=Balance+? where registor_index=?";
				PreparedStatement st=con.prepareStatement(s);
				st.setInt(1, amount);
				st.setInt(2, acc);
				i=st.executeUpdate();
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}


	public void AddBalance(int amt,int ac_no) {
		int i=0;
		ResultSet rs;
		Connection con =MyConnection.Connect(); 
		int bal;
		System.out.println(amt+"UPDATE ME HAI "+ac_no);
		try {
			PreparedStatement pst=con.prepareStatement("Update Registor set Balance=Balance+? where acc_number=?");
			pst.setInt(1, amt);
			pst.setInt(2, ac_no);			
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int InsertNft(List<NetBankingNft> lst) {
		int i=0;
		NetBankingNft nft=lst.get(0);
		int amount=nft.getAmt();
		int ac_no=nft.getAcc_number();
		System.out.println(amount+"\t"+ac_no);
		Connection con =MyConnection.Connect(); 
		try {
			PreparedStatement pst=con.prepareStatement("insert into NetBank values(?,?,?,?,?,date_of_NetBank)");
			pst.setString(1, nft.getNftAccNo());
			pst.setString(2, nft.getName());
			pst.setString(3, nft.getIfsc());
			pst.setInt(4, nft.getAmt());
			pst.setInt(5, nft.getAcc_number());
			i=pst.executeUpdate();
			if(i>0)
			{
				UpdateBalance(amount,ac_no);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public void UpdateBalance(int amt,int ac_no) {
		int i=0;
		ResultSet rs;
		Connection con =MyConnection.Connect(); 
		int bal;
		System.out.println(amt+"UPDATE ME HAI "+ac_no);
		try {
			PreparedStatement pst=con.prepareStatement("Update Registor set Balance=Balance-? where acc_number=?");
			pst.setInt(1, amt);
			pst.setInt(2, ac_no);			
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double GetBalance(int ac_no)
	{
		double bal = 0;
		ResultSet rs;
		Connection con =MyConnection.Connect(); 
		try {
			PreparedStatement pst=con.prepareStatement("select Balance from registor where acc_number=? ");
			pst.setInt(1, ac_no);
			rs=pst.executeQuery();
			while(rs.next())
			{
				bal=rs.getDouble("Balance");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bal;
	}

	public int UpdateData(Registor r,int ac_no){
		int i=0;
		Connection con =MyConnection.Connect(); 
		try {
			PreparedStatement pst=con.prepareStatement("Update Registor set cust_name=?,mail=?,user_name=?,password=? where acc_number=?");
			pst.setString(1, r.getCust_name());
			pst.setString(2, r.getMail());
			pst.setString(3,r.getUser_name());
			pst.setString(4, r.getPassword());
			pst.setInt(5, ac_no);
			i=pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}
