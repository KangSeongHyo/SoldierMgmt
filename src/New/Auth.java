package New;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.xml.crypto.dsig.CanonicalizationMethod;

public class Auth {

	public static int auth(String id,String pw) throws FileNotFoundException{
	
		int ch=0;
		String check = null;
		String idd=null;
		String ipw=null;
		
	   Scanner sc=new Scanner(new FileReader("list.txt")); // scanner�� ���� �ҷ�����
		while(sc.hasNextLine()){
	    idd=sc.nextLine();
		 ipw=sc.nextLine();
		check=sc.nextLine();
		if(idd.compareTo(id)==0 && ipw.compareTo(pw)==0){ch=1; break;}
		ch=0;
		
		// ����Ʈ�� ���̵� �н����� �ޱ� �� ���� �ޱ�
		}
		
			if(check.charAt(0)=='a' && ch==1){
				   return 0;   // �����ڸ� 0����
			}
			else if(check.charAt(0)=='g' && ch==1){
				   return 1; // �Խ�Ʈ�� 1����
			}
			else
				return -1;
	
	}
	
	
}
