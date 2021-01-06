import java.util.Scanner;

public class MoneyCount3 {

	Scanner sc = new Scanner(System.in);
	public MoneyCount3() {
		
	}
	
	
	public void start() {
	System.out.println("실행");	
	System.out.print("금액을 입력하세요?= ");	
	int money = sc.nextInt();
	
	int[] changeMoney = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
	for(int i = 0; i<changeMoney.length; i++) {
		int result = money / changeMoney[i];
		if(result > 0) {
			if(money>=1000) {
				System.out.println(changeMoney[i] + "원="+ result + "장");
			}
			else {
				System.out.println(changeMoney[i] + "원="+ result + "개");
			}
		}
		money = money % changeMoney[i];	
	}
	}
	
	
	public static void main(String[] args) {
	new MoneyCount3().start();	

	}

}
