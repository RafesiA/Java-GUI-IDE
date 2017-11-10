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
	JTextField jt = new JTextField("File Directory", 20);
	JTextField st = new JTextField("Status", 20);//Status 출력
	JTextArea ja = new JTextArea("Editor" + "\n");//Editor
	JTextArea er = new JTextArea("Error Message" + "\n");//Error 내용 출력
	JLabel txt = new JLabel("파일 경로를 입력하고 버튼을 클릭하세요.");

	public TermProject() {
		setResizable(false);
		setTitle("Java IDE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.gray);
		MyActionListener al = new MyActionListener();
		setLayout(null);
		
		txt.setSize(1000, 50);
		txt.setLocation(380, 0);
		contentPane.add(txt);
		
		jt.setSize(800, 100);
		jt.setLocation(0, 50);
		contentPane.add(jt);
		
		btn1.setSize(200, 100);
		btn1.setLocation(800, 50);
		contentPane.add(btn1);
		
		
		st.setSize(800, 100);
		st.setLocation(0, 150);
		contentPane.add(st);
		
		btn2.setSize(200, 100);
		btn2.setLocation(800,150);
		contentPane.add(btn2);
		
		ja.setSize(900, 450);
		ja.setLocation(50, 275);
		contentPane.add(ja);
		
		
		btn3.setSize(250, 100);
		btn3.setLocation(0,750);
		contentPane.add(btn3);
		
		btn4.setSize(250, 100);
		btn4.setLocation(250,750);
		contentPane.add(btn4);
		
		btn5.setSize(250, 100);
		btn5.setLocation(500,750);
		contentPane.add(btn5);
		
		btn6.setSize(250, 100);
		btn6.setLocation(750,750);
		contentPane.add(btn6);
		
		er.setSize(900, 150);
		er.setLocation(50,860);
		contentPane.add(er);
		
	
		ja.setEditable(false);
		er.setEditable(false);
		
		btn1.addActionListener(al);
		
		
		btn2.addActionListener(al);
		
		btn3.addActionListener(al);
		
		btn4.addActionListener(al);
		
		btn5.addActionListener(al);
		
		btn6.addActionListener(al);
		
	
		setSize(1000,1050);
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
				ja.append("Compiled" + "\n");
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
				File file = new File(FileName);
				String fname = file.getName();
				int pos = fname.lastIndexOf(".");
				if(pos > 0) {
					fname = fname.substring(0, pos);
				}
				try {
					Process rProcess = new ProcessBuilder("cmd.exe", "/C java", fname, "start").start();
					System.out.println("cmd 실행됨");
					
				} catch(IOException e2) {
					ja.append("치명적 에러");
				}
				
			}
			    //void Run();
			else if(b.getText().equals("Compile Error List")) {
				
			}
			    //void Compile_E();
			else if(b.getText().equals("Reset")) {
				E_file.delete();
				
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
