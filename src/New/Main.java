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
			Class.forName("oracle.jdbc.driver.OracleDriver"); //����Ŭ ����̺�� �ø�
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		con1= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr"); //db ����
		
		Authority a=new Authority(con1);
	
		
	}

}