package apiClass;

import java.util.Random;
import java.util.Scanner;

public class RoDDo {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	boolean[] numSwitch = new boolean[45];
	int[] r_num = new int[7];
	int temp;
	public RoDDo() {

	}

	
	
	
	
	public void start() {
		//한게임 더? 돌리기
		while(true) {
			System.out.print("게임수 = ");
			int gameNum = sc.nextInt();
		
			//게임 횟수묻기
			int w = 0;
			while(w<gameNum) {
				System.out.print( (w+1) + "게임=[");
					
					
				// 중복검사
				for(int r = 0; r <numSwitch.length; r++) {
					numSwitch[r] = false;
				}
				
				// 중복검사 및 난수 생성
				int c = 0;
				while(c<7) {
					int r = ran.nextInt(45)+1;
					if(numSwitch[r-1] == false) {
						numSwitch[r-1] = true;
						r_num[c] = r;
						c++;
					}
				}
				
								
					
					
				// 순서 정렬
				for(int j = 0; j<r_num.length-2; j++) {
					for(int k=j+1; k<r_num.length; k++) {
						if(r_num[j]>r_num[k]) {
							temp = r_num[j];
							r_num[j] = r_num[k];
							r_num[k] = temp;
						}
					}
				}
				for(int l = 0; l<r_num.length-1; l++) {
					if(l == 5) {
						System.out.print(r_num[l]);
					}
					else {
						System.out.print(r_num[l]+",");
					}
				}
				
				System.out.print("], bonus=");
				System.out.println(r_num[6]);
				w++;	
			}
				
			int choice;
			while(true) {
				System.out.println("계속하시겠습니까(1:예,2:아니오)");
				choice = sc.nextInt();
				if(choice == 1 || choice == 2 ) {
					break;
				}
				else {
					System.out.println("숫자 1, 2 둘중에 하나만 선택하세요");
				}
			}
			if (choice == 1) {
				continue;
			}
			else {
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
	new RoDDo().start();	

	}

}
