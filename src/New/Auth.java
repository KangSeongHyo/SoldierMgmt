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
		
	   Scanner sc=new Scanner(new FileReader("list.txt")); // scanner로 파일 불러오기
		while(sc.hasNextLine()){
	    idd=sc.nextLine();
		 ipw=sc.nextLine();
		check=sc.nextLine();
		if(idd.compareTo(id)==0 && ipw.compareTo(pw)==0){ch=1; break;}
		ch=0;
		
		// 리스트의 아이디 패스워드 받기 와 권한 받기
		}
		
			if(check.charAt(0)=='a' && ch==1){
				   return 0;   // 관리자면 0리턴
			}
			else if(check.charAt(0)=='g' && ch==1){
				   return 1; // 게스트면 1리턴
			}
			else
				return -1;
	
	}
	
	
}
