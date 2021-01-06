import java.util.Scanner;



public class Diamond {
	Scanner sc = new Scanner(System.in);

	public Diamond() {
		
	}
	
	public void start() {
		//임의의 홀수입력 입력받기
		System.out.print("임의의 홀수입력(1~49)=");
		int max = sc.nextInt();
		
		// 짝수가 들어오면 홀수로 변경한다.
		if( max % 2 == 0) max--;
		
		//출력할 문자의 초기값
		char txt = 'A';
		
		//삼각형 만드는작업
		// 행				   9 (가정)
		for(int row = 1; row<=max; row+=2) { //row = 1, 3, 5, 7, 9....(문자가 생성되는 갯수)
			//공백처리					 (9-1)/2 = 4
			for(int space = 1; space<=(max-row)/2; space++) { // space = 1,2,3,4
				System.out.print(" ");
			}
			
			//문자출력
			for(int col = 1; col<=row; col++) { // col<=(갯수) 이므로 1,3,5,7,쭉간다.
				System.out.print(txt++);
				if(txt > 'Z') { //Z까지 출력 후 A로 초기화 
					txt = 'A';
				}
			}
			System.out.println();
		}	
		
		// 역삼각형 만드는 작업
		for(int row = max-2; row>=1; row-=2) {  // row = 7, 5, 3 ,1
			//공백
			for(int space = 1; space<=(max-row)/2; space++) {
				System.out.print(" ");
			}
			//문자
			for(int col = 1; col<=row; col++) {
				System.out.print(txt++);
				if(txt>'Z') txt='A';
			}
			//줄바꿈
			System.out.println();
		
		}
		
		
		
		
		
		
	}
	public static void main(String[] args) {
		new Diamond().start();

	}

}
