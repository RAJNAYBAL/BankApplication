package Bank.Model;

public class Recharge {
	private int index;
	private String phNo;
	private String card;
	private double amont;
	private String date;
	private int ac_num;
	private long balance;
	public Recharge() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Recharge(int index, String phNo, String card, double amont, String date,int ac_num,long balance) {
		super();
		this.index = index;
		this.phNo = phNo;
		this.card = card;
		this.amont = amont;
		this.date = date;
		this.ac_num = ac_num;
		this.balance=balance;
		
	}

	public Recharge(String phNo, String card, double amont,int ac_num) {
		super();
		this.phNo = phNo;
		this.card = card;
		this.amont = amont;
		this.ac_num = ac_num;
	}
	
	
	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public double getAmont() {
		return amont;
	}
	public void setAmont(double amont) {
		this.amont = amont;
	}
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	public int getAc_num() {
		return ac_num;
	}

	public void setAc_num(int ac_num) {
		this.ac_num = ac_num;
	}


}
