package jdbc_HW;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBCUtil;

public class Prob2 {

	public static void main(String[] args) {
		Emp.show(10);
		System.out.println("============================");
		Emp.show(20);
	}
}

class Emp {
	public static void show(int deptno) {


		String sql = "select round(avg(sal)) as \"부서별 평균 급여\" from emp where deptno=?";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, deptno);
			rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println(deptno + "부서");
				System.out.printf("%d \n", rs.getInt("부서별 평균 급여"));
			} else {
				System.out.println("오답");
			}
		} catch (Exception e) {
			System.out.println("예외처리");
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
	}
}