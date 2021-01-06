package apiClass;

public class StringTest {

	public StringTest() {
		//             012345678910
		String data = "서울시 마포구 백범로";
		String data2 = new String("서울시 마포구 백범로");
		
		if ( data == data2) { // if는 주소를 비교하므로 다르다가 출력되고
			System.out.println(data + "과" + data2 + "는 같다");
		}else {
			System.out.println(data + "과" + data2 + "는 다르다");
		}
		// equals는 데이터를 비교하므로 같다가 출력된다
		if(data.equals(data2)) {// data2.equals(data); 
			System.out.println("data와 data2는 같다.");
		}else {
			System.out.println("data와 data2는 다르다.");
		}
		
		char c = 'A';
		c++;
		c = (char)(c + 1);  // typecasting  c는 char형 1은 int형이므로 바꿔줘야한다.
		System.out.println("c = " + c);
		c = (char)(c + 3);
		System.out.println("c = " + c);
		
		
		// byte = -128 ~ +127
		byte b =(byte)130;
		System.out.println("b = " + b);
		
		
		// charAt() : index 위치의 문자 변환
		char result1 = data.charAt(5);
		System.out.println("result1 = " + result1);
		// concat() : 문자열의 연결
		String data3 = "JAVA OOP Programing....";
		String data4 = "java oop programing....";
		
		String result2 = data.concat(data3);
		System.out.println("concat() = " + result2);
		
		//equls()
		boolean boo1 = data3.equals(data4);
		System.out.println("equals() = " + boo1);
		//equalsIgnoreCase 대소문자 구별안하고 비교하겠다.
		boolean boo2 = data3.equalsIgnoreCase(data4);
		System.out.println("equals() = " + boo2);
		
		
		//getBytes() : 문자열을 byte로 반환한다.
		byte result3[] = data3.getBytes();
		for( byte by : result3 ) {
			System.out.println(by + " --> " + (char)by);
		}
		
		//indexOf() : 특정 문자의 위치 index를 구한다. 값이 존재하지 않을경우 : -1 
		int result4 = data3.indexOf("OOP",10);
		System.out.println("indexOf() = " + result4);
		
		//length()
		int result5 = data3.length();
		System.out.println("length() = " + result5);
		
		//replaceAll() : 특정위치의 문자열 변경
		String result6 = data3.replaceAll("OOP", "객체");
		System.out.println("replaceAll() = " + result6);
		
		//split() : 특정문자로 문자열 조각내기
		String tel = "010--1234---5678";
		String[] result7 = tel.split("-");
		for(int i = 0; i<result7.length;i++) {
			System.out.println("tel[" + i + "] = " + result7[i]);
		}
		
		//문자열의 일부 구하기 substring()
		String result8 = data3.substring(5); // index 5부터 끝까지의 문자열 구한다.
		System.out.println("substring() = " + result8);
		String result9 = data3.substring(5, 10); // index 5부터 index 10 앞까지 문자열 구한다.
		System.out.println("substring() = " + result9);
		
		//대소문자 변환
		System.out.println("toLowerCase = " + data3.toLowerCase());
		System.out.println("toUpperCase = " + data3.toUpperCase());
	
		//문자열의 크기 비교
		String str1 = "홍길동"; // 홍-이     숫자<영어<한글
		String str2 = "이순신";
		int result10 = str1.compareTo(str2);
		// 0 : 같다,  양수 : 왼쪽 객체가 크다, 음수 : 왼쪽객체가 작다.
		System.out.println("compareTo = " + result10);
		
	
		//trim
		String str3 = "             Java Programing         ";
		System.out.println("str3 = " + str3.trim());
	
	
		//기본데이터타입 + char배열을 문자열로 변환하는 메소드
		int num = 1234;
		String numTxt = String.valueOf(num);
		System.out.println(numTxt+100);
	
		String num2 = "5678";
		
		Integer num2Int = Integer.valueOf(num2);//Integer,           Int
		// 오토박싱 : 기본데이터형이 객체형으로 대입
		// 오토언박싱 : 객체형데이터가 기본데이터형으로 대입을 자동으로 하는 것
		Integer numInt = 1234;
		int num3 = Integer.valueOf(9999);
		
		
	}

	public static void main(String[] args) {
		new StringTest();

	}

}
