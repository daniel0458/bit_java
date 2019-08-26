package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JDBCUtil;

public class Test07_Insert {
	public static void main(String[] args) {
		Emp7 emp = new Emp7();
		int count = emp.insertDept(60, "교육부", "서울");
		System.out.println(count + " : insert");
		System.out.println("---------------------------");
		
//		Employee data = new Employee(7777,"고길동",3900,10);
		Employee data = new Employee();
		data.setEmpno(1111);
		data.setEname("이순신");
		data.setSal(9900);
		data.setDeptno(50);
		
		count = emp.insertEmp(data);
		
		System.out.println(count + " : insert");

		System.out.println("end");
	}
}

class Emp7 {
	public int insertDept(int deptno,String dname,String loc) {
		String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//? 세팅
			ps.setInt(1, deptno);
			ps.setString(2, dname);
			ps.setString(3, loc);
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
	
	public int insertEmp(Employee emp) {
		String sql = "insert into emp(empno,ename,hiredate,sal,deptno)" 
				+"values(?,?,sysdate,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			//? 세팅
			ps.setInt(1,emp.getEmpno() );
			ps.setString(2,emp.getEname() );
			ps.setInt(3,emp.getSal() );
			ps.setInt(4,emp.getDeptno() );
			//ps.setString(1, x);
			
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

}