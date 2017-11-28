package projPart1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class listStudentButtonActionListener implements ActionListener {

	private Course course;
	private JPanel panel;

	public listStudentButtonActionListener(Course course, JPanel panel) {
		this.course = course;
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent e) {
		panel.removeAll();

		panel.setLayout(new GridLayout(0, 3));
		JLabel Id = new JLabel("ID");
		JLabel Name = new JLabel("Name");
		JLabel email = new JLabel("Email");
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
					JLabel labo = new JLabel("" + course.getStudents().get(i).getEmail());
					panel.add(labo);
				}
			}
		}

		panel.revalidate();
		panel.repaint();

	}

}
