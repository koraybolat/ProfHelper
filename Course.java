package projPart1;

import java.util.ArrayList;

public class Course {
	private String id;
	private String name;
	private Instructor instructor;
	private ArrayList<Student> students;

	public Course(String id, String name) {
		this.id = id;
		this.name = name;
		students = new ArrayList<Student>();

	}

	public void addStudent(Student a) {
		students.add(a);
	}

	public void removeStudent(Student b) {
		students.remove(b);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;

	}

	public void listStudents() {
		System.out.println("Students registered in " + this.getName());
		for (int i = 0; i < students.size(); i++) {
			System.out.println("" + students.get(i).getName());
		}
	}

	public String toString() {
		return "This course's id is " + this.getId() + ". The name is " + this.getName();
	}

}
