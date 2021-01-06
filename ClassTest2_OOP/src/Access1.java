class Access1 {
	private String userid = "goguma"; //private은 같은 패키지 같은 클래스안에서만 허용
	String userpwd = "ggm1234";
	Access1() {
		System.out.println("아이디= " + userid);
	}

	// 접근제한자 반환명 메소드명()
	void printData() {
		System.out.println("id = " + userid);
		System.out.println("pwd = " + userpwd);	}
}


// a클래스(상위)  < -b클래스(하위)    b가 a를 상속받음 (b가 a의 기능을 사용할수 있음)
// 상속받을떄의 키워드는 extends  (클 - 클 / 1개만 상속받을수 있다.) 
// 2개 이상을 받고 싶을때는 a <- b <- c 이렇게 하면 c는 모든 기능 사용가능