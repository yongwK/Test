package mem;

import java.util.HashMap;



public class memDB {
	public static HashMap<String, memVo> memList = new HashMap<String, memVo>();
	
	public memDB() {
	
	}

	public static void setMemList() {
		memList.put("홍길동", new memVo(1, "홍길동", "02-1234-1111", "서울특별시"));
		memList.put("강감찬", new memVo(3, "강감찬", "02-5689-9898", "인천광역시"));
		memList.put("유승룡", new memVo(5, "유승룡", "02-2356-8956", "수원시"));
		memList.put("이순신", new memVo(2, "이순신", "02-6936-1234", "평택시"));
		memList.put("장영실", new memVo(4, "장영실", "02-9632-5236", "천안시"));
	}
}
