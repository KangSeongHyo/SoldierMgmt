package New;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Call extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private final Action action_1 = new SwingAction_1();
	private static Connection con1;
	private static int author;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Call(Connection con1,int author) throws SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Call.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		this.con1=con1;
		this.author=author;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 678);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(34, 139, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String colNames[]={"군번","이름","나이","계급","입대일","전역일","등록일","주특기번호"};
		
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.setBounds(372, 601, 97, 23);
		contentPane.add(btnNewButton_1);
		
			
			table = new JTable(Call_process.process(con1),colNames);
			table.getColumn("군번").setPreferredWidth(50);
			table.getColumn("이름").setPreferredWidth(50);
			table.getColumn("나이").setPreferredWidth(50);
			table.getColumn("계급").setPreferredWidth(50);
			table.getColumn("입대일").setPreferredWidth(50);
			table.getColumn("전역일").setPreferredWidth(50);
			table.getColumn("등록일").setPreferredWidth(50);
			table.getColumn("주특기번호").setPreferredWidth(50);
          DefaultTableCellRenderer dtcr= new DefaultTableCellRenderer();
          dtcr.setHorizontalAlignment(SwingConstants.CENTER);
          TableColumnModel tcm=table.getColumnModel();

  		  for(int i=0; i<tcm.getColumnCount(); i++){
  			tcm.getColumn(i).setCellRenderer(dtcr);
  		   }
          
			table.setBackground(Color.WHITE);
			table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GREEN, null));
			table.setBounds(35, 42, 774, 542);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setSize(825, 571);	
			scrollPane.setLocation(12, 10);
			scrollPane.setPreferredSize(new Dimension(369, 203));
			getContentPane().add(scrollPane);
			
			
			setTitle("조회");
		
		setVisible(true);
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
