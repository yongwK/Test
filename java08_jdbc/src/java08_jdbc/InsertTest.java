package java08_jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertTest {

	
	
	public InsertTest() {
	
		try {
			// 1. jdbc 드라이브 로딩 --> jdbc를 jvm이 사용할수 있게 해주는것
			//class class -- forName(String classname) -->  class<>      문자열을 클래스로 만들어준다
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Database 연결
			//java.sql   package
			// DriveManager  
			// 오라클데이터 베이스의 경우 jdbc:oracle:thin:@ 쓰고 다음에 주소를 쓴다. //localhost (자기 컴퓨터인경우) // 다른컴퓨터의경우 ip써도됨 // 쓰고 : 쓴다음 1521 사용 // 쓰고 : xe
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
			String userid = "c##scott";
			String userpwd = "tiger";
			Connection conn = DriverManager.getConnection(url, userid, userpwd);
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			do {
				
				System.out.println("이름");
				String username = br.readLine();
				System.out.println("연락처=");
				String tel = br.readLine();
				System.out.println("이메일");
				String email = br.readLine();
				System.out.println("주소");
				String addr = br.readLine();
				
				// 3. preparedStatement를 생성
				// 한줄이 넘어갈경우 마지막글자랑 첫글자를 한칸 띄워줘라
				String sql = "insert into member(num,username,tel,email,addr,writedate) "
						+ " values(memsq.nextval, ?,?,?,?,sysdate)"; 
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				// ? 에 값을 셋팅
				pstmt.setString(1, username);
				pstmt.setString(2, tel);
				pstmt.setString(3, email);
				pstmt.setString(4, addr);
				
				//4. 실행
				// [select]executeQuery --> ResultSet , [insert, update, delete]excuteUpdate() --> int ->1 개 레코드 작업성공시 ->0 실패[insert] [update -> 성공갯수 리턴된]
				int result = pstmt.executeUpdate();
				if(result>0) {
					System.out.println("회원등록되었습니다.");
				}else {
					System.out.println("회원등록 실패하였습니다.");
				}

			}while(true);
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new InsertTest();

	}

}
