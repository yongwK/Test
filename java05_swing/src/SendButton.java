import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendButton implements ActionListener {
	JTextArea jta;
	JTextField jtf;
	
	
	
	public SendButton() {
		
	}
	
	public SendButton(JTextArea jta, JTextField jtf) {
		this.jta = jta;
		this.jtf = jtf;
	}
	
	public void actionPerformed(ActionEvent ae) {
		jta.append("--->"+ jtf.getText()+"\n");
		jtf.setText("");
	}

}
