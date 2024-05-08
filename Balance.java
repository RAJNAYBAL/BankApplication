package Bank.Model;

public class Balance {
	int index;
	int register_index;
	int recharge_index;
	int totalbalance;
	
	
	public Balance() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Balance(int register_index, int recharge_index, int totalbalance) {
		super();
		this.register_index = register_index;
		this.recharge_index = recharge_index;
		this.totalbalance = totalbalance;
	}

	public Balance(int index, int register_index, int recharge_index, int totalbalance) {
		super();
		this.index = index;
		this.register_index = register_index;
		this.recharge_index = recharge_index;
		this.totalbalance = totalbalance;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getRegister_index() {
		return register_index;
	}
	public void setRegister_index(int register_index) {
		this.register_index = register_index;
	}
	public int getRecharge_index() {
		return recharge_index;
	}
	public void setRecharge_index(int recharge_index) {
		this.recharge_index = recharge_index;
	}
	public int getTotalbalance() {
		return totalbalance;
	}
	public void setTotalbalance(int totalbalance) {
		this.totalbalance = totalbalance;
	}
	
	
	

}
