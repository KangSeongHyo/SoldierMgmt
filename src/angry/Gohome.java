package angry;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import java.awt.Font;
import java.sql.Connection;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;

public class Gohome extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction_1();


	public Gohome(Connection con1,String name) {
		setTitle("\uB0B4\uAC00\uC9D5\uACC4\uC704\uAE30");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gohome.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-error@2x.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 281);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(107, 142, 35));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel(name+"\uC774(\uAC00)");
		lblNewLabel.setFont(new Font("휴먼편지체", Font.PLAIN, 48));
		lblNewLabel.setBounds(26, 34, 340, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD0C8\uC601\uD588\uC2B5\uB2C8\uB2E4.");
		lblNewLabel_1.setFont(new Font("휴먼편지체", Font.PLAIN, 48));
		lblNewLabel_1.setBounds(108, 105, 289, 65);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setBounds(121, 191, 135, 23);
		contentPane.add(btnNewButton);
		
		/*try {
		    Thread.sleep(1000);
		}catch(InterruptedException e){
		    System.out.println(e.getMessage()); //sleep 메소드가 발생하는 InterruptedException
		}*/
		
		setVisible(true);
	}

	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "잡으러가기");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}
