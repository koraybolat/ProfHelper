package projPart1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginButtonListener implements ActionListener {
	private JTextField txt;
	private Department dpt;

	public LoginButtonListener(JTextField txt, Department dpt) {
		this.txt = txt;
		this.dpt = dpt;
	}

	public void actionPerformed(ActionEvent e) {
		String st = txt.getText().trim();
		int a = 0;
		for (int i = 0; i < dpt.getInstructors().size(); i++) {
			if (st.equals(dpt.getInstructors().get(i).getEmail())) {
				a++;
				InstructorFrame xd = new InstructorFrame(dpt.getInstructors().get(i));
			}
		}
		if (a == 0) {
			System.out.println("System not Found " + st + "");
			JOptionPane.showMessageDialog(null, "System not found this instructor", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
