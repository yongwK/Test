package idPw;

import java.util.Iterator;
import java.util.Set;

public class Login {
	public static String id;
	public static String pwd;

	public Login() {

	}
	
	public static boolean adLoginCheck() {
		if(id == "" || pwd == "") {
			System.out.println("아이디와 비밀번호를 입력해주세요");
			return false;
		}
		else {
			if(id.equals("master") && pwd.equals("1234")) {
				return true;
			}
			else {
				return false;
			}
		}
	}

}
