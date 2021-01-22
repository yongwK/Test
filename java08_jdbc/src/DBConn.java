import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	// 1. 드라이브 로딩
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("드라이브 로딩 에러 발생"+e.getMessage());
		}
	}
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql=null;
	
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String username="c##scott";
	String userpwd="tiger";
	
	public DBConn() {
		
	}
	// DB 연결
	public void getConn() {
		try {
			conn=DriverManager.getConnection(url, username, userpwd);
		}catch(Exception e) {
			System.out.println("DB 연결 에러 발생"+e.getMessage());
		}
	}
	// DB 접속 종료
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(SQLException se) {
			System.out.println("DB 종료 에러 발생"+se.getMessage());
		}
	}
}
