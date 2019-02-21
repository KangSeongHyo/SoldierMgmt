package New;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Call_process {
	
	public static String[][] process(Connection con1) throws SQLException {
		
		
		 String prt="select * from Soldier";
		 String prt2="select count(*) from Soldier";
		  
		 int k=0;
		 int i=0;
		 int j=0;
		
		   Statement statement2=con1.createStatement();
		   ResultSet res2=statement2.executeQuery(prt2);
		   while(res2.next()){
		     k=res2.getInt("count(*)");
		   }   
		   
		  String lis[][]=new String[k][8];
		   
		   
		   Statement statement=con1.createStatement();
		   ResultSet res=statement.executeQuery(prt);
		     
		   while(res.next()){  
			   
			   int fid=res.getInt("id");
			     lis[i][j]=fid+""; j++;
	          String fname=res.getString("name");
				 lis[i][j]=fname;j++;
				int fage=res.getInt("age");
				 lis[i][j]=fage+""; j++;
			    String frank=res.getString("rank");
			    lis[i][j]=frank;j++;
			    String fjoin_date=res.getString("join_date");
			    lis[i][j]=fjoin_date.substring(0, 10);j++;
			    String fdischarge_date=res.getString("discharge_date");
			    lis[i][j]=fdischarge_date.substring(0, 10);j++;
			    String reigster=res.getString("reigster");
			    lis[i][j]=reigster.substring(0, 10);j++; 
			    int depart=res.getInt("department");
			    lis[i][j]=depart+"";j=0;i++;
		   }

		  return lis;
		}
}
		
		
		
	
	
	
	

