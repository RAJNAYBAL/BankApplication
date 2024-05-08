package Bank.Dao;

import java.util.List;

import Bank.Model.Recharge;

public interface RechargeInterface {
	
	public int Recharge(Recharge lst,int ac_no);

	public List<Recharge> RetriewRechargeHis(int ac_no);
	 

}
