import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TermProject extends JFrame {
	String FileName;
	JTextField jt;
	JButton btn1 = new JButton("Java File Upload");
	JButton btn2 = new JButton("Compile");
	JButton btn3 = new JButton("Run Program");
	JButton btn4 = new JButton("Compile Error List");
	JButton btn5 = new JButton("Reset");
	JButton btn6 = new JButton("Exit");
	
	public TermProject() {
		setTitle("Java IDE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new GridLayout(7, 1, 0, 0));
		MyActionListener al = new MyActionListener();
		jt = new JTextField();
		contentPane.add(jt);
		contentPane.add(btn1);
		btn1.addActionListener(al);
		contentPane.add(btn2);
		btn2.addActionListener(al);
		contentPane.add(btn3);
		btn3.addActionListener(al);
		contentPane.add(btn4);
		btn4.addActionListener(al);
		contentPane.add(btn5);
		btn5.addActionListener(al);
		contentPane.add(btn6);
		btn6.addActionListener(al);
		
		
		setSize(500, 250);
		setVisible(true);
	}
	class MyActionListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Java File Upload")){
				FileName = jt.getText();
				System.out.println(jt.getText());
			}
				//void UploadJ();
			else if(b.getText().equals("Comile"))
				;
				//void Compile();
			else if(b.getText().equals("Run"))
				;
			    //void Run();
			else if(b.getText().equals("Compile Error List"))
				;
			    //void Compile_E();
			else if(b.getText().equals("Reset"))
				;
			    //void Reset();
			else if(b.getText().equals("Exit"))
				System.exit(0);
			    		
		}
		
	}
	
	public static void main(String[] args) {
		new TermProject();
	}

}
