package New;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JEditorPane;
import javax.swing.Box;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private final Action action = new SwingAction();
    private static Connection con1;
    private JButton btnNewButton_1;
    private final Action action_1 = new SwingAction_1();
    private int author;
    private JLabel lblNewLabel_1;
	
	public Register(Connection con1,int author) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/com/sun/javafx/scene/web/skin/AlignLeft_16x16_JFX.png")));
		this.con1=con1;
		this.author=author;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 309, 374);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(92, 46, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(92, 96, 116, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(92, 146, 116, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(92, 194, 116, 21);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel = new JLabel("1.\uAD70\uBC88");
		lblNewLabel.setBounds(23, 49, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("2.\uC774\uB984");
		label.setBounds(23, 99, 57, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("3.\uB098\uC774");
		label_1.setBounds(23, 149, 57, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("4.\uC785\uB300\uC77C");
		label_2.setBounds(23, 200, 57, 15);
		contentPane.add(label_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(23, 271, 97, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(169, 271, 97, 23);
		contentPane.add(btnNewButton_1);
		
		/*lblNewLabel_1 = new JLabel("New label");
		ImageIcon ii = new ImageIcon(this.getClass().getResource("C:\\Users\\student\\workspace\\T_proje\\\uB4F1\uB85D.gif"));
        lblNewLabel_1.setIcon(ii);
        
        contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBounds(364, 106, 110, 100);*/
		
		
		
		setTitle("등록");
		setLocationRelativeTo(null);
		setVisible(true);

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "입력");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			try {
				int id=Integer.parseInt(textField.getText());
				String name=textField_1.getText();
				int age=Integer.parseInt(textField_2.getText());
				 //계급
				String join =textField_3.getText();
				
				Register_process a= new Register_process(con1,id,name,age,join);
				System.out.println("등록되었습니다.");
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				
			
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "\uB4A4\uB85C\uAC00\uAE30");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			
			Menu a=new Menu(con1,author);
			dispose();
			
		}
	}
}
