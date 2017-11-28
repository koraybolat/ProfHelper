package projPart1;

import java.util.ArrayList;
import java.util.Random;

public class Instructor extends Person {

	private ArrayList<Course> courses;

	public Instructor(String name) {
		super(name);
		courses = new ArrayList<Course>();
		initEmail();

	}

	public void addCourse(Course a) {
		courses.add(a);

	}

	public ArrayList<Course> getCourses() {
		return courses;
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

	public void registerExamGrades(String courseId, String examId) {
		Random rgn = new Random();

		int y = 0;
		int ds = 0;
		for (int i = 0; i < courses.size(); i++) {
			if (courseId.equals(courses.get(i).getId())) {
				y = 1;
				ds = i;
				break;
			}
		}
		if (y == 0) {
			System.out.println("Instructor " + this.getName() + " cannot grade the " + courseId + ".");
		}
		if (y == 1) {
			for (int i = 0; i < courses.get(ds).getStudents().size(); i++) {
				int x = rgn.nextInt(100);
				GradeItem dýdýn = new GradeItem(courseId, examId, x);
				courses.get(ds).getStudents().get(i).getGrades().add(dýdýn);
			}
		}
	}

	public void listGradesForExam(String courseId, String examId) {
		System.out.println("" + courseId + " " + examId + " grades are: ");
		int xyz = 0;
		int x = 0;
		for (int i = 0; i < courses.size(); i++) {
			if (courseId.equals(courses.get(i).getId())) {
				xyz = 1;
				x = i;
				break;
			}
		}
		if (xyz == 1) {
			for (int a = 0; a < courses.get(x).getStudents().size(); a++) {
				System.out.println("" + courses.get(x).getStudents().get(a).getName() + ": ["
						+ courses.get(x).getStudents().get(a).getGradeItem(courseId, examId).getExamId() + ": "
						+ courses.get(x).getStudents().get(a).getGradeItem(courseId, examId).getGrade() + "]");
			}

		}

	}

	public void printAverageGradeForExam(String courseId, String examId) {
		System.out.print("" + courseId + " " + examId + " average grade is:");
		int xyz = 0;
		int x = 0;
		double gradetoplam = 0;
		int sayac = 0;
		for (int i = 0; i < courses.size(); i++) {
			if (courseId.equals(courses.get(i).getId())) {
				xyz = 1;
				x = i;
				break;
			}
		}
		if (xyz == 1) {
			for (int a = 0; a < courses.get(x).getStudents().size(); a++) {

				gradetoplam = gradetoplam
						+ courses.get(x).getStudents().get(a).getGradeItem(courseId, examId).getGrade();
				sayac++;
			}

		}
		System.out.println("" + gradetoplam / sayac);

	}

}
