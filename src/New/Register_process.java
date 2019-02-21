package New;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Register_process {
	
	
	public int getDepartment() {
		ArrayList<Integer> al=new ArrayList<Integer>();
		
		//주특기 번호를 미리 저장해놈
		al.add(1111); al.add(1112); al.add(1113); al.add(1114); al.add(1119); al.add(1121);
		al.add(1121); al.add(1122); al.add(1123); al.add(1124); al.add(1125); al.add(1126);
		al.add(1127); al.add(1131); al.add(1132); al.add(1133); al.add(1135); al.add(1134);
		al.add(1136); //총 19개: 즉 al.get(0) ~ al.get(18)
		
		return (al.get((int)Math.ceil(Math.random()*17)));
	}
	
	public static String getRank(String join,String today) throws ParseException{
		String rank;
		
		String str=join;
		SimpleDateFormat jo=new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat ds=new SimpleDateFormat("yyyyMMdd");
		
		Date d1=jo.parse(join);
		Date d2=ds.parse(today);
		
		int sub=(int)((d1.getTime()-d2.getTime())/(1000*60*60*24));

		if(sub>540){			
			rank="이등병";
		}
		
		else if(sub>290){
			rank="일병";
		}
		
		else if(sub>100){
		    rank="상병";
			
		}
		else{
			rank="병장";
			
		}
			
		
		return rank;
	}
	
	
		public static String calculateDischargeDate (String join_date) throws ParseException {
			String str=join_date;
			SimpleDateFormat dt=new SimpleDateFormat("yyyyMMdd");
			Date d1=dt.parse(str);
			d1.setDate(d1.getDate()+638-1);
			String transDate=dt.format(d1);
			
			return transDate;
		}
		
		public String getToday() {
			SimpleDateFormat dt=new SimpleDateFormat("yyyyMMdd");
			Date d1=new Date();
			String today=dt.format(d1);
			
			return today;
		}
		
		public Register_process(Connection con1,int id,String name,int age,String join_date) throws SQLException, ParseException {
		
			String sql2="INSERT INTO Soldier VALUES(?, ?, ?, ?, ?, ?, ?, ?)"; 
			PreparedStatement pst=con1.prepareStatement(sql2);
			
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setInt(3, age);
				
			pst.setString(5, join_date);
			
			String discharge_date=calculateDischargeDate(join_date);
			pst.setString(6, discharge_date);
			
			
			String reigster=getToday();
			pst.setString(7, reigster);
			
			String rank=getRank(discharge_date, reigster);
			pst.setString(4,rank);

			int department=getDepartment();
			pst.setInt(8, department);
			
			pst.executeUpdate();
		
			String sql1="INSERT INTO Angry VALUES(?, ?, ?)"; 
			PreparedStatement pst2=con1.prepareStatement(sql1);
			
			pst2.setInt(1, id);
			pst2.setInt(2, 45);
			pst2.setInt(3, 70);
			
			pst2.executeUpdate();
			
		}

}
