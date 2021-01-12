import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import book.BookDB;
import book.BookVo;
import idPw.Login;
import mem.MemDB;
import mem.MemVo;


public class BookMain {
	Scanner sc = new Scanner(System.in);

	int choice, choice2;
	public BookMain() {	

	}//public BookMain()
	
	public void start() {
		
		while(true) {
			choice = Integer.parseInt(Input("[1.관리자로그인 2.회원로그인]"));
			if(choice == 1) {
				Login.id = Input("아이디");
				Login.pwd = Input("비밀번호");
				
				if(Login.adLoginCheck()) {
					System.out.println("로그인성공");
					//초기데이터세팅
					MemDB.setMemList();
					BookDB.setBookList();
					
					choice2 = Integer.parseInt(Input("1.전체회원목록 2.회원삭제 3.책목록  4. 도서추가" ));
					
					if(choice2 == 1) { memOutPut();}
					else if(choice2 ==2) { memDel(); memOutPut();}
					else if(choice2 ==3) { bookOutPUt(); }
					//else if(choice ==4) { addBook(); }
					
					
					
				}//(Login.adLoginCheck())
			}//(choice == 1)
		}//while(true) {
	}
	//도서추가
	
	
	//회원삭제
	public void memDel() {
		String memName = Input("삭제할 회원명");
		MemDB.memList.remove(memName);
	}
	//책목록 출력
	public void bookOutPUt() {
		Set<String> keyLst = BookDB.bookList.keySet();
		Iterator<String> ii = keyLst.iterator();
		while(ii.hasNext()) {
			BookVo vo = BookDB.bookList.get(ii.next());
			vo.bookPrt();
		}
	}
	//회원목록 출력
	public void memOutPut() {
		Set<String> keyList = MemDB.memList.keySet();
		Iterator<String> ii = keyList.iterator();
		while(ii.hasNext()) {
			MemVo vo = MemDB.memList.get(ii.next());
			vo.memPrt();
		}
	}
	
	
	public String Input(String msg) {
		System.out.print(msg + ":");
		return sc.nextLine();
	}
	
	public static void main(String[] args) {
		new BookMain().start();

	}

}
