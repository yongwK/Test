import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto2 {
Scanner sc = new Scanner(System.in);
Random ran = new Random();
	public Lotto2() {
	
	}
	
	public void start() {
		do {
			System.out.print("게임수=");
			int game = sc.nextInt();
			
			// 입력받은 게임수 만큼 로또번호 처리한다.
			for(int cnt = 1; cnt<=game; cnt++) { // cnt-> 1,2,3,4.......
			
			
				
				// 로또 1게임.........
				//1게임 값을 저장할 배열 생성
				int[] lotto = new int[7]; // index 0 ~ 6
				
				// 1~45 사이의 랜덤값 7개 생성
				for(int i = 0; i<lotto.length; i++) {
					lotto[i] = ran.nextInt(45)+1;  // 1~45사이의 무작위 번호
					//중복검사
					for(int check = 0; check<i; check++) {
						if(lotto[check] == lotto[i]) { // 중복값일때 ex) i =2일떄 check 0,1까지 중복된값이 일는지 확인
							i--;
						}
					}
				}
				
				Arrays.sort(lotto, 0, 6);
	
				//출력
				System.out.print(cnt +"게임=[");
				for(int i=0; i<lotto.length-1; i++) { // 0 1 2 3 4 5 
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
			//계속 여부 확인
			System.out.print("계속하시겠습니까(1:예,2:아니오)?");
			int que = sc.nextInt();
			if(que == 2) {
				break; // 반복문 중지
			}
		}while(true);
		System.out.println("프로그램이 종료 되었습니다.");
		
	
	}
	
	public static void main(String[] args) {
	

	}

}
