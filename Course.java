import Logger.SystemLog;
public class Course {
	boolean theory,lab;
	int count=0,j=0;
	String name;
	TheoryOption[] theorys=new TheoryOption[60];
	TheoryOption[] labs=new TheoryOption[60];
	public Course(String a)
	{
		this.name=a;
	}
	public Course()
	{
	}
	int add(TheoryOption option,int a)
	{
		option.course=this.name;
		if(a==0)//to add theory slot
		{
			theorys[count]=option;
			count++;
		}
		else//to add lab slot
		{
			labs[j]=option;
			j++;
		}
		return 0;
	}
}
