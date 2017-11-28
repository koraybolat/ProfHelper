package projPart1;

import java.util.ArrayList;

public class Student extends Person {

	private ArrayList<Course> enrolledCourses;
	private ArrayList<GradeItem> grades;

	public Student(String name) {
		super(name);
		enrolledCourses = new ArrayList<Course>();
		grades = new ArrayList<GradeItem>();
		initEmail();
	}

	public void initEmail() {
		String[] xd = this.getName().toLowerCase().split(" ");
		String ak = "";
		for (int i = 0; i < xd.length; i++) {

			if (i == 0) {
				ak = ak + "" + xd[i];
				ak = ak + ".";
			}
			if (i == 1) {
				ak = ak + "" + xd[i];
				ak = ak + "@ozyegin.edu.tr";
			}
		}
		this.setEmail(ak);
	}

	public void registerToCourse(Course course) {

		enrolledCourses.add(course);
		course.addStudent(this);

		if (course.getInstructor() == null) {
			System.out.println("Course not available");
		}
	}

	public void dropCourse(Course course) {
		enrolledCourses.remove(course);
		course.removeStudent(this);
	}

	public GradeItem getGradeItem(String courseId, String examId) {
		int x = -1;
		for (int i = 0; i < grades.size(); i++) {
			if (grades.get(i).getCourseId().equals(courseId) && grades.get(i).getExamId().equals(examId)) {
				x = i;
			}
		}
		if (x == -1) {
			return null;
		}

		return grades.get(x);

	}

	public void listGrades() {
		for (int i = 0; i < grades.size(); i++) {
			if (i != 0) {
				if (grades.get(i - 1).getCourseId().equals(grades.get(i).getCourseId())) {
					System.out.println(" [" + grades.get(i).getExamId() + ": " + grades.get(i).getGrade() + "]");
				} else {
					System.out.println("" + grades.get(i).getCourseId() + " grades of " + this.getName() + " ["
							+ grades.get(i).getExamId() + ": " + grades.get(i).getGrade() + "]");
				}
			} else {
				System.out.println("" + grades.get(i).getCourseId() + " grades of " + this.getName() + " ["
						+ grades.get(i).getExamId() + ": " + grades.get(i).getGrade() + "]");
			}
		}

	}

	public ArrayList<GradeItem> getGrades() {
		return grades;
	}

}
