package book;

import java.util.HashMap;


public class BookDB {
	public static HashMap<String, BookVo> bookList = new HashMap<String, BookVo>();
	
	public BookDB() {
		
	}

	public static void setBookList() {
		bookList.put("총,균,쇠", new BookVo(1, "총,균,쇠\t\t", "재레드 다이아몬드\t", "문학사상\t\t", "가능"));
		bookList.put("사피엔스", new BookVo(2, "사피엔스\t\t", "유발 하라리\t", "김영사\t\t", "가능"));
		bookList.put("자바의정석", new BookVo(3, "자바의정석\t\t", "남궁성\t\t", "도우출판\t\t", "가능"));
		bookList.put("수학의정석", new BookVo(4, "수학의정석\t\t", "홍성대\t\t", "성지출판\t\t", "가능"));
		bookList.put("부자의공식", new BookVo(5, "부자의공식\t\t", "이정윤\t\t", "베가북스\t\t", "가능"));
		bookList.put("행복의나락", new BookVo(5, "행복의나락\t\t", "F. 스콧 피츠제럴드\t", "녹색광선\t\t", "가능"));
		bookList.put("광고의 8원칙", new BookVo(5, "광고의 8원칙\t", "오두환\t\t", "대한출판사\t\t", "가능"));

	}
}
	