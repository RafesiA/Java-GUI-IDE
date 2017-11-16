import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Arrays;



public class TermProject extends JFrame {
	String FileName;
	File E_file = new File("C:\\Error_File.txt");
	File javaFile;
	
	JButton btn1 = new JButton("Java File Upload");
	JButton btn2 = new JButton("Compile");
	JButton btn3 = new JButton("Run Program");
	JButton btn4 = new JButton("Compile Error List");
	JButton btn5 = new JButton("Reset");
	JButton btn6 = new JButton("Exit");
	JTextField jt = new JTextField("File Directory", 20);
	JTextArea st = new JTextArea("Status \n");//Status 출력
	JTextArea ja = new JTextArea("Editor" + "\n");//Editor
	JTextArea er = new JTextArea("Error Message" + "\n");//Error 내용 출력
	JLabel txt = new JLabel("파일 경로를 입력하고 버튼을 클릭하세요.");
	
	class EPanel extends JPanel{
		EPanel(){
			setVisible(true);
			setSize(1000,500);
			setLayout(new BorderLayout());
			ja.setSize(900, 450);
			add(ja,BorderLayout.CENTER);
			add(new JScrollPane(ja));
		}
	}
	
	class RPanel extends JPanel{
		RPanel(){
			setVisible(true);
			setSize(1000,200);
			setLayout(new BorderLayout());
			er.setSize(900, 150);
			add(er,BorderLayout.CENTER);
			add(new JScrollPane(er));
		}
	}

	public TermProject() {
		EPanel e = new EPanel();
		RPanel r = new RPanel();
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
		st.add(new JScrollPane());
		
		btn2.setSize(200, 100);
		btn2.setLocation(800,150);
		contentPane.add(btn2);
		
		
		e.setLocation(0, 250);
		contentPane.add(e);
		
		
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
		
		
		r.setLocation(0,850);
		contentPane.add(r);
		
	
		ja.setEditable(true);
		er.setEditable(false);
		st.setEditable(false);
		
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
				int i =0;
				try {
					FileReader fr = null;
					FileName = jt.getText();
					st.append(FileName + "\n");
					fr = new FileReader(FileName);
						
					} catch(IOException er){
						System.out.println(er);
					}
				}
				//void UploadJ();
			else if(b.getText().equals("Compile")) {
				st.append("Compiled" + "\n");
				String s = null;
				try {
					Process oProcess = new ProcessBuilder("javac", FileName).start();
					BufferedReader stdError = new BufferedReader(new InputStreamReader
				(oProcess.getErrorStream()));
					while ((s = stdError.readLine()) != null) {
						st.append("컴파일 에러");
						FileWriter fw = new FileWriter(E_file, true);
						fw.write(s);
						fw.flush();
						fw.close();
					}
					
					st.append(FileName + " 파일이 정상적으로 컴파일 되었습니다.");
					
				} catch(IOException e1) {
					System.out.println(e1);
				}
				//void Compile();
			}
			
			else if(b.getText().equals("Run Program")) {
				File file = new File(FileName);
				String fname = file.getName();
				String path = file.getParent();
				int pos = fname.lastIndexOf(".");
				if(pos > 0) {
					fname = fname.substring(0, pos);
				}
				List<String> cmds = Arrays.asList("cmd.exe", "/c java", path + " "+ fname);
				try {
					Process rProcess = new ProcessBuilder(cmds).start();
					BufferedReader stdOut = new BufferedReader(new InputStreamReader(rProcess.getInputStream()));
					BufferedReader stdError = new BufferedReader(new InputStreamReader(rProcess.getErrorStream()));
					st.append(FileName + " 가 실행중");
					System.out.println("cmd.exe" + "/c java " + path +" "+ fname);
					
				} catch(IOException e2) {
					st.append("치명적 에러");
				}
				b.setVisible(true);
				
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
