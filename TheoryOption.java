import java.util.*;
public class TheoryOption {
ArrayList<Slot> option = new ArrayList<Slot>();
String course;
public TheoryOption() {
	
}
public TheoryOption(String a)//takes string of format "1+2"
{
	StringTokenizer st = new StringTokenizer(a,"+");
	while(st.hasMoreTokens())
	{
		String b=st.nextToken();
	//	System.out.println(b);
		int c=Integer.parseInt(b);
		Slot x=new Slot(c);
		option.add(x);
	}
}
}
