import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class LottoSolo2 {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	public LottoSolo2() {

	}

	
	public void start() {
		do {
			System.out.print("게임수 = ");
			int game = sc.nextInt();
			
			for(int cnt = 0; cnt<game; cnt++) {
				
				//로또 번호 생성
				int[] lotto = new int[7];
				for(int i = 0; i<lotto.length; i++ ) {
					lotto[i] = ran.nextInt(45)+1;
					//중복 번호 확인
					for(int check = 0; check<i; check++) {
						if(lotto[check] == lotto[i]) {
							i--;
						}
					}
				}
				
				//배열 정렬
				int temp;
				for(int i= 0; i<lotto.length-2; i++) {
					for(int j = i+1; j<lotto.length-1; j++) {
						if(lotto[i]>lotto[j]) {
							temp = lotto[i];
							lotto[i] = lotto[j];
							lotto[j] = temp;
						}
					}
				}
				
				//숫자 출력
				System.out.print(cnt+1 + "게임=[");
				for(int i = 0; i<lotto.length-1; i++) {
					System.out.print(lotto[i]);
					if(i==5) {
						System.out.print("],");
					}
					else {
						System.out.print(", ");
					}
				}	
				System.out.println(" bonus = " + lotto[lotto.length-1]);	
			}
			
			
			System.out.print("계속하시겠습니까(1:예, 2:아니오)?");
			int choice = sc.nextInt();
			if( choice == 2) {
				break;
			}
		}while(true);
		System.out.println("프로그램을 종료합니다.");
	}
	
	
	public static void main(String[] args) {
		new LottoSolo2().start();

	}

}
