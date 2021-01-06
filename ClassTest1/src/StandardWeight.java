import java.util.Scanner;

public class StandardWeight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("나이 = ");
		double age = sc.nextInt();
		
		System.out.print("성별(1:남성,2:여성)=");
		double gender = sc.nextInt();
		
		System.out.print("키 = ");
		double height = sc.nextInt();
		
		System.out.print("현재체중 = ");
		double now_W = sc.nextInt();
		
		
		//표준체중 구하기
		double std_W = 0; 
		if( age <= 35) {
			
			if(gender == 1) {
				std_W = (height - 100)*0.90;
			}
			else if(gender == 2) {
				std_W = (height - 100)*0.85;
			}
		}
		
		else if( age >= 36) {
			if(gender == 1) {
				std_W = (height - 100)*0.95;
			}
			else if(gender == 2){
				std_W = (height - 100)*0.90;
			}	
		}
		
		
		// 표준체중지수값	
		double std_W_N =(now_W/std_W)*100;
		
		// 포준체중지수 비교
		int msg = 0;
		if(std_W_N>=126) {
			msg = 1;
		}
		else if(std_W_N >= 116 && std_W_N <= 125) {
			msg = 2;
		}
		else if(std_W_N >= 96 && std_W_N <= 115) {
			msg = 3;
		}
		else if(std_W_N >= 86 && std_W_N <= 95) {
			msg = 4;
		}
		else if(std_W_N <= 85) {
			msg = 5;
		}
		// 스위치
		String result = "";
		switch(msg) {
		case 1:
			result = "비만형";
			break;
		case 2:
			result = "조금 비만형";
			break;
		case 3:
			result = "표준형";
			break;
		case 4:
			result = "조금마른형";
			break;
		case 5:
			result = "마른형";
		}
		
		
		System.out.println("표준체중 = " + std_W);
		System.out.printf("당신의 표준체중지수는 %f으로 %s입니다",std_W_N,result);
		
		
		
		
		
		
		
	}

}
