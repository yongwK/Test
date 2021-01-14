package mem;

import java.util.HashMap;



public class MemDB {
	public static HashMap<String, MemVo> memList = new HashMap<String, MemVo>();
	
	public MemDB() {
	
	}

	public static void setMemList() {
		memList.put("홍길동", new MemVo(1, "홍길동", "010-1111-1111", "서울특별시", "AAA","1234","0", "0", "0"));
		memList.put("강감찬", new MemVo(2, "강감찬", "011-524-2356", "인천광역시","BBB","1234","0", "0", "0"));
		memList.put("유승룡", new MemVo(3, "유승룡", "063-334-2212", "수원시","CCC","1234","0", "0", "0"));
		memList.put("이순신", new MemVo(4, "이순신", "053-6936-1234", "평택시","DDD","1234","0", "0", "0"));
		memList.put("장영실", new MemVo(5, "장영실", "018-9632-5236", "천안시","EEE","1234","0", "0", "0"));
	}
}
