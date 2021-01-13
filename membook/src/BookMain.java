import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

import book.BookDB;
import book.BookVo;
import idPw.Login;
import mem.MemDB;
import mem.MemVo;


public class BookMain {
	Scanner sc = new Scanner(System.in);

	int choice, choice2, choice3;
	public BookMain() {	

	}//public BookMain()
	
	public void start() {
		
		while(true) {///11111111
			choice = Integer.parseInt(input("[1.관리자로그인 2.회원로그인]"));
			if(choice == 1) {//22222222222
				Login.id = input("아이디");
				Login.pwd = input("비밀번호");
				
				if(Login.adLoginCheck()) {//3333333333
					
					System.out.println("로그인성공");
					//초기데이터세팅
					MemDB.setMemList();
					BookDB.setBookList();
					
					while(true) {//44444444444
				
						choice2 = Integer.parseInt(input("1.전체회원목록 2.회원삭제 3.전체 도서목록  4. 도서추가 5. 로그아웃" ));
						
						if(choice2 == 1) { memOutPut();}
						else if(choice2 ==2) { memDel(); memOutPut();}
						else if(choice2 ==3) { bookOutPUt(); }
						else if(choice2 ==4) { addBook(); }
						else if(choice2 ==5) { break; } // 관리자로그아웃 000000000000
					
					
					}//4444444	
					break;     // 관리자 로그아웃0000000000000
				}//333333333	
			}//2222222222
			
			
			else if(choice ==2) { //2222222222-else
				choice3 = Integer.parseInt(input("1. 회원등록\t 2.회원로그인\t 3.도서목록\t 4.도서검색\t 5.도서대출\t	6.도서반납\t"));
				while(true) { //AAAAAAAAAAAAAAAAAAAAAAAA
					
					if(choice3 == 1) {//BBBBBBBBBBBBB
						
					}//BBBBBBBBBBBBBB
					else if(choice3 ==2) {
						
					}
					
				}//AAAAAAAAAAAAAAAAAAAAAAAA
				
				
				
			}//2222222222-else
			
			
			
			
			
			
			
		}//1111111111111
	}
	//도서추가
	public void addBook() { ////addbook
		Set<String> keyNum = BookDB.bookList.keySet();
		Iterator<String> ii = keyNum.iterator();
		
		try {
			int bNo = Integer.parseInt(input("도서번호"));
			String bName = input("도서명");
			String bAuthor = input("작가");
			String bPublisher = input("출판사");
			String bAble = input("대출가능여부[가능or불가능]");
			while(ii.hasNext()) { ////iiiiiiii
				BookVo bNoKey = BookDB.bookList.get(ii.next());
				if(bNoKey.getbAuthor()==bName) {
					System.out.println("도서명이 중복됩니다.");
					break;
				}
				if(bNoKey.getbNo()==bNo) {
					System.out.println("도서번호가 중복됩니다.");
					break;
				}
			}//iiiiiiiiiiii
			BookDB.bookList.put(bName, new BookVo(bNo, bName, bAuthor, bPublisher, bAble));	
		}
		catch(NumberFormatException e) {
			System.out.println("도서번호는 숫자(번호)를 입력하셔야 합니다.");
		}
		
		
		
	}////////addbook
	
	//회원추가
	
	
	//회원삭제
	public void memDel() {
		String memName = input("삭제할 회원명");
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
	
	
	public String input(String msg) {
		System.out.print(msg + ":");
		return sc.nextLine();
	}
	
	public static void main(String[] args) {
		new BookMain().start();

	}

}
