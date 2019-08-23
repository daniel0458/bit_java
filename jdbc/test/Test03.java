package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.JDBCUtil;

public class Test03 {
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int deptno = 10;
		if (args.length != 0) {
			deptno = Integer.parseInt(args[0]);
		}
//		String sql ="select * from emp";
		String sql ="select * from emp where deptno = " + deptno;
		
		System.out.println("************ JDBC TEST *************");
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;	//select 결과값
		int result = 0;			//dml의 결과값
		
		
		try {
			//1. JDBC driver 설치 : ojdbc6.jar classpath에 추가	-ojdbc6.jar가 JDBC driver다
			//2. 드라이버 로딩
			
			//3. DB로 연결
			con = JDBCUtil.getConnection();
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
		} catch (Exception e){
			System.out.println(e.getMessage());
		} finally {
			//7. 자원 반납
			JDBCUtil.close(con, st, rs);
		}
		

		System.out.println("************** END ***************");
	}
}
