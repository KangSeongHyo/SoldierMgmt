package New;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.Action;
import java.awt.Toolkit;
import java.awt.Font;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	 private static int author;
	 private static Connection con1;
	 private static int id;
	/**
	 * Create the frame.
	 */
	public Update(Connection con1,int author,int id) {
		this.con1=con1;
		this.author=author;
		this.id=id;
		
		setTitle("\uC218\uC815");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Update.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 373);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(107, 142, 35));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(170, 107, 116, 21);
		textField.setText("");
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setText("");
		textField_1.setBounds(170, 152, 116, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setText("");
		textField_2.setBounds(170, 199, 116, 21);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("1.\uB098\uC774");
		lblNewLabel.setBounds(85, 110, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("2.\uC774\uB984");
		lblNewLabel_1.setBounds(85, 155, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("3.\uC785\uB300\uC77C");
		lblNewLabel_2.setBounds(85, 202, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(65, 269, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(230, 269, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("\uC218\uC815\uD560 \uBD80\uBD84\uB9CC \uC785\uB825\uD558\uC138\uC694!!");
		lblNewLabel_3.setFont(new Font("휴먼편지체", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(52, 51, 293, 30);
		contentPane.add(lblNewLabel_3);
		
		setVisible(true);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "수정");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			String age=textField.getText();
			String name=textField_1.getText();
			String join=textField_2.getText();
			
			try {
				try {
					Update_process update_process=new Update_process(con1,id,age,name,join);
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "뒤로가기");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			Update_frist update_frist=new Update_frist(con1, author);
			dispose();
		}
	}
}
