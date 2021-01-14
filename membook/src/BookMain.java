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

	int choice, choice2, choice3, choice4;
	public BookMain() {	

	}//public BookMain()
	
	public void start() {
		
		while(true) {
			try {
				while(true) {///11111111
					//초기데이터세팅
					MemDB.setMemList();
					BookDB.setBookList();
					choice = Integer.parseInt(input("[1.관리자로그인 2.회원로그인 3. 프로그램 종료]"));
					if(choice == 1) {//22222222222
						Login.id = input("아이디");
						Login.pwd = input("비밀번호");
						
						if(Login.adLoginCheck()) {//3333333333
							
							System.out.println("로그인성공");
							
							
							while(true) {//44444444444
						
								choice2 = Integer.parseInt(input("1.전체회원목록 2.회원삭제 3.전체 도서목록  4. 도서추가 5. 관리자 로그아웃" ));
								
								if(choice2 == 1) { memOutPut();}
								else if(choice2 ==2) { memDel(); memOutPut();}
								else if(choice2 ==3) { bookOutPut(); }
								else if(choice2 ==4) { addBook(); }
								else if(choice2 ==5) { break; } // 관리자로그아웃 000000000000
							
							
							}//4444444	
							//break;     // 관리자 로그아웃0000000000000
						}//333333333	
					}//2222222222 <choice ==1 일떄 관리자 로그인시 끝>
					
					
					else if(choice ==2) { //2222222222-else
						
						while(true) {
							
							try {
								while(true) {//AAAAAAAAAAAAAAAAAAAAAAAA
									choice3 = Integer.parseInt(input("1. 회원등록\t 2.회원로그인\t 3.종료"));
								
									
									if(choice3 == 1) {// <choice 3 ======1 일때 , 회원등록 >
										memAdd(); 
									}// <choice 3 ======1 일때 , 회원등록 > 끝
									
									
									else if(choice3 ==2) {// <choice 3 ======2 일때 , 로그인>
										Login.id = input("아이디");
										Login.pwd = input("비밀번호");
										
										if(Login.loginCheck()) { //!!!!!!!!!!!!!!!!!!
											
											while(true)
											{ //@@@@@@@@@@@@@@@@@@@@@@@@@!!!!!!!!!!!!!!!!!!
												choice4 = Integer.parseInt(input("1.도서목록     2.도서검색     3.도서대출     4.도서반납     5.회원 로그아웃"));
												if(choice4 == 1) { bookOutPut(); }
												else if(choice4 ==2) { bookSearch(); }
												else if(choice4 ==3) {	}
												else if(choice4 ==4) {	}
												else if(choice4 ==5) { break; }		
											} //@@@@@@@@@@@@@@@@@@@@@@@@@!!!!!!!!!!!!!!!!!!
										}//!!!!!!!!!!!!!!!!!!
										else {
											System.out.println("로그인 실패");
										}

									}// <choice 3 ======2 일때 , 로그인> 끝
									
									else if(choice3 ==3) {
										break;
									}
									
									else {
										System.out.println("1 or 2 or 3 중에 골라주세요");
									}
									
									
									
									
									
										
								}//AAAAAAAAAAAAAAAAAAAAAAAA
							break;
							}catch(NumberFormatException nfe){
								System.out.println("숫자를 입력하세요");
							}
							
						}
						
						
										
						
					}//2222222222-else <choice ==2 일떄 과정   회원로그인시>
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					else if(choice == 3) { //<choice == 3 일떄 과정  프로그램 종료>
						break;
					}
					
					
					
					else { //<choice == 4 일떄 과정  선택 확인>
						throw new Exception("1 or 2 or 3 중에 골라주세요");
					}
			
					
				}//1111111111111
				System.out.println("프로그램을 종료합니다");
				break;		
				
						
			}catch(NumberFormatException nfe) {
				System.out.println("숫자를 입력해 주세요");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}
	//도서 검색
	public void bookSearch() {
		String search = input("검색할 도서명");
		// 키목록 구하기
		Set<String> keySet = BookDB.bookList.keySet();
		Iterator i = keySet.iterator();
		while(i.hasNext()) {
			String key = (String)i.next();
			BookVo vo = BookDB.bookList.get(key);
			if(vo.getbName().indexOf(search)>=0) {
				System.out.println(vo.getbName());
			}
		}
		
	}
	
	
	//도서추가
	public void addBook() { ////addbook
		Set<String> keyNum = BookDB.bookList.keySet();
		Iterator<String> ii = keyNum.iterator();
		boolean sw = true;
		try {
			
			String bNo = input("등록번호");
			String bName = input("도서명");
			String bAuthor = input("작가");
			String bPublisher = input("출판사");
			String bAble = input("대출가능여부[O or X]");
			while(ii.hasNext()) { ////iiiiiiii
				BookVo bNoKey = BookDB.bookList.get(ii.next());
				if(bNo.equals(bNoKey.getbNo())) {
					System.out.println("등록번호가 중복됩니다.");
					sw = false;
				}
			}//iiiiiiiiiiii
			if(sw == true) {
				BookDB.bookList.put(bNo, new BookVo(bNo, bName, bAuthor, bPublisher, bAble));
			}
		}
		catch(NumberFormatException e) {
			System.out.println("도서번호는 숫자(번호)를 입력하셔야 합니다.");
		}
		
		
		
	}////////addbook
	
	//회원추가
	public void memAdd() {
		
		boolean sw = true;
		int memNO = Integer.parseInt(input("회원번호"));
		String memName = input("회원이름");
		String tel = input("전화번호");
		String addr = input("주소");
		String id = input("아이디");
		String pwd = input("비밀번호");
		
		Set<String> keySet = MemDB.memList.keySet();
		Iterator<String> i = keySet.iterator();
		
		while(i.hasNext()) {
			String key = (String)i.next();
			MemVo vo = MemDB.memList.get(key);
			if(vo.getId().indexOf(id) != -1) {
				System.out.println("중복된 id입니다.");
				sw = false;
				break;
			}
			if(vo.getMemNO()==memNO) {
				System.out.println("이미 등록된 회원번호 입니다. ");
				sw = false;
				break;
			}
		}
		if(sw = true) {
			MemDB.memList.put(memName, new MemVo(memNO, memName, tel, addr, id, pwd));
		}
	}
	
	//회원삭제
	public void memDel() {
		String memName = input("삭제할 회원명");
		MemDB.memList.remove(memName);
	}
	//책목록 출력
	public void bookOutPut() {
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