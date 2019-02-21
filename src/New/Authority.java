package New;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.Action;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Authority extends JDialog {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	private final Action action = new SwingAction();
	private static Connection con1;
	private static int author;

	public Authority(Connection con1) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Authority.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));

		this.con1 = con1;

		setBounds(100, 100, 465, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 0));
		contentPane.setForeground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(107, 267, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(107, 298, 116, 21);
		contentPane.add(passwordField);

		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(38, 270, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638\r\n");
		label.setBounds(38, 301, 57, 15);
		contentPane.add(label);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setBounds(270, 281, 97, 23);
		contentPane.add(btnNewButton);

		JLabel label_1 = new JLabel("       \uAD70\uC778 \uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		label_1.setFont(new Font("휴먼편지체", Font.BOLD | Font.ITALIC, 24));
		label_1.setBounds(175, 45, 399, 78);
		contentPane.add(label_1);
		ImageIcon img= new ImageIcon(".\\pic.png");
		
		JLabel lblNewLabel_1 = new JLabel(new ImageIcon("C:\\login.png"));
		
		
		lblNewLabel_1.setBounds(0, 10, 399, 350);
		contentPane.add(lblNewLabel_1);
		
		
        setTitle("시작하기");
		setVisible(true);
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	private class SwingAction extends AbstractAction {

		public SwingAction() {
			putValue(NAME, "로그인");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
			int temp;
			
				 try {
					temp= Auth.auth(textField.getText(), passwordField.getText());
					 author=temp;
					 
					 dispose();
					 if(author==0 || author==1){
						 
						 Menu a=new Menu(con1,author);
					 }
					 else{
					  Err n=new Err();
					 }
					  
					 
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
		}
	}
}
			
		
