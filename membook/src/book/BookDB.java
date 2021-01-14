package book;

import java.util.HashMap;


public class BookDB {
	public static HashMap<String, BookVo> bookList = new HashMap<String, BookVo>();
	
	public BookDB() {
		
	}

	public static void setBookList() {
		bookList.put("총,균,쇠", new BookVo("1", "총,균,쇠", "재레드 다이아몬드", "문학사상\t", "O"));
		bookList.put("사피엔스", new BookVo("2", "사피엔스", "유발 하라리", "\t김영사\t", "O"));
		bookList.put("자바의정석", new BookVo("3", "자바의정석", "남궁성", "\t도우출판\t", "O"));
		bookList.put("수학의정석", new BookVo("4", "수학의정석", "홍성대", "\t성지출판\t", "O"));
		bookList.put("부자의공식", new BookVo("5", "부자의공식", "이정윤", "\t베가북스\t", "O"));
		bookList.put("행복의나락", new BookVo("6", "행복의나락", "F. 스콧 피츠제럴드", "녹색광선\t", "O"));
		bookList.put("광고의 8원칙", new BookVo("7", "광고의 8원칙", "오두환", "대한출판사\t", "O"));

	}
}
	