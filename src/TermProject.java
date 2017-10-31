import javax.swing.*;
import java.awt.*;

public class TermProject extends JFrame {
	public TermProject() {
		setTitle("Java IDE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new GridLayout(3, 2, 600, 0));
		contentPane.add(new JButton("Java File Upload"));
		contentPane.add(new JButton("Compile"));
		contentPane.add(new JButton("Run Program"));
		contentPane.add(new JButton("Compile Error List"));
		contentPane.add(new JButton("Reset"));
		contentPane.add(new JButton("Exit"));
		
		setSize(1000, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		TermProject frame = new TermProject();
	}

}
