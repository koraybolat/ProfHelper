package projPart1;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class InstructorFrame extends JFrame {

	private Instructor instructor;
	private ArrayList<Integer> notlar;
	private ArrayList<JTextField> dersKodlari;
	private static int sayac = 0;

	public InstructorFrame(Instructor instructor) {
		this.instructor = instructor;
		notlar = new ArrayList();
		dersKodlari = new ArrayList();
		init();
	}

	private void init() {
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		JPanel OlaylarPaneli = new JPanel();

		JTabbedPane tabbedPane = new JTabbedPane();

		// You won't use this particular code.
		// You need to modify it
		// Just use it as an example to create course tabbedpanes.

		for (int i = 0; i < this.instructor.getCourses().size(); i++) {
			JPanel panel = new JPanel();
			JButton listStudentsButton = new JButton("List Students");
			JButton RegisterExamGradesButton = new JButton("Register Exam Grades");
			JButton listGradesButton = new JButton("List Grades");
			panel.add(listStudentsButton);
			listStudentsButton.addActionListener(
					new listStudentButtonActionListener(instructor.getCourses().get(i), OlaylarPaneli));
			panel.add(RegisterExamGradesButton);
			RegisterExamGradesButton.addActionListener(new registerExamListener(instructor.getCourses().get(i),
					OlaylarPaneli, notlar, dersKodlari, sayac));
			panel.add(listGradesButton);
			listGradesButton.addActionListener(new listGradesActionListener(OlaylarPaneli, notlar,
					instructor.getCourses().get(i), dersKodlari, sayac));
			tabbedPane.addTab("" + instructor.getCourses().get(i).getId(), panel);
		}

		this.add(OlaylarPaneli, BorderLayout.CENTER);
		this.add(tabbedPane, BorderLayout.NORTH);
		this.setVisible(true);

	}

}
