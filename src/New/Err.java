package New;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Err extends JFrame {

	private JPanel contentPane;

	public Err() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 215);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("※오류※");
		
		JLabel label = new JLabel("\uACC4\uC815\uC774 \uC5C6\uC2B5\uB2C8\uB2E4.");
		label.setFont(new Font("휴먼편지체", Font.PLAIN, 27));
		label.setBounds(80, 54, 205, 48);
		contentPane.add(label);
		
		
		setVisible(true);

	
		try {
		    Thread.sleep(1000);
		}catch(InterruptedException e){
		    System.out.println(e.getMessage()); //sleep 메소드가 발생하는 InterruptedException
		}

	
		
	}

}
