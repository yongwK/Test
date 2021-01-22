import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("드라이브 로딩 에러 발생");
		}
	}
	Connection conn=null;
	PreparedStatement pstmt=null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username="c##scott";
	String userpwd="tiger";
	
	public SelectTest() {
		
	}
	public void recordSelect() {
		try {
			conn=DriverManager.getConnection(url,username, userpwd);
			
			// 쿼리문을 문자열로 만들기
			String sql="select num, username, tel, email, writedate, addr from member "
					+ " order by num asc";
			
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery(); // executeQuery의 반환 값은 ResultSet임
			
			// rs 객체에서 point 이동하여 레코드의 정보를 얻어온다
			while(rs.next()) {
				int num=rs.getInt(1); // rs.getInt("num");으로 해도 된다
				String username=rs.getString(2); // rs.getString("username");
				String tel=rs.getString(3);
				String email=rs.getString(4);
				String writedate=rs.getString(6);
				String addr=rs.getString(5);
				System.out.printf("%d, %s, %s, %s, %s, %s\n",num, username, tel, email, writedate, addr);
				
			}
		}catch(Exception e) {
			
		}
	}
	public static void main(String[] args) {
		new SelectTest().recordSelect();;
	}

}
