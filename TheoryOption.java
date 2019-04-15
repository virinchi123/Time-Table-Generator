import java.util.*;
import java.io.*;
import Logger.SystemLog;
public class TheoryOption {
ArrayList<Slot> option = new ArrayList<Slot>();
String course;
public TheoryOption() {
	
}
public TheoryOption(String a) throws IOException//takes string of format "1+2"
{
	try {
	StringTokenizer st = new StringTokenizer(a,"+");
	while(st.hasMoreTokens())
	{
		String b=st.nextToken();
	//	System.out.println(b);
		int c=Integer.parseInt(b);
		Slot x=new Slot(c);
		option.add(x);
		SystemLog log= new SystemLog("C:\\xampp\\htdocs\\log.txt");
		log.log(c+" added to theory option");
	}
	}catch(IOException e)
	{
		System.out.println(e);
	}
}
}
