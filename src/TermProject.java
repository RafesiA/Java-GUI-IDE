import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;



public class TermProject extends JFrame {
	String FileName;
	File E_file = new File("C:\\Error_File.txt");
	
	JButton btn1 = new JButton("Java File Upload");
	JButton btn2 = new JButton("Compile");
	JButton btn3 = new JButton("Run Program");
	JButton btn4 = new JButton("Compile Error List");
	JButton btn5 = new JButton("Reset");
	JButton btn6 = new JButton("Exit");
	JTextField jt = new JTextField("", 20);
	JTextArea ja = new JTextArea("여기서 출력됨" + "\n", 7, 20);
	
	
	
	
	public TermProject() {
		setTitle("Java IDE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new GridLayout(12,1,0,0));
		MyActionListener al = new MyActionListener();
		contentPane.add(new JLabel("파일 경로를 입력하고 버튼을 클릭하세요."));
		contentPane.add(jt);
		contentPane.add(new JScrollPane(ja));
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
		
	
		setSize(800, 600);
		setVisible(true);
	}
	class MyActionListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Java File Upload")) {
				FileName = jt.getText();
			    ja.append(FileName + "\n");
				}
				//void UploadJ();
			else if(b.getText().equals("Compile")) {
				String s = null;
				try {
					Process oProcess = new ProcessBuilder("javac", FileName).start();
					BufferedReader stdError = new BufferedReader(new InputStreamReader
				(oProcess.getErrorStream()));
					while ((s = stdError.readLine()) != null) {
						FileWriter fw = new FileWriter(E_file, true);
						fw.write(s);
						fw.flush();
						fw.close();
					}
					
					ja.append(FileName + " 파일이 정상적으로 컴파일 되었습니다.");
					
				} catch(IOException e1) {
					System.out.println(e1);
				}
				//void Compile();
			}
			
			else if(b.getText().equals("Run")) {
				
			}
			    //void Run();
			else if(b.getText().equals("Compile Error List")) {
				
			}
			    //void Compile_E();
			else if(b.getText().equals("Reset")) {
				
			}
			    //void Reset();
			else if(b.getText().equals("Exit"))
				System.exit(0);
			    		
		}
		
	}
	
	public static void main(String[] args) {
		new TermProject();
	}

}
