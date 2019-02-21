package angry;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Angry extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private JTextField textField;
	private JTextField textField_1;
	 private static int author;
	 private static Connection con1;
	 private static int id;
	 private JTextField textField_2;
	 String[] list=new String[4];
	 JCheckBox chckbxNewCheckBox,chckbxNewCheckBox_1,chckbxNewCheckBox_2;
	 JComboBox comboBox;
	 
	
	public Angry(Connection con1,int author,int id) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Angry.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		setTitle("\uC9D5\uACC4");
		
		this.author=author;
		this.con1=con1;
		this.id=id;
		 
		list=getlist(id);
			
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 283);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(107, 142, 35));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(480, 201, 97, 23);
		contentPane.add(btnNewButton_1);
		
		
		textField = new JTextField();
		textField.setBounds(31, 89, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 89, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("1.\uC774\uB984");
		label.setFont(new Font("굴림", Font.BOLD, 12));
		label.setBounds(31, 64, 57, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("2.\uC804\uC5ED\uC77C");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel.setBounds(194, 64, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("\uBD84\uB178\uC9C0\uC218");
		label_1.setFont(new Font("궁서", Font.PLAIN, 18));
		label_1.setForeground(new Color(220, 20, 60));
		label_1.setBounds(418, 10, 87, 23);
		contentPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(348, 89, 116, 21);
		contentPane.add(textField_2);
		
		JLabel label_2 = new JLabel("3. \uD734\uAC00\uC77C\uC218");
		label_2.setFont(new Font("굴림", Font.BOLD, 12));
		label_2.setBounds(348, 64, 84, 15);
		contentPane.add(label_2);
		
		chckbxNewCheckBox = new JCheckBox("\uD734\uAC00\uC81C\uD55C1\uC77C");
		chckbxNewCheckBox.setBackground(new Color(107, 142, 35));
		chckbxNewCheckBox.setBounds(31, 141, 115, 23);
		contentPane.add(chckbxNewCheckBox);
		
		chckbxNewCheckBox_1 = new JCheckBox("\uD734\uAC00\uC81C\uD55C3\uC77C");
		chckbxNewCheckBox_1.setBackground(new Color(107, 142, 35));
		chckbxNewCheckBox_1.setBounds(194, 141, 115, 23);
		contentPane.add(chckbxNewCheckBox_1);
		
		chckbxNewCheckBox_2 = new JCheckBox("\uD734\uAC00\uC81C\uD55C5\uC77C");
		chckbxNewCheckBox_2.setBackground(new Color(107, 142, 35));
		chckbxNewCheckBox_2.setBounds(348, 141, 115, 23);
		contentPane.add(chckbxNewCheckBox_2);
		
		
	      
			textField.setText(list[2]);
	        textField.setEditable(false);
			textField_1.setText(list[3]);
			 textField_1.setEditable(false);
			textField_2.setText(list[0]);
			 textField_2.setEditable(false);
			
			 JProgressBar progressBar = new JProgressBar();
			 progressBar.setForeground(new Color(255, 0, 0));
			 progressBar.setValue(Integer.parseInt(list[1]));
			 progressBar.setMaximum(100);
			 progressBar.setBounds(431, 43, 146, 14);
			contentPane.add(progressBar);
			
		
		
		
		JButton btnNewButton = new JButton("입력");
		btnNewButton.setAction(action);
		btnNewButton.setBounds(226, 201, 97, 23);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(chckbxNewCheckBox);
		bg.add(chckbxNewCheckBox_1);
		bg.add(chckbxNewCheckBox_2);
		
		contentPane.add(btnNewButton);
		
	    comboBox = new JComboBox();
		comboBox.setBounds(41, 202, 102, 21);
		
		comboBox.addItem("");
		comboBox.addItem("영창5일");
		comboBox.addItem("영창10일");
		comboBox.addItem("영창15일");
	
		contentPane.add(comboBox);
		

		
		setVisible(true);
		
		if(Integer.parseInt(list[1])>99){
		
			Gohome aa=new Gohome(con1,list[2]);
		}
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "입력");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			String sql="UPDATE Angry SET breakAvailable=?, angry_Index=? WHERE id="+id+"";
			
			//하나도 선택되지 않은 경우
			  if(chckbxNewCheckBox.isSelected())
			  {
				  
					try {
				    PreparedStatement pst= con1.prepareStatement(sql);
					pst.setInt(1, Integer.parseInt(list[0])-1);
						pst.setInt(2, Integer.parseInt(list[1])+1);
						pst.executeUpdate();
						
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				
				   
			  }
			  
			  if(chckbxNewCheckBox_1.isSelected())
			  {   
				  

					try {
				    PreparedStatement pst= con1.prepareStatement(sql);
					pst.setInt(1, Integer.parseInt(list[0])-3);
						pst.setInt(2, Integer.parseInt(list[1])+5);
						pst.executeUpdate();
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			
			  } 
			  if(chckbxNewCheckBox_2.isSelected())
			  {
			       
					try {
				    PreparedStatement pst= con1.prepareStatement(sql);
					pst.setInt(1, Integer.parseInt(list[0])-5);
						pst.setInt(2, Integer.parseInt(list[1])+10);
						pst.executeUpdate();
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
			  }
			  
			  
			  String sql2="UPDATE soldier SET discharge_date=? WHERE id="+id+"";
			  
			  
			  if(comboBox.getSelectedItem()=="영창5일"){
				  
				  try {
					    PreparedStatement pst2= con1.prepareStatement(sql2);
					    
					    String dt = list[3];  // Start date
					    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					    Calendar c = Calendar.getInstance();
					    c.setTime(sdf.parse(dt));
					    c.add(Calendar.DATE, 5);  // number of days to add
					    dt = sdf.format(c.getTime());
						pst2.setString(1,dt);
					    pst2.executeUpdate();
							
							
						} catch (NumberFormatException e1) {
							e1.printStackTrace();
						} catch (SQLException e1) {
							e1.printStackTrace();
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
			  }
			  
              if(comboBox.getSelectedItem()=="영창10일"){
				  
            	  try {
  				    PreparedStatement pst2= con1.prepareStatement(sql2);
  				  String dt = list[3];  // Start date
				    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				    Calendar c = Calendar.getInstance();
				    c.setTime(sdf.parse(dt));
				    c.add(Calendar.DATE, 10);  // number of days to add
				    dt = sdf.format(c.getTime());
					pst2.setString(1,dt);
				    pst2.executeUpdate();
						
				
						
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
			  }
              
               if(comboBox.getSelectedItem()=="영창15일"){
            	   try {
   				    PreparedStatement pst2= con1.prepareStatement(sql2);
   				    String dt = list[3];  // Start date
				    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				    Calendar c = Calendar.getInstance();
				    c.setTime(sdf.parse(dt));
				    c.add(Calendar.DATE, 15);  // number of days to add
				    dt = sdf.format(c.getTime());
					pst2.setString(1,dt);
				    pst2.executeUpdate();
						
						pst2.executeUpdate();
						
						
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
            	
			  }
			  
               
			  try {
				  
				 repaint(194, 89, 116, 21);
				Angry aa=new Angry(con1, author, id);
				dispose();
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
			Angry_frist  angry_frist=new Angry_frist(con1, author);
			dispose();
		}
	
	}
	
	public String[] getlist(int id) throws SQLException{
	
		 
		 String prt="select breakAvailable,angry_index from angry where id="+id+"";
		 String prt2="select name,discharge_date from soldier where id="+id+"";

		 
		 
		 String lis[]=new String[4];
		  
		  int i=0;
		   Statement statement1=con1.createStatement();
		   ResultSet res1=statement1.executeQuery(prt);
		  
		   Statement statement2=con1.createStatement();
		   ResultSet res2=statement2.executeQuery(prt2);
		     
		   while(res1.next()){  
			   
			   int fid=res1.getInt("breakAvailable");
			     lis[i]=fid+""; i++;
	          int fangry_index=res1.getInt("angry_index");
				 lis[i]=fangry_index+""; i++;
		   }

		   
          while(res2.next()){  
			   
        	     String fname=res2.getString("name");
			     lis[i]=fname; i++;
			   
			    String fdischarge_date=res2.getString("discharge_date");
			    lis[i]=fdischarge_date.substring(0, 10);
			   
		   }
		  return lis;
	}
}
