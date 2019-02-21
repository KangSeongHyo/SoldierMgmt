package New;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Delete extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private static Connection con1;
	private static int author;
	private final Action action_1 = new SwingAction_1();
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public Delete(Connection con1,int author) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Delete.class.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Cut-Black@2x.png")));
		setTitle("\uC0AD\uC81C");
		setBackground(new Color(34, 139, 34));
		this.con1=con1;
		this.author=author;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 268);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(107, 142, 35));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setBounds(61, 155, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(202, 155, 97, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(121, 107, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\uC0AD\uC81C\uD560 \uAD70\uBC88\uC744 \uC785\uB825\uD558\uC138\uC694");
		lblNewLabel.setFont(new Font("휴먼편지체", Font.PLAIN, 23));
		lblNewLabel.setBounds(61, 47, 238, 49);
		contentPane.add(lblNewLabel);
		
		setVisible(true);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "삭제");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			try {
				int id=Integer.parseInt(textField.getText());
				Delete_process kk= new Delete_process(con1,id);
				System.out.println("삭제되었습니다");
				textField.setText("");
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
			
			Menu a=new Menu(con1,author);
			dispose();
			
		}
	}
}
