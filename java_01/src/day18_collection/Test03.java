package day18_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Test03 {
	public static void main(String[] args) {
		Student[] s = new Student[10];

		Vector<Student> list = new Vector<Student>(5,10); // 내부에 Student[] 만들어서 관리
		System.out.println("capacity :"+list.capacity());
		System.out.println("size :" + list.size());
		
		list.add(new Student("홍순이", 88, 99));
		list.add(new Student("차순이", 82, 93));
		list.add(new Student("고순이", 80, 91));
		
		Student[] ss = { new Student("홍순이", 88, 99), new Student("차순이", 82, 93), new Student("고순이", 80, 91),
				new Student("홍길동", 100, 100) };
		Arrays.parallelSort(ss);
		System.out.println(Arrays.toString(ss));
//		System.out.println(list);

		// equals를 override하지 않았다면 비교하지 못해 false출력
		// System.out.println(list.contains(new Student("고순이", 80, 91)));
		Iterator<Student> it = list.iterator();
		while (it.hasNext()) {
			Student data = it.next();
			if (data.getAvg() >= 90) {
				System.out.println(data);
			}
		}

		// CURD : Create Update Research Delete
		// 홍길동 90 90 등록
		Student s1 = new Student("홍길동", 90, 90);
		boolean flag = list.add(s1);
		if (flag)
			System.out.println(s1 + "등록되었습니다.");
		else {
			System.out.println(s1 + "등록을 실패했습니다.");
		}
//		list.add(new Student("홍길동", 90, 90));

		// 홍길동 100 100으로 수정
		it = list.iterator();
		while (it.hasNext()) {
			Student data = it.next();
			if (data.name.equals("홍길동")) {
				data.math = 100;
				data.ko = 100;
				data.setAvg();
				System.out.println(data + "수정되었습니다.");
			}
		}

		// s1 삭제 처리
		System.out.println(" ****  학생" + s1 + "정보삭제    ****");
		it = list.iterator();
		while (it.hasNext()) {
			Student data = it.next();
			if (data.equals(s1)) {
				it.remove();
				System.out.println(s1 + "삭제 되었습니다.");
			}
		}

		Collections.sort(list); // Collection Sort 수행

		// list 목록 출력
		System.out.println("**** 학생 List 정보 출력 ****");
		it = list.iterator();
		while (it.hasNext()) {
			Student data = it.next();
			System.out.println(data);
		}

	}
}

