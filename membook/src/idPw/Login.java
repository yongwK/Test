package idPw;

import java.util.Iterator;
import java.util.Set;

import mem.MemDB;
import mem.MemVo;

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
				System.out.println("로그인 실패");
				return false;
			}
		}
	}

	public static boolean loginCheck() {
	      boolean sw = false;
	      if(id == "" || pwd == "") {
	         System.out.println("아이디와 비밀번호를 입력해주세요");
	         return sw;
	      }
	      
	      else { //@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	         Set<String> keySet = MemDB.memList.keySet();
	         Iterator<String> i = keySet.iterator();
	         while(i.hasNext()) { //AAAAAAAAAAAAAAAAAAAAAAAAAAA
	            String key = (String)i.next();
	            MemVo vo = MemDB.memList.get(key);
	            if(vo.getId().equals(id) && vo.getPwd().equals(pwd)) {
	               sw = true;
	               break;
	            }
	            else {
	               sw =false;
	            }   
	         } //AAAAAAAAAAAAAAAAAAAAA
	      
	      return sw;   
	         
	      } //@@@@@@@@@@@@@@@@@@@
	}
}		
			

	
	

/*
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
 */
