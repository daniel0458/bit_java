package jdbc_HW;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtil;

public class Prob {

	private static void show(int DEPARTMENT_ID) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select round(avg(salary)) from employees where DEPARTMENT_ID=?";
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, DEPARTMENT_ID );
			rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.printf("%.0f \n",rs.getDouble("round(avg(salary))"));
			} else {
//				System.out.println("흑흑");
				System.out.println("오답");
			}
		} catch (Exception e) {
//			System.out.println("gmrgmr");
			System.out.println("예외처리");
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
	}

	public static void main(String[] args) {
		show(10);
		System.out.println("============================");
		show(50);
	}
}
