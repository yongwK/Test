import java.util.Scanner;

public class MoneyCount2 {
	Scanner sc = new Scanner(System.in);
	
	public MoneyCount2() {
		
	}

	
	public void start() {
		int money = 50000;
		int div = 5;
	
		System.out.println("금액입력=");
		int wonInt = sc.nextInt(); // 54243
	
		while(wonInt>0) {
			int cnt = wonInt / money;
			if(cnt>0) {
				String dan = "개";
				if(money>=1000) {
					dan = "장";
				}
			
				System.out.println(money + "원->" + cnt + dan );
				wonInt -= (money*cnt);
			}
			money = money / div; // 
			if(div == 5) 
				div =2;
			else 
				div = 5;
		}
	}
	
	public static void main(String[] args) {
		new MoneyCount2().start();
		

	}

}
