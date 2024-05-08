package Bank.Dao;

import java.util.ArrayList;
import java.util.List;

import Bank.Model.NetBankingNft;
import Bank.Model.Registor;

public interface NetbankingInterface {

	int addMoney(Registor r,int amount);
	int InsertNft(List<NetBankingNft> lst);

}
