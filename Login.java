package Bank.Model;

public class Login {
	private int accNo;
	private String user_name;
	private String password;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(int acNo,String user_name, String password) {
		super();
		this.accNo=acNo;
		this.user_name = user_name;
		this.password = password;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
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
