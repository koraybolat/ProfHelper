package projPart1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class listGradesActionListener implements ActionListener {

	private JPanel panel;
	private ArrayList<Integer> notlar;
	private Course course;
	private ArrayList<JTextField> dersKodlari;
	private static int sayac;

	public listGradesActionListener(JPanel panel, ArrayList<Integer> notlar, Course course,
			ArrayList<JTextField> dersKodlari, int sayac) {
		this.panel = panel;
		this.notlar = notlar;
		this.course = course;
		this.dersKodlari = dersKodlari;
	}

	public void actionPerformed(ActionEvent e) {
		if (dersKodlari.size() == 1) {
			panel.removeAll();
			int toplam = 0;
			panel.setLayout(new GridLayout(0, 3 + dersKodlari.size() - 1));
			JLabel Id = new JLabel("ID");
			JLabel Name = new JLabel("Name");
			panel.add(Id);
			panel.add(Name);
			for (int i = 0; i < dersKodlari.size(); i++) {
				panel.add(new JLabel("" + dersKodlari.get(i).getText()));
			}

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
					if (p >= 2) {
						JLabel labo = new JLabel("" + notlar.get(i));
						panel.add(labo);
						toplam = toplam + notlar.get(i);
					}
				}
			}
			panel.add(new JLabel("Average"));
			panel.add(new JLabel(""));
			panel.add(new JLabel("" + toplam / notlar.size()));
			panel.revalidate();
			panel.repaint();

		} else {
			JOptionPane.showMessageDialog(null, "Please dont register 2 exam at one time, reopen the program");
		}

	}

}
