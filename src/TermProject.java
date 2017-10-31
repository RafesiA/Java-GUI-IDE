import javax.swing.*;
import java.awt.*;

public class TermProject extends JFrame {
	public TermProject() {
		setTitle("Java IDE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 500);
		setVisible(true);
	}
	public void Buttons() {
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JButton("Java File Upload"));
		contentPane.add(new JButton("Compile"));
		contentPane.add(new JButton("Run Program"));
		setSize(100, 100);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		TermProject frame = new TermProject();
	}

}
