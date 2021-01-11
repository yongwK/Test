import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JComboBoxTest extends JFrame implements ItemListener {
	JComboBox<String> cb1, cb2, cb3;
	Vector<String> v = new Vector<String>();
	//					0			1			2			3			4
	Color[] color = {Color.red, Color.blue, Color.pink, Color.cyan, Color.gray};
	//						0		1		2		3		4
	String colorName[] = {"red", "blue", "pink", "cyan","gray"};
	// combobox의 데이타를 가지는 객체
	DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
	
	JPanel pane = new JPanel();
	
	JTextArea ta = new JTextArea();
	public JComboBoxTest() {
		add(ta);
		
		
		v.add("홍길동");
		v.add("김길동");
		v.add("박길동");
		v.add("최길동");
		
		cb1 = new JComboBox<String>(v);	 // JComboBox(Vector<E> items)
		pane.add(cb1);
		add(pane, BorderLayout.NORTH);
		
		
		cb2 = new JComboBox<String>(colorName);   // JComboBox(E[] items)
		pane.add(cb2);
		
		
		
		
		// JComboBox(ComboBoxModel<E> aModel) 권장하는 방법
		model.addElement("JAVA");
		model.addElement("Oracle");
		model.addElement("Spring");
		model.addElement("Mybatis");
		cb3 = new JComboBox<String>(model);
		pane.add(cb3);
		
	
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		
		cb3.insertItemAt("Jsp", 2);
	}
	
	public void itemStateChanged(ItemEvent ie) {
		Object obj = ie.getSource();
		if(obj == cb3 ) {
			String str = (String)cb3.getSelectedItem();
			ta.append(str+"\n");
		}else if(obj == cb2) {
		int idx = cb2.getSelectedIndex();
		ta.setBackground(color[idx]);
		}
	}

	public static void main(String[] args) {
		new JComboBoxTest();

	}

}
