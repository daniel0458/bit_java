package test;

import dao.DeptDao;

public class Test09_DeptDao {
	public static void main(String[] args) {
		DeptDao dao = new DeptDao();
		dao.getAllDeptRec().forEach(i -> System.out.println(i));
	}
}
