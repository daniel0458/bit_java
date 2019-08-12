package day06_ex;

public class Student {
	private String name;
	private int koreanScore;
	private int mathScore;
	private int scienceScore;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.length() < 2) {
			System.out.println("다시 입력하십시오");
			return;
		}
		this.name = name;
	}
	public int getKoreanScore() {
		return koreanScore;
	}
	public void setKoreanScore(int koreanScore) {
		if(koreanScore < 0 || koreanScore > 100 ) {
			System.out.println("점수를 다시 입력하세요");
			return;
		}
		this.koreanScore = koreanScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		if(mathScore < 0 || mathScore > 100 ) {
			System.out.println("점수를 다시 입력하세요");
			return;
		}
		this.mathScore = mathScore;
	}
	public int getScienceScore() {
		return scienceScore;
	}
	public void setScienceScore(int scienceScore) {
		if(scienceScore < 0 || scienceScore > 100 ) {
			System.out.println("점수를 다시 입력하세요");
			return;
		}
		this.scienceScore = scienceScore;
	}
	
}
