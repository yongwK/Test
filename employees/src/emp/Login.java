package emp;

public class Login {
	public static String id;
	public static String pwd;
	public Login() {	}

	// 로그인 체크하는 메소드(성공하면 true// 실패하면 false)
	public static boolean loginCheck() {
		if(id == "" || pwd == "") {
			System.out.println("아이디와 비밀번호를 입력 후 로그인 하세요");
			return false;
		}else {
			if(id.equals("master") && pwd.equals("1234")) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	
}
