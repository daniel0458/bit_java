package day19_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Test04 {
	public static void main(String[] args) {
		Map<Integer, Employee> map = new HashMap<Integer, Employee>();
		
		Employee[] emp = {
				new Employee(2017002, "김씨","마케팅부")
		};
		
		map.put(2017002, new Employee(2017002, "김씨","마케팅부"));
		map.put(2017009, new Employee(2017009, "김씨","마케팅부"));
		map.put(2017012, new Employee(2017012, "홍씨","영업부"));
		map.put(2018002, new Employee(2018002, "박씨","마케팅부"));
		map.put(2019002, new Employee(2019002, "김씨","영업부"));
		
		//사원 조회 사번을 입력 하세요 2018002
		System.out.println(" 20180002 사번의 사원 조회 내역");
		System.out.println(map.get(2018002));
		
		//마케팅부 사원 목록 출력
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			int comCode = it.next();
			Employee empl = map.get(comCode);
			if (empl.dept.equals("마케팅부")) {
				System.out.println(map.get(comCode));
			}
		}
		System.out.println("==============================");
		// 삭제 사번기준 삭제 2018002
		System.out.println(map.remove(2018002));
		System.out.println(map);
		System.out.println("2018002 사원정보 => " + map.get(2018002));
	}
}
