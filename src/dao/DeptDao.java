package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.Dept;
import util.JDBCUtil;

public class DeptDao {
	
	//Dept 테이블의 모든 레코드 정보
	public List<Dept> getAllDeptRec() {
		String sql = "select * from dept";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Dept> list = new ArrayList<Dept>();
		try {
			con = JDBCUtil.getConnection();
			System.out.println(" ******* con 할당 ******* ");
			ps = con.prepareStatement(sql);
			
			//? 세팅
			//ps.setString(1, x);
			
			//실행및 결과값 핸들링
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Dept(rs.getInt("deptno"), 
						rs.getString("dname"), 
						rs.getString("loc")));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtil.close(con, ps, rs);
			System.out.println(" ******* con 반납 ******* ");
		}
		return list;
	}
	
	public int insertDept(Dept dept) {
		String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//? 세팅
			ps.setInt(1, dept.deptno);
			ps.setString(2, dept.dname);
			ps.setString(3, dept.loc);
			//실행및 결과값 핸들링
			//rs = ps.executeQuery();
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
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
