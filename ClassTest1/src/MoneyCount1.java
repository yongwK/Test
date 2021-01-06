import java.util.Scanner;

public class MoneyCount1 {
	Scanner sc = new Scanner(System.in);
	int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };
	public MoneyCount1() {
		
		System.out.print("금액입력 = ");
		int wonInt = sc.nextInt();
		
		for(int i = 0; i<money.length; i++) {
			int cnt = wonInt / money[i];
			if(cnt > 0) {
				System.out.print(money[i] + "원 =" + cnt);
				if(money[i] >= 1000) {
					System.out.println("장");
				}else {
					System.out.println("개");
				}
				
				//차액 계산
				wonInt -= (cnt*money[i]);
			}
		}
	}

	public static void main(String[] args) {
		new MoneyCount1();

	}

}
