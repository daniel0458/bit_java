package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.DeptDao;
import util.JDBCUtil;

public class Test09_update {
	public static void main(String[] args) {
		Emp9 emp = new Emp9();
		int count = emp.update_emp(1111);
		System.out.println(count + "완료");
		System.out.println("업데이트 완료");

		Dept d = new Dept();
		d.setDeptno(50);
		d.setDname("기술부");
		d.setLoc("제주도");
		count = emp.updateDept(d);
		System.out.println(count+ " => | 갱신");
	}
}

class Emp9 {
	public int update_emp(int empno) {
		String sql = "update emp set sal=1000 where empno = ?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			// ? 세팅
			ps.setInt(1, empno);
			// ps.setString(1, x);

			// 실행및 결과값 핸들링
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}

	public int updateDept(Dept dept) {
		String sql = "update dept set dname=?,loc=? where  deptno = ?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			// ? 세팅
			ps.setString(1, dept.getDname());
			ps.setString(2, dept.getLoc());
			ps.setInt(3, dept.getDeptno());
			// ps.setString(1, x);

			// 실행및 결과값 핸들링
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
}