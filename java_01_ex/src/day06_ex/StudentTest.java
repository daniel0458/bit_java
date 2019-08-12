package day06_ex;

public class StudentTest {
	public static void main(String[] args) {
		Student std1 = new Student();
		std1.setName("홍길동");
		std1.setKoreanScore(90);
		std1.setMathScore(50);
		std1.setScienceScore(70);
		
		Student std2 = new Student();
		std2.setName("김길동");
		std2.setKoreanScore(80);
		std2.setMathScore(70);
		std2.setScienceScore(100);

		Student std3 = new Student();
		std3.setName("강길동");
		std3.setKoreanScore(50);
		std3.setMathScore(30);
		std3.setScienceScore(60);
		
		Student[] std = {std1,std2,std3};
		
		double koAvg = 0;
		double mtAvg = 0;
		double scAvg = 0;
		
		for(Student data : std) {
			koAvg +=data.getKoreanScore();
			mtAvg +=data.getMathScore();
			scAvg +=data.getScienceScore();
		}
		koAvg /= 3.0;
		mtAvg /= 3.0;
		scAvg /= 3.0;
		
		System.out.println("각과목의 평균은 국어: " + koAvg + ", 수학: " + mtAvg + ", 과학: " + scAvg);
	}
}
