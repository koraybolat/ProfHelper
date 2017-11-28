package projPart1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class saveActionListener implements ActionListener {

	private ArrayList<JTextField> notlar;
	private Course course;
	private JTextField txt;
	private ArrayList<Integer> notlarXD;
	private ArrayList<JTextField> dersKodlari;
	private static int sayac;

	public saveActionListener(ArrayList<JTextField> notlar, Course course, JTextField txt, ArrayList<Integer> notlarXD,
			ArrayList<JTextField> dersKodlari, int sayac) {
		this.course = course;
		this.notlar = notlar;
		this.txt = txt;
		this.notlarXD = notlarXD;
		this.dersKodlari = dersKodlari;
	}

	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < notlar.size(); i++) {
			notlarXD.add(Integer.valueOf(notlar.get(i).getText()));
		}
		sayac++;
		JOptionPane.showMessageDialog(null, "Grades Saved");
		dersKodlari.add(txt);
	}

}
