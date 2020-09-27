package yaksha.soap_ws.diff_examResult.bean;

public class StudentResult {
	private int roll;
	private String name;
	private int eng;
	private int lang;
	private int math;
	private int science;
	private int socialScience;
	private int total;
	private String grade;
	public StudentResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentResult(int roll, String name, int eng, int lang, int math, int science, int socialScience, int total,
			String grade) {
		super();
		this.roll = roll;
		this.name = name;
		this.eng = eng;
		this.lang = lang;
		this.math = math;
		this.science = science;
		this.socialScience = socialScience;
		this.total = total;
		this.grade = grade;
	}
	public StudentResult(int roll,int eng, int lang, int math, int science,int socialScience  ) {
		super();
		this.roll = roll;
		this.eng = eng;
		this.lang = lang;
		this.math = math;
		this.science = science;
		this.socialScience = socialScience;
	}
	public StudentResult(int roll, String name) {
		super();
		this.roll = roll;
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getLang() {
		return lang;
	}
	public void setLang(int lang) {
		this.lang = lang;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
	}
	public int getSocialScience() {
		return socialScience;
	}
	public void setSocialScience(int socialScience) {
		this.socialScience = socialScience;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "StudentResult [roll=" + roll + ", name=" + name + ", eng=" + eng + ", lang=" + lang + ", math=" + math
				+ ", science=" + science + ", socialScience=" + socialScience + ", total=" + total + ", grade=" + grade
				+ "]";
	}
}
