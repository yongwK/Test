
public class ExceptionTest2 {

	
	
	
	
	
	public ExceptionTest2() {

			try {
					//실행부				
					int data[] = {10,8,95,32,54};
					System.out.println(data[data.length-1]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열의 index를 잘못 사용하였습니다...>>>" + e.getMessage());
			}finally {
				System.out.println("finally : 무조건 한번은 실행됨...");
			}

		
	}

	
	
	
	public static void main(String[] args) {
		new ExceptionTest2();

	}

}
