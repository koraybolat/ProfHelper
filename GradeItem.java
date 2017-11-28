package projPart1;

public class GradeItem {
	private String courseId;
	private String examId;
	private int grade;

	public GradeItem(String courseId, String examId, int grade) {
		this.courseId = courseId;
		this.examId = examId;
		this.grade = grade;
	}

	public String getCourseId() {
		return courseId;
	}

	public String getExamId() {
		return examId;
	}

	public int getGrade() {
		return grade;
	}

	public String toString() {
		return "This GradeItems's courseID is " + this.getCourseId() + " and examID is" + this.getExamId()
				+ " and grade is " + this.getGrade();
	}

}
