package New;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {
	private static Connection con1;
	
	

	public static void main(String[] args) throws SQLException, ParseException {
		con1=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클 드라이브로 올림
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		con1= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr"); //db 접속
		
		Authority a=new Authority(con1);
	
		
	}

}