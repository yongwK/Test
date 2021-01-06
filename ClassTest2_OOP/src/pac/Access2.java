package pac;

public class Access2 {
	private int num  = 100; // public 은 멤버변수에 잘안씀
	private String name = "홍길동"; 
	public Access2() {

	}
	//getter, setter 캡슐화 해서 외부에서 접근할수 있게 하는것
	public String getName() {
		return this.name; // this = Access2의미
	}
	
	public void setName(String name) {
		this.name = name;
	}
	//getter, setter 캡슐화 해서 외부에서 접근할수 있게 하는것
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) { // 외부에서 값을 받아 멤버변수를 변환
		//기능구현
		if(num%100 ==0) {
			this.num = num;
		}
		
	}
	
	//  getter, setter 를사용하는 경우는 
	// 멤버 변수가 private 되어있을때 외부에서 접근할수 있게 할때 사용한다.
	
	
}
