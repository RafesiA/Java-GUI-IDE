import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Arrays;



public class TermProject extends JFrame {
	String FileName;
	File E_file = new File("C:\\Temp\\Error_File.txt");
	File javaFile;
	char aChar = 92;
	
	static int CR = 1;							// 전역변수, 1 = Disable Run function, 0 = Enable Run function
	static int CO = 1;                          // 전역변수, 0 = Disable Compile function, 1 = Enable Compile function
	static int CP = 1;                          // 전역변수, 1 = Disable Compile Error list function, 0 = Enable Compile Error list function
	static int errorList = 1;
	
	JButton btn1 = new JButton("Java File Upload");
	JButton btn2 = new JButton("Compile");
	JButton btn3 = new JButton("Run Program");
	JButton btn4 = new JButton("Compile Error List");
	JButton btn5 = new JButton("Reset");
	JButton btn6 = new JButton("Exit");
	JButton btn7 = new JButton("Save");
	JTextField jt = new JTextField("File Directory", 20);
	JTextArea st = new JTextArea("Status \n");//Status 출력
	JTextArea ja = new JTextArea("Editor" + "\n");//Editor
	JTextArea er = new JTextArea("Error Message, Result" + "\n");//Error 내용 출력
	JTextField sf = new JTextField("Save File Title");
	JLabel txt = new JLabel("파일 경로를 입력하고 버튼을 클릭하세요.");
	
	
	class SPanel extends JPanel{
		SPanel(){
			setVisible(true);
			setSize(1000,100);
			setLayout(new BorderLayout());
			st.setSize(1000,100);
			add(st,BorderLayout.CENTER);
			add(new JScrollPane(st));
		}
	}
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
			setSize(1000,150);
			setLayout(new BorderLayout());
			er.setSize(900, 150);
			add(er,BorderLayout.CENTER);
			JScrollPane scr = new JScrollPane();
			
			add(new JScrollPane(er));
		}
	}

	public TermProject() {
		SPanel s = new SPanel();
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
		
		btn1.setSize(200, 50);
		btn1.setLocation(800, 50);
		contentPane.add(btn1);
		
		
		sf.setSize(800,100);
		sf.setLocation(0, 150);
		contentPane.add(sf);
		
		s.setLocation(0, 250);
		contentPane.add(s);
		
		btn2.setSize(200, 50);
		btn2.setLocation(800,100);
		contentPane.add(btn2);
		
		
		e.setLocation(0, 350);
		contentPane.add(e);
		
		
		btn3.setSize(250, 100);
		btn3.setLocation(0,850);
		contentPane.add(btn3);
		
		btn4.setSize(250, 100);
		btn4.setLocation(250,850);
		contentPane.add(btn4);
		
		btn5.setSize(250, 100);
		btn5.setLocation(500,850);
		contentPane.add(btn5);
		
		btn6.setSize(250, 100);
		btn6.setLocation(750,850);
		contentPane.add(btn6);
		
		btn7.setSize(200,100);
		btn7.setLocation(800, 150);
		contentPane.add(btn7);
		
		
		r.setLocation(0,950);
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
		
		btn7.addActionListener(al);
		
	
		setSize(1000,1130);
		setVisible(true);
	}
	class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Java File Upload")) {
					try {
						FileReader fr = null;
						FileName = jt.getText();
						st.append(FileName + "\n");
						BufferedReader br = new BufferedReader(new FileReader(FileName));
						ja.read(br, FileName);
						CO = 0;
					
						} catch(IOException er){
							System.out.println(er);
							CO = 1;
						}
					}
				
	
			
				//void UploadJ();
			else if(b.getText().equals("Compile")) {
				if(FileName != null && CO == 0) {
				st.append("Compiled" + "\n");
				btn3.setEnabled(true);
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
					
				} catch(IOException e1) {
					System.out.println(e1);
				}
				if(E_file.exists() == true) {
					st.append("컴파일 에러" +"\n");
					st.append(FileName + " 파일이 정상적으로 컴파일 되지 않았습니다." + "\n");
					CR = 1;
					}
				}
				 else if(E_file.exists() == false)
					CR = 0;
				else {
					st.append("파일이 업로드되지 않았습니다.\n");
				}
				//void Compile();
			}
			
			else if(b.getText().equals("Save")) {
				String et = ja.getText();
				String FilePath = "C:\\temp\\" +  sf.getText() + ".java";
				File f = new File(FilePath);
				
				
				if(!f.exists())
					try {
						System.out.println(FilePath);
						f.createNewFile();
						FileWriter fw = new FileWriter(f,true);
						fw.write(et);
						fw.flush();
						fw.close();
						
					} catch (IOException q) {
						q.printStackTrace();
					}
				
				else
					st.append("파일이 이미 존재합니다.\n");
				
			}
			
			else if(b.getText().equals("Run Program")) {
				if(CR == 0) {
					File file = new File(FileName);
					String fname = file.getName();
					String path = file.getParent();
					int pos = fname.lastIndexOf(".");
					if(pos > 0) {
						fname = fname.substring(0, pos);
					}
					List<String> cmds = Arrays.asList("cmd", "/c", "cd", path, "&&", "java", fname);
					try {
						String s;
						Process rProcess = new ProcessBuilder(cmds).start();
						BufferedReader stdOut = new BufferedReader(new InputStreamReader(rProcess.getInputStream()));
						BufferedReader stdError = new BufferedReader(new InputStreamReader(rProcess.getErrorStream()));
						st.append(FileName + " 가 실행중\n");
						while ((s = stdOut.readLine()) != null) { 
							er.append(s);
							er.append("\n");
						}
						while ((s = stdError.readLine()) != null) {
							er.append(s);
							er.append("\n");
						}
						System.out.print(path);
					} catch(IOException e2) {
						st.append("치명적 에러");
					}
					b.setVisible(true);
				}
			 else if(CR == 1) {
				st.append("파일이 업로드 되지 않았거나, 컴파일이 안됨\n");
				btn3.setEnabled(false);
			}
				
			}
			    //void Run();
			else if(b.getText().equals("Compile Error List")) {
				FileReader reader = null;
				try {
					reader = new FileReader("C:\\Temp\\Error_File.txt");
					int c;
					while((c = reader.read()) != -1) {
						er.append(Character.toString((char)c));
					}
					er.append("\n");
					
					reader.close();
				}
				catch(IOException w) {
					System.out.println("Error!");
				}
			}
			    //void Compile_E();
			else if(b.getText().equals("Reset")) {
				ja.setText("Editor\n");
				jt.setText("File Directory");
				st.setText("Status\n");
				er.setText("Error Message, Result\n");
				sf.setText("Save File Title");
				st.append("초기화 되었습니다");
				ja.setText("");
				E_file.delete();
			}
			    //void Reset();
			else if(b.getText().equals("Exit")) {
				E_file.delete();
				System.exit(0);
			}
			    		
		}
		
	}
	
	public static void main(String[] args) {
		new TermProject();
	}

}
