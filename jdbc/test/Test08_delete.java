package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCUtil;

public class Test08_delete {
	public static void main(String[] args) {
		Emp8 emp = new Emp8();
		int count = emp.deleteEmp(9999);
//		System.out.println(count);
		System.out.println(count==1 ? "9999 삭제완료" : "삭제 데이터 없음");
	}
}

class Emp8 {
	
	public int deleteEmp(int empno) {	//pk,fk때문에 전략세우고 지워야함
		String sql = "delete from emp where empno=?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//? 세팅
			ps.setInt(1, empno);
			
			//실행및 결과값 핸들링
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
}