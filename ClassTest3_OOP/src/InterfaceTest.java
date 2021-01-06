// 인터페이스도 추상클래스이므로 객체 생성을 할 수 없다.
// 추상메서드 들의 집합
// 인터페이스간의 상속은 extends 를 사용하고
// 클래스와 인터페이스간의 상속은 implement를 사용한다.
public interface InterfaceTest extends InterfaceTest2{
	// static 멤버변수들 (접근제한자는 무조건 public)
	public static String global = "서울";
	public static final int MAX = 100; // final 이라는 키워드가 붙으면 다른 값으로 변경할수 없는 키워드
									   // 상수화된 변수라고 한다. (100이외의 데이터 값을 대입할수 없다)
	// 추상메서드들
	// 인터페이스에서 추상메서드에 abstract를 안써줘도된다.
	public void print();
	public int[] recordAll(int num);
	public String total(int max);
	
	

	
	
	
}
