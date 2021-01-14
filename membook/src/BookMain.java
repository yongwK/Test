import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	Calendar now = Calendar.getInstance();
	int choice, choice2, choice3, choice4;
	public BookMain() {	

	}//public BookMain()
	
	public void start() {
		//초기데이터세팅
		MemDB.setMemList();
		BookDB.setBookList();
		while(true) {
			try {
				while(true) {///11111111
					
					choice = Integer.parseInt(input("[1.관리자로그인 2.회원로그인 3. 프로그램 종료]"));
					if(choice == 1) {//22222222222
						Login.id = input("아이디");
						Login.pwd = input("비밀번호");
						
						if(Login.adLoginCheck()) {//3333333333
							
							System.out.println("로그인성공");
							
							
							while(true) {//44444444444
								
								try {
									choice2 = Integer.parseInt(input("1.전체회원목록 2.회원삭제 3.전체 도서목록  4. 도서추가 5. 도서 대출 현황  6. 관리자 로그아웃" ));
									
									if(choice2 == 1) { memOutPut();}
									else if(choice2 ==2) { memDel(); memOutPut();}
									else if(choice2 ==3) { bookOutPut(); }
									else if(choice2 ==4) { addBook(); }
									else if(choice2 ==5) { leanView();}
									else if(choice2 ==6) { break; } // 관리자로그아웃 000000000000
									else { System.out.println("1 or 2 or 3 or 4 or 5 or 6 번중에 선택해주세요"); }
								}catch(NumberFormatException nfe) {	System.out.println("숫자를 입력해주세요"); }
							
							
							}//4444444	
							
							
							//break;     // 관리자 로그아웃0000000000000
						}//333333333	
					}//2222222222 <choice ==1 일떄 관리자 로그인시 끝>
					
					
					else if(choice ==2) { //2222222222-else if
						
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
												try {
													choice4 = Integer.parseInt(input("1.도서목록     2.도서검색     3.도서대출     4.도서반납  5.도서 대출확인  6.회원 로그아웃"));
													if(choice4 == 1) { bookOutPut(); }
													else if(choice4 ==2) { bookSearch(); }
													else if(choice4 ==3) { bookLean();	}
													else if(choice4 ==4) { bookReturn(); }
													else if(choice4 ==5) { leanView(); }	
													else if(choice4 ==6) { break; }	
													else { System.out.println("1 or 2 or 3 or 4 or 5 or 6 중에 선택해 주세요");}
												}catch(NumberFormatException nfe) {
													System.out.println("숫자를 입력해 주세요");
												}
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
				System.out.println("1 or 2 or 3번 선택해주세요");
			}
		}
		
		
	}
	//도서 대출 현황
	public void leanView() {
		boolean sw = true;
		Set<String> key = MemDB.memList.keySet();
		Iterator<String> i = key.iterator();
		System.out.println();
		while(i.hasNext()) {
			MemVo mVo = MemDB.memList.get(i.next());
			if(mVo.getLeanbookName() == null) {
				sw = false;
			}
			else {
				System.out.printf("%s\t\t%s\t\t%s\t\t%s\n",mVo.getMemName(),mVo.getLeanbookName(),
						mVo.getBorrowDate(), mVo.getDueDate());
			}
		}
		if(sw = false) {
			System.out.println("대출된 도서가 없습니다.");
		}
	}
	
	
	
	//도서 반납
	public void bookReturn() {
		String mName = input("회원명을 입력하세요");
		MemVo mVo = MemDB.memList.get(mName);
		if(mVo ==null) {
			System.out.println("존재하지 않는 회원명입니다.");
		}
		else {
			String returnBookName = input("반납할 도서를 입력하세요");
			BookVo bVo = BookDB.bookList.get(returnBookName);
			if(bVo ==null) {
				System.out.println("저희 도서관 책이 아닙니다.");
			}
			else if(mVo.getLeanbookName().equals(bVo)) {
				bVo.setbAble("O");
				mVo.setBorrowDate("0");
				mVo.setDueDate("0");
				mVo.setLeanbookName("0");
				System.out.println("반납이 완료 되었습니다.");
			}
			else { System.out.println("반납에 실패했습니다.");			}
		}
	}
	
	//도서 대출
	public void bookLean() {
		String day = sdf.format(now.getTime());
		String bName = input("대출할 도서명을 쓰세요");
		BookVo bVo = BookDB.bookList.get(bName);
		
			if(bVo==null) { // 도서가 존재하지 않을때
				System.out.println("존재하지 않는 도서명입니다");
				
			}
			else if(bVo.getbAble().equals("X")) {
				System.out.println("이미 대출된 도서입니다.");
				
			}
			else {
					int bookBrw = Integer.parseInt(input("도서를 대출하시겠습니까([Y=1 , N= 1을 제외한 다른키를 눌러주세요)?"));
						
						if(bookBrw == 1) {				
							String name = input("회원명을 입력하세요");
							MemVo mVo = MemDB.memList.get(name);
							if(mVo==null) {
								System.out.println("존재하지 않는 회원명입니다.");
							}
							else {
								mVo.setLeanbookName(bName);
								mVo.setBorrowDate(day);
								now.add(Calendar.DAY_OF_MONTH, 14);
								day = sdf.format(now.getTime());
								mVo.setDueDate(day);
								bVo.setbAble("X");
								System.out.println("대출이 완료되었습니다.");
							}
						}
						
						else {
							System.out.println("도서 대출을 종료합니다");
						}
			
						
			}
		
			
		
		
	}
	
	
	//도서 검색
	public void bookSearch() {
		String search = input("검색할 도서명");
		// 키목록 구하기
		Set<String> keySet = BookDB.bookList.keySet();
		Iterator<String> i = keySet.iterator();
		while(i.hasNext()) {
			String key = (String)i.next();
			BookVo vo = BookDB.bookList.get(key);
			if(vo.getbName().indexOf(search)>=0) {
				System.out.println(vo.getbName() + vo.getbAble());
			}
		}
		
	}
	
	
	//도서추가
	public void addBook() { ////addbook
		Set<String> keyNum = BookDB.bookList.keySet();
		Iterator<String> ii = keyNum.iterator();
		boolean sw = true;
			
		String bNo = input("도서번호");
		String bName = input("도서명");
		String bAuthor = input("작가");
		String bPublisher = input("출판사");
		
		while(ii.hasNext()) { ////iiiiiiii
			BookVo bNoKey = BookDB.bookList.get(ii.next());
			if(bNo.equals(bNoKey.getbNo())) {
				System.out.println("등록번호가 중복됩니다.");
				sw = false;
			}
		}//iiiiiiiiiiii
		if(sw == true) {
			BookDB.bookList.put(bNo, new BookVo(bNo, bName, bAuthor+"\t", bPublisher+"\t", "O"));
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
			MemDB.memList.put(memName, new MemVo(memNO, memName, tel, addr, id, pwd, "0", "0", "0"));
		}
	}
	
	//회원삭제
	public void memDel() {
		String memName = input("삭제할 회원이름");
		MemDB.memList.remove(memName);
	}
	//책목록 출력
	public void bookOutPut() {
		Set<String> keyLst = BookDB.bookList.keySet();
		Iterator<String> ii = keyLst.iterator();
		System.out.println("도서번호\t\t도서명\t\t\t\t작가\t\t\t\t\t출판사\t\t\t대출가능여부[O,X]");
		while(ii.hasNext()) {
			BookVo vo = BookDB.bookList.get(ii.next());
			vo.bookPrt();
		}
	}
	//회원목록 출력
	public void memOutPut() {
		Set<String> keyList = MemDB.memList.keySet();
		Iterator<String> ii = keyList.iterator();
		System.out.println("회원번호\t\t이름\t\t\t전화번호\t\t\t주소\t\t아이디\t\t비밀번호\t\t대출도서명\t\t대출일\t\t반납일");
		while(ii.hasNext()) {
			MemVo mVo = MemDB.memList.get(ii.next());
			System.out.printf("%d\t\t%s\t\t%s\t\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n",mVo.getMemNO(),mVo.getMemName(),
					mVo.getTel(),mVo.getAddr(),mVo.getId(),mVo.getPwd(),mVo.getLeanbookName(),
					mVo.getBorrowDate(),mVo.getDueDate());
		}
	}
	
	// 콘솔입력
	public String input(String msg) {
		System.out.print(msg + ":");
		return sc.nextLine();
	}
	
	public static void main(String[] args) {
		new BookMain().start();

	}

}