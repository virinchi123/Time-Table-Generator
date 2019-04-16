import java.io.BufferedReader;
import Logger.SystemLog;
import java.io.FileReader;
import java.io.*;
import java.util.*;
public class Parser {
public static void main(String args[]) throws IOException
{
	String ReadPath=new String("C:\\xampp\\htdocs\\test\\testfile.txt");//Input file path
	FileReader read = new FileReader(ReadPath);
	BufferedReader br = new BufferedReader(read);
	ArrayList<Course> courses = new ArrayList<Course>();
	SystemLog log = new SystemLog("C:\\xampp\\htdocs\\log.txt");
	while(br.ready())
	{
	String a=br.readLine();
	int IterationNumber=0;
	System.out.println(a);
	Course course = new Course();
	StringTokenizer st1 = new StringTokenizer(a,"?");
	while(st1.hasMoreTokens())
	{
		String b=st1.nextToken();
		if(IterationNumber==0)//Reads course name
		{
			course.name=b;
		}
		else if(IterationNumber==1)//Reads Theory Options
		{
			StringTokenizer st2 = new StringTokenizer(b,";");
			while(st2.hasMoreTokens())
			{
				String x=st2.nextToken();
				T2LMapper mapper = new T2LMapper();
				TheoryOption theory=new TheoryOption(mapper.map(x));
				course.add(theory, 0);
			}
		}
		else if(IterationNumber==2)//reads Lab options
		{
			StringTokenizer st2 = new StringTokenizer(b,";");
			while(st2.hasMoreTokens())
			{
				String x=st2.nextToken();
				TheoryOption lab=new TheoryOption(x);
				course.add(lab, 1);
			}
		courses.add(course);
		log.log("Adding course "+course.name+" to course list");
		}
		IterationNumber++;
	}

	}
	/*Iterator<Course> iterator = courses.iterator();
	while(iterator.hasNext())//debugging code to print out list of courses in course list
	{
		Course as =iterator.next();
		System.out.println(as.name);
	}*/
	br.close();
	TimeTable time=new TimeTable(courses);
	time.plops(0);
}
}
