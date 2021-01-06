import java.util.Scanner;

public class EmailCheck {

	Scanner sc = new Scanner(System.in);
	
	
	
	public EmailCheck() {
		do {
			//이메일 입력
			System.out.println("이메일 입력=");
			String email = sc.nextLine();
			// @ : at mark
			int atmark = email.indexOf("@");
			//. 위치 구하기
			int point = email.indexOf(".");
			
			int pointcount = 0; // .의갯수가 카운트
			for( int i = 0; i<email.length(); i++) { // i = 0,1,2,3,4
				if(email.charAt(i) == '.') {
				 pointcount++;	
				}
			}
			
			if(atmark == -1 || point == -1 || atmark > point || (point-atmark) < 3 || pointcount > 2) {// 잘못된 이메일 주소 
				System.out.println(email + "주소는 잘못된 이메일 주소입니다....");	
				
			}else { // 종상 이메일 주소
				// goguma@nate.com   : split, StringTokenizer
				String[] emailresult = email.split("@");
				String id = email.substring(0, atmark);
				String domain = email.substring(atmark+1);
				
				System.out.println("아이디 = " + emailresult[0]);
				System.out.println("도메인 = " + domain);
			}
			
		}while(true);
		
		
		
		
	}

	public static void main(String[] args) {
		new EmailCheck();
		
		
		

	}

}
