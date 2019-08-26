package test;

import java.sql.CallableStatement;
import java.sql.Connection;

import util.JDBCUtil;

public class Test10_procedure {
	public static void main(String[] args) {
		//execute InsertBook(1,'java ~~~','한빛',27000);
		
		String sql = "{call InsertBook(?,?,?,?) }";
		Connection con = null;
		CallableStatement ps = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareCall(sql);
			
			//? 세팅
			ps.setInt(1,1);
			ps.setString(2, "자바");
			ps.setString(3, "홍길동");
			ps.setString(4, "33000");
			
			//실행및 결과값 핸들링
			ps.execute();
			System.out.println(" call InsertBook 수행");
//			rs = ps.executeQuery();
//			ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
	}
}
