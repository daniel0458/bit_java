package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test01 {
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.OracleDriver";
		String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user ="SCOTT";	//madang hr
		String pw="TIGER";		//madang hr
		
		String sql ="select * from emp";
		
		System.out.println("************ JDBC TEST *************");
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	//select 결과값
		int result = 0;			//dml의 결과값
		
		
		try {
			//1. JDBC driver 설치 : ojdbc6.jar classpath에 추가	-ojdbc6.jar가 JDBC driver다
			//2. 드라이버 로딩
			Class.forName(driver);
			//3. DB로 연결
			con = DriverManager.getConnection(url, user, pw);
			//4. SQL 구문을 관리헤 주는 관리 객체
			st = con.createStatement();
			//5. sql 실행
			rs = st.executeQuery(sql);
			//System.out.println(rs.getMetaData().getColumnCount());

			//6. 결과값 핸들링
			while (rs.next()) {
//				System.out.print(rs.getString("deptno") + "\t");
//				System.out.print(rs.getString("dname") + "\t");
//				System.out.print(rs.getString("loc") + "\n");
				System.out.print(rs.getString("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getString("mgr") + "\t");
				System.out.print(rs.getDate("hiredate") + "\t");
				System.out.print(rs.getString("sal") + "\t");
				System.out.print(rs.getString("comm") + "\t");
				System.out.print(rs.getString("deptno") + "\n");
			}
				
				
				
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 확인 필요");
		} catch (Exception e){
			System.out.println(e.getMessage());
		} finally {
			//7. 자원 반납
			try {
				if(rs != null) rs.close();
				if(st != null) st.close();
				if(con != null) con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		System.out.println("************** END ***************");
	}
}
