package mem;

public class MemVo {

	
	private int memNO;
	private String memName;
	private String tel;
	private String addr;
	private String id;
	private String pwd;
	private String leanbookName;
	private String borrowDate;
	private String dueDate;
	
	public MemVo() {	}

	public MemVo(int memNo, String memName, String tel,
			String addr, String id, String pwd, String leanBookName,  String borrowDate, String dueDate ) {
		this.memNO = memNo;
		this.memName = memName;
		this.tel = tel;
		this.addr = addr;
		this.id = id;
		this.setPwd(pwd);
	}

	public int getMemNO() {
		return memNO;
	}

	public void setMemNO(int memNO) {
		this.memNO = memNO;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getLeanbookName() {
		return leanbookName;
	}

	public void setLeanbookName(String leanbookName) {
		this.leanbookName = leanbookName;
	}

	public void memPrt() {
		System.out.println(memNO + "\t" + memName + "\t" + tel + "\t" + addr + "\t" + id + "\t" + pwd + "\n" );
	}
	
}
