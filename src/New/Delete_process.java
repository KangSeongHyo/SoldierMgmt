package New;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete_process  {

	public Delete_process(Connection con1,int id) throws SQLException {
		  
		  int ids=id;
	       
		 String sq="delete from Soldier where id=?";
	       
	       PreparedStatement pst2=con1.prepareStatement(sq); // ? ó��
	     
	       pst2.setInt(1, ids); 
		    pst2.executeUpdate();  // id ���� 
		    
		    
			String sql1="delete from Angry where id=?"; 
			PreparedStatement pst3=con1.prepareStatement(sql1);
			
			 pst3.setInt(1, ids); 
			    pst3.executeUpdate(); 
		
	}

}
