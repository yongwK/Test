package mem;

public class memVo {

	
	private int memNO;
	private String memName;
	private String tel;
	private String addr;
	
	public memVo() {	}

	public memVo(int memNo, String memName, String tel, String addr) {
		this.memNO = memNo;
		this.memName = memName;
		this.tel = tel;
		this.addr = addr;
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
	
	
	
}
