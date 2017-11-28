package projPart1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class registerExamListener implements ActionListener {

	private Course course;
	private JPanel panel;
	private ArrayList<Integer> notlar;
	private ArrayList<JTextField> dersKodlari;
	private static int sayac;

	public registerExamListener(Course course, JPanel panel, ArrayList<Integer> notlar,
			ArrayList<JTextField> dersKodlari, int sayac) {
		this.course = course;
		this.panel = panel;
		this.notlar = notlar;
		this.dersKodlari = dersKodlari;
	}

	public void actionPerformed(ActionEvent e) {
		panel.removeAll();
		ArrayList<JTextField> textler = new ArrayList<JTextField>();
		JLabel ExamId = new JLabel("Enter Exam ID: ");
		JTextField examIdText = new JTextField("");
		panel.add(ExamId);
		panel.add(examIdText);
		panel.add(new JLabel("      "));
		panel.setLayout(new GridLayout(0, 3));
		JLabel Id = new JLabel("ID");
		JLabel Name = new JLabel("Name");
		JLabel email = new JLabel("Grades");
		panel.add(Id);
		panel.add(Name);
		panel.add(email);
		for (int i = 0; i < course.getStudents().size(); i++) {
			for (int p = 0; p < 3; p++) {
				if (p == 0) {
					JLabel labo = new JLabel("" + course.getStudents().get(i).getId());
					panel.add(labo);
				}
				if (p == 1) {
					JLabel labo = new JLabel("" + course.getStudents().get(i).getName());
					panel.add(labo);
				}
				if (p == 2) {
					JTextField text = new JTextField("");
					panel.add(text);
					textler.add(text);
				}
			}
		}

		JButton saver = new JButton("Save");

		saver.addActionListener(new saveActionListener(textler, course, examIdText, notlar, dersKodlari, sayac));

		panel.add(saver);

		panel.revalidate();
		panel.repaint();
	}

}
