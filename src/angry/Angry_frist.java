package angry;
import New.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.Toolkit;

public class Angry_frist extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	 private static int author;
	 private static Connection con1;

	public Angry_frist(Connection con1,int author) {
		this.author=author;
		this.con1=con1;
		
		setTitle("\uC9D5\uACC4");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Update_frist.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-warning@2x.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 201);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(107, 142, 35));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(99, 79, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uC9D5\uACC4\uD560 \uC0AC\uB78C\uC758 \uAD70\uBC88\uC744 \uC785\uB825\uD558\uC138\uC694");
		lblNewLabel.setFont(new Font("휴먼편지체", Font.PLAIN, 18));
		lblNewLabel.setBounds(42, 29, 256, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setBounds(42, 119, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(184, 119, 97, 23);
		contentPane.add(btnNewButton_1);
		setVisible(true);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "확인");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			int id=Integer.parseInt(textField.getText());
			try {
				Angry aa= new Angry(con1,author,id);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "뒤로가기");
			putValue(SHORT_DESCRIPTION, "Some short description");
			
		}
		public void actionPerformed(ActionEvent e) {
			Menu a=new Menu(con1,author);
			dispose();
		}
	}
}

