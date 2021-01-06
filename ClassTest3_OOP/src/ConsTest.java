
public class ConsTest {
	String name;
	String tel;
	String addr;
	
	
	// this() 는 생성자메소드 내에서 다른 생성자메소드를 호출하는 기능을 한다. 
	public ConsTest() {
		System.out.println("생성자 실행됨.....");
	}
	
	

	public ConsTest(String name) {
		this();
		this.name = name;
	}
	
	
	
	public ConsTest(String name, String tel) {
	//	this.name = name;
		this(name);
		this.tel = tel;
	}
	
	
	public ConsTest(String name, String tel, String addr) {
		//this.name = name;
		//this.tel = tel;   반복되는 경우 생성자를 호출하면된다
		this(name, tel); // 생성자 호출의 경우는 this를 통해서 호출해준다. - 단 첫번쨰 실행문이여야 한다.
		this.addr = addr;
	}
	
	public void print() {
		System.out.printf("%s, %s, %s\n", name,tel,addr);
	}
	
	
	public static void main(String[] args) {
		//ConsTest ct1 = new ConsTest();
		//ct1.print();
	
		//ConsTest ct2 = new ConsTest("홍길동", "010-7777-8888");
		//ct2.print();
		
		ConsTest ct3 = new ConsTest("이순신", "010-9999-2222", "서울시 종로구");
		ct3.print();
		
	}
}
