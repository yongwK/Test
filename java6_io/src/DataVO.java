import java.io.Serializable;
//다른곳으로 보낼수 있는 객체가 된것이다.
public class DataVO implements Serializable {

	private int num;
	private String name;
	private String tel;
	private String email;
	
	public DataVO() {
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
