import java.util.Random;
import java.util.Scanner;

public class LottoSolo {
	
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	public LottoSolo() {
		
	}

	
	
	public void start() {
		while(true) {
			System.out.print("게임수 = ");
			int game = sc.nextInt();
			
			int w = 0;
			while(w<game) {
				
				
				//랜덤값생성
				int[] random = new int[7];
				for(int i = 0; i<random.length; i++) {
					random[i] = ran.nextInt(45)+1;
					//중복값제거
					for(int check = 0; check<i; check++) {
						if(random[check] == random[i]) {
							// 중복값일경우 i번쨰를 새로운 값으로 다시 뽑는다.
							i--;
						}
					}
				}
				
				//배열 정렬
				int temp;
				for(int i = 0; i<random.length-2; i++) {
					for(int j = 0; j<random.length-2-i; j++) {
						if( random[j] > random[j+1]) {
							temp = random[j];
							random[j] = random[j+1];
							random[j+1] = temp;
						}
					}
				}
				// 번호 출력
				System.out.print( (w+1) + "게임=[");
				for(int i =0; i<random.length-1; i++) {
					if(i == 5) {
						System.out.print( random[i]+ "],");
					}
					else {
						System.out.print(random[i] + ", ");
					}
				}
					
				System.out.println(" bonus= " + random[6]);
				w++;	
				}
			
			System.out.println("계속하시겠습니까(1:예,2:아니오)?");
			int choice = sc.nextInt();
			if(choice == 2) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
		}
	}
	
	public static void main(String[] args) {
	new LottoSolo().start();	

	}

}
