package Bank.Dao;

import java.util.List;

import Bank.Model.Registor;
import Bank.Model.Balance;
import Bank.Model.Recharge;

public interface BankInterface {
	public int insert(List<Registor> lst);
	public long generateAccNo();
	public List<Registor> ShowData(int accNo);
	public List<Bank.Model.Login> Login(Bank.Model.Login l);
	public int UpdateBalance(Recharge b);
	 public List<Balance> BalanceShow(int id);


}
