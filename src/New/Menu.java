package New;
import angry.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.Action;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class Menu extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
    private static int author;
    private static Connection con1;
    private final Action action_4 = new SwingAction_4();

	/**
	 * Create the frame.
	 */
	public Menu(Connection con1,int author) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/com/sun/java/swing/plaf/windows/icons/ListView.gif")));
		this.author=author;
		this.con1=con1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 375);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 51));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPress = new JButton("Press");
		btnPress.setFont(new Font("휴먼편지체", Font.PLAIN, 14));
		btnPress.setSelectedIcon(new ImageIcon("C:\\Users\\student\\workspace\\T_proje\\\uB4F1\uB85D\uC5D0\uCD1D.png"));
		btnPress.setIcon(new ImageIcon("C:\\Users\\student\\workspace\\T_proje\\\uBC84\uD2BC1.png"));
		btnPress.setAction(action);
		btnPress.setBounds(98, 43, 97, 23);
		contentPane.add(btnPress);
		
		JButton btnPress_1 = new JButton("Press");
		btnPress_1.setFont(new Font("휴먼편지체", Font.PLAIN, 14));
		btnPress_1.setAction(action_1);
		btnPress_1.setBounds(12, 134, 97, 23);
		contentPane.add(btnPress_1);
		
		JButton btnPress_2 = new JButton("Press");
		btnPress_2.setFont(new Font("휴먼편지체", Font.PLAIN, 14));
		btnPress_2.setAction(action_2);
		btnPress_2.setBounds(49, 86, 97, 23);
		contentPane.add(btnPress_2);
		
		JButton btnPress_3 = new JButton("Press");
		btnPress_3.setFont(new Font("휴먼편지체", Font.PLAIN, 14));
		btnPress_3.setAction(action_3);
		btnPress_3.setBounds(375, 284, 97, 23);
		contentPane.add(btnPress_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\\uB2F9\uC9C1\uC911.png"));
		lblNewLabel_1.setBounds(111, 90, 267, 237);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\uC9D5\uACC4");
		btnNewButton.setFont(new Font("휴먼편지체", Font.PLAIN, 14));
		btnNewButton.setAction(action_4);
		btnNewButton.setBounds(49, 177, 84, 35);
		contentPane.add(btnNewButton);
		 setTitle("메뉴");
		setVisible(true);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(LARGE_ICON_KEY, new ImageIcon("C:\\\uB4F1\uB85D\uC5D0\uCD1D.png"));
			putValue(NAME, "\uB4F1\uB85D");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			if(author==0){
				Register re=new Register(con1,author);
				dispose();
			}
			else{
				System.out.println("권한이 없습니다.");
				Menu a=new Menu(con1,author);
				dispose();
			}
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "\uC218\uC815");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if(author==0){
			Update_frist update_frist=new Update_frist(con1,author);
			dispose();
			}
			else{
				System.out.println("권한이 없습니다.");
				Menu a=new Menu(con1,author);
				dispose();
			}
			
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "\uC0AD\uC81C\r\n");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if(author==0){
				Delete re=new  Delete(con1,author);
				dispose();
			}
			
			else{
				System.out.println("권한이 없습니다.");
				Menu a=new Menu(con1,author);
				dispose();
			}
			
			
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "\uC870\uD68C");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			try {
				Call a=new Call(con1, author);
				dispose();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "징계");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			if(author==0){
			Angry_frist aa=new Angry_frist(con1, author);
			dispose();
			}
			else{
				System.out.println("권한이 없습니다.");
				Menu a=new Menu(con1,author);
				dispose();
			}
			
		}
	}
}
