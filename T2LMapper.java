import java.util.StringTokenizer;
import java.util.ArrayList;
public class T2LMapper {
public String map(String a)//Converts theory slots into strings of format "1+2"
{
	String b =new String("");
	StringTokenizer st= new StringTokenizer(a,"+");
	while(st.hasMoreTokens())
	{
		String c=st.nextToken();
		if(c.equalsIgnoreCase("A1"))
		{	
			b=b+"+1+14";
		}
		else if(c.equalsIgnoreCase("A2"))
		{
			b=b+("+31+44");
		}
		else if(c.equalsIgnoreCase("B1"))
		{	
			b=b+"+7+20";
		}
		else if(c.equalsIgnoreCase("B2"))
		{
			b=b+("+37+50");
		}
		else if(c.equalsIgnoreCase("C1"))
		{	
			b=b+"+13+26";
		}
		else if(c.equalsIgnoreCase("C2"))
		{
			b=b+("+43+56");
		}
		else if(c.equalsIgnoreCase("D1"))
		{	
			b=b+"+3+19";
		}
		else if(c.equalsIgnoreCase("D2"))
		{
			b=b+("+33+49");
		}
		else if(c.equalsIgnoreCase("E1"))
		{	
			b=b+"+9+25";
		}
		else if(c.equalsIgnoreCase("E2"))
		{
			b=b+("+39+55");
		}
		else if(c.equalsIgnoreCase("F1"))
		{	
			b=b+"+2+15";
		}
		else if(c.equalsIgnoreCase("F2"))
		{
			b=b+("+32+45");
		}
		else if(c.equalsIgnoreCase("G1"))
		{	
			b=b+"+8+21";
		}
		else if(c.equalsIgnoreCase("G2"))
		{
			b=b+("+38+51");
		}
		if(c.equalsIgnoreCase("TA1"))
		{	
			b=b+"+27";
		}
		else if(c.equalsIgnoreCase("TA2"))
		{
			b=b+("+57");
		}
		else if(c.equalsIgnoreCase("TB1"))
		{	
			b=b+"+4";
		}
		else if(c.equalsIgnoreCase("TB2"))
		{
			b=b+("+34");
		}
		else if(c.equalsIgnoreCase("TC1"))
		{	
			b=b+"+10";
		}
		else if(c.equalsIgnoreCase("TC2"))
		{
			b=b+("+40");
		}
		else if(c.equalsIgnoreCase("TD1"))
		{	
			b=b+"+29";
		}
		else if(c.equalsIgnoreCase("TD2"))
		{
			b=b+("+46");
		}
		else if(c.equalsIgnoreCase("TE1"))
		{	
			b=b+"+22";
		}
		else if(c.equalsIgnoreCase("TE2"))
		{
			b=b+("+52");
		}
		else if(c.equalsIgnoreCase("TF1"))
		{	
			b=b+"+28";
		}
		else if(c.equalsIgnoreCase("TF2"))
		{
			b=b+("+58");
		}
		else if(c.equalsIgnoreCase("TG1"))
		{	
			b=b+"+5";
		}
		else if(c.equalsIgnoreCase("TG2"))
		{
			b=b+("+35");
		}
	}
	return b;
}
public int[] slotToArray(String a) {
int[] arr=new int[60];
StringTokenizer st = new StringTokenizer(a,"+");
int i=0;
while(st.hasMoreTokens())
{
	String c= st.nextToken();
	int d=Integer.parseInt(c);
	arr[i]=d;
	i++;
}
return arr;
}
}
