package projPart1;

import java.util.ArrayList;

public class Department {

	private String name;
	private ArrayList<Course> courses;
	private ArrayList<Instructor> instructors;
	private ArrayList<Student> students;

	public Department(String name) {
		this.name = name;
		courses = new ArrayList<Course>();
		instructors = new ArrayList<Instructor>();
		students = new ArrayList<Student>();

	}

	public void addInstructor(String a) {
		Instructor ins = new Instructor(a);
		instructors.add(ins);
	}

	public void addStudent(String a) {
		Student ýnd = new Student(a);
		students.add(ýnd);
	}

	public void assignInstructorToCourse(String instructorName, String courseId) {
		int x1 = 0;
		int x2 = 0;
		int y1 = 0;
		int y2 = 0;

		for (int i = 0; i < instructors.size(); i++) {

			if (instructors.get(i).getName().equals(instructorName)) {
				x1 = 1;
				x2 = i;
			}
		}

		if (x1 == 0) {
			System.out.println("Instructor Not Found: " + instructorName);
		}

		for (int i = 0; i < courses.size(); i++) {

			if (courses.get(i).getId().equals(courseId)) {
				y1 = 1;
				y2 = i;
			}
		}

		if (y1 == 0) {
			System.out.println("Course not found: " + courseId);
		}

		if (x1 == 1 && y1 == 1) {
			instructors.get(x2).addCourse(courses.get(y2));
			courses.get(y2).setInstructor(instructors.get(x2));

		}
	}

	public void createCourse(String courseId, String courseName) {
		Course c = new Course(courseId, courseName);
		courses.add(c);
	}

	public Course getCourse(String st) {
		int x = 0;
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId().equals(st) || courses.get(i).getName().equals(st)) {
				x = i;
			}
		}
		return courses.get(x);

	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public Instructor getInstructorByName(String st) {
		int x = -1;
		for (int i = 0; i < instructors.size(); i++) {
			if (instructors.get(i).getName().equals(st)) {
				x = i;
			}
		}
		if (x == -1) {
			return null;
		}
		return instructors.get(x);
	}

	public void listInstructors() {
		System.out.println("Instructors registered in this department are: ");
		for (int i = 0; i < instructors.size(); i++) {
			System.out.println("" + instructors.get(i).getId() + ", " + instructors.get(i).getName() + ", "
					+ instructors.get(i).getEmail());

		}
	}

	public void listCourses() {
		System.out.println("Courses given by this department are: ");
		int x = 0;
		for (int i = 0; i < courses.size(); i++) {
			if (instructors.get(x).getCourses().size() != 0) {
				if (courses.get(i).getName().equals(instructors.get(x).getCourses().get(0).getName())) {
					System.out.println("" + courses.get(i).getId() + " " + courses.get(i).getName() + " by "
							+ instructors.get(x).getName());
					x++;
				} else {
					System.out.println("" + courses.get(i).getId() + " " + courses.get(i).getName());

				}
			}

			else {
				System.out.println("" + courses.get(i).getId() + " " + courses.get(i).getName());
			}
		}
	}

	public void listStudents() {
		System.out.println("Students registered in this department are: ");
		for (int i = 0; i < students.size(); i++) {
			System.out.println("" + students.get(i).getId() + ", " + students.get(i).getEmail() + ", "
					+ students.get(i).getName());
		}

	}

	public ArrayList<Instructor> getInstructors() {
		return instructors;
	}

}
