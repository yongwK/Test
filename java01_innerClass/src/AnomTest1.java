
public class AnomTest1 {

	public AnomTest1() {
		start();
	}

	public void start() {
		
		new Sample() {
			
			public void sum(int max) {
				int num = 5;
				for(int i = 6; i<=10; i++) {
					num +=i;
				}
				System.out.println(num);
			}
			
			
		}.sum(1);
		
		
		
		
	}
	public static void main(String[] args) {
		new AnomTest1();

	}

}
