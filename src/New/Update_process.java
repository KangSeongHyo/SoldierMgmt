package New;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Update_process {
	
	
	public Update_process(Connection con1,int id,String age,String name,String join) throws SQLException, ParseException{
		
		String sql="";
		
		String updateName="UPDATE Soldier SET name=? WHERE id=?";
		String updateAge="UPDATE Soldier SET age=? WHERE id=?";
		
		
		String updatejoinDate="UPDATE Soldier SET join_date=?, discharge_date=?, rank=? WHERE id=?";
		
		if (!age.equals("")){ 
			sql=updateAge;
			PreparedStatement pst=con1.prepareStatement(sql);
			pst.setInt(2, id);
			pst.setInt(1, Integer.parseInt(age));
			int insertRow=pst.executeUpdate();
			System.out.println(insertRow+"나이 수정성공!");
		  }
		
	       if (!join.equals("")) { 
			
		    sql=updatejoinDate;
			PreparedStatement pst2=con1.prepareStatement(sql);
			pst2.setInt(4, id);
			
			pst2.setString(1, join);
			
			pst2.setString(2, Register_process.calculateDischargeDate(join));
			
			SimpleDateFormat dt=new SimpleDateFormat("yyyyMMdd");
			
			Date d1=new Date();
			String today=dt.format(d1);
			
			pst2.setString(3, Register_process.getRank(join, today));
			
			int insertRow=pst2.executeUpdate();
			System.out.println(insertRow+"입대일 수정성공!");
	       }
	       
			
		   if (!name.equals("")) { 
			sql=updateName;
			PreparedStatement pst3=con1.prepareStatement(sql);
			pst3.setInt(2, id);
			pst3.setString(1, name);
			int insertRow=pst3.executeUpdate();
			System.out.println(insertRow+"이름 수정성공!");
		  }
			
	}
	
	
	

}
