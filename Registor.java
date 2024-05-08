package Bank.Model;

public class Registor {
	private int ac_no;
	private String cust_name;
	private double pan_no;
	private double adhar_no;
	private String bank_branch;
	private String mail;
	private String user_name;
	private String password;
	
	
	public Registor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Registor(String user_name, String password) {
		super();
		this.user_name = user_name;
		this.password = password;
	}
	

	public Registor(String cust_name, String mail, String user_name, String password) {
		super();
		this.cust_name = cust_name;
		this.mail = mail;
		this.user_name = user_name;
		this.password = password;
	}

	public Registor(int ac_no, String cust_name, double pan_no, double adhar_no, String bank_branch, String mail,
			String user_name, String password) {
		super();
		this.ac_no = ac_no;
		this.cust_name = cust_name;
		this.pan_no = pan_no;
		this.adhar_no = adhar_no;
		this.bank_branch = bank_branch;
		this.mail = mail;
		this.user_name = user_name;
		this.password = password;
	}

	public int getAc_no() {
		return ac_no;
	}

	public void setAc_no(int ac_no) {
		this.ac_no = ac_no;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public double getPan_no() {
		return pan_no;
	}

	public void setPan_no(double pan_no) {
		this.pan_no = pan_no;
	}

	public double getAdhar_no() {
		return adhar_no;
	}

	public void setAdhar_no(double adhar_no) {
		this.adhar_no = adhar_no;
	}

	public String getBank_branch() {
		return bank_branch;
	}

	public void setBank_branch(String bank_branch) {
		this.bank_branch = bank_branch;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}