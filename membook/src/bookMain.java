import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import idPw.Login;


public class bookMain {
	Scanner sc = new Scanner(System.in);

	int choice;
	public bookMain() {

		
		while(true) {
			choice = Integer.parseInt(Input("1. 관리자 로그인 2. 회원로그인"));
			
			if(choice == 1 ) {
				Login.id = Input(" 아이디 ");
				Login.pwd = Input(" 비밀번호");
				if(Login.adLoginCheck()) {
					

				}
			}else {
				
			}
			
			
		}
		
		
		
		
		
		
		
		
	}

	
	
	

	
	public String Input(String msg) {
		System.out.print(msg + ":");
		return sc.nextLine();
	}
	
	public static void main(String[] args) {
		new bookMain();

	}

}
