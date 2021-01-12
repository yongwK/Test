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
			if(id.equals("1") && pwd.equals("1")) {
				return true;
			}
			else {
				System.out.println("로그인 실패");
				return false;
			}
		}
	}

	public static boolean loginCheck() {
		if(id == "" || pwd == "") {
			System.out.println("아이디와 비밀번호를 입력해주세요");
			return false;
		}else {
			
			String pwds = IdpwDB.idpwLst.get(id);
			if(pwds != null && pwd.equals(pwds)) {
				return true;
			}else {
				return false;
			}
	
		}
			
	}
	
	
}
