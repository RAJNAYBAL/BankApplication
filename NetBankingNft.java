package Bank.Model;

public class NetBankingNft {
	private String nftAccNo;
	private String Name;
	private String ifsc;
	private int amt;
	private int acc_number;
	private String date;
	public NetBankingNft(String nftAccNo, String name, String ifsc, int amt, int acc_number, String date) {
		super();
		this.nftAccNo = nftAccNo;
		Name = name;
		this.ifsc = ifsc;
		this.amt = amt;
		this.acc_number = acc_number;
		this.date = date;
	}
	
	public NetBankingNft(String nftAccNo, String name, String ifsc, int amt, int acc_number) {
		super();
		this.nftAccNo = nftAccNo;
		Name = name;
		this.ifsc = ifsc;
		this.amt = amt;
		this.acc_number = acc_number;
	}

	public String getNftAccNo() {
		return nftAccNo;
	}
	public void setNftAccNo(String nftAccNo) {
		this.nftAccNo = nftAccNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public int getAcc_number() {
		return acc_number;
	}
	public void setAcc_number(int acc_number) {
		this.acc_number = acc_number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	

}
