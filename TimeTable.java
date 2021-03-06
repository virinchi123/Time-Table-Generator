import java.util.*;
import Logger.SystemLog;
import java.io.*;
public class TimeTable {
Slot[] tt= new Slot[90];
ArrayList<Course> courses =new ArrayList<Course>();
public TimeTable(ArrayList<Course> courses)
{
	this.courses=courses;
	int i=0;
	//Slot c=new Slot(-1);
	for(i=0;i<90;i++)
	{
		tt[i]=new Slot(i);
	}
}
/*public int toggle(int n)//deprecated
{
	tt[n].toggle();
	return 0;
}*/
public boolean check(TheoryOption a)//Checks if it is possible to take a particular TheoryOption
{
	Iterator<Slot> iterator = a.option.iterator();
	Slot c = new Slot();//dummy number
	while(iterator.hasNext())
	{
		c=iterator.next();
		if(tt[c.number].taken)
		{
			return false;
		}
	}
	return true;
}
public void addCourse(Course a)//adds a course
{
	courses.add(a);
}
public boolean darken(Slot a,String name) throws IOException//marks a slot as taken
{
	try {
	SystemLog log=new SystemLog("C:\\xampp\\htdocs\\log.txt");
	log.log("Darkening "+a.number);
	this.tt[a.number].taken=true;
	this.tt[a.number].course=name;
	return true;
	}catch(IOException e)
	{
		System.out.println(e);
		return false;
	}
}
public boolean darken(TheoryOption a) throws IOException//marks a TheoryOption as taken
{
	try {
	if(!this.check(a))
	{
		return false;//check this
	}
	Iterator<Slot> iterator=a.option.iterator();
	while (iterator.hasNext())
	{
		Slot slot=iterator.next();
		this.darken(slot,a.course);
	}
	return true;
	}catch(IOException e)
	{
		System.out.println(e);
		return false;
	}
}
public boolean whiten(Slot a,String name) throws IOException//marks a slot as free
{
	try {
	SystemLog log=new SystemLog("C:\\xampp\\htdocs\\log.txt");
	log.log("Whitening "+a.number);
	this.tt[a.number].taken=false;
	this.tt[a.number].course=name;
	return true;
	}catch(IOException e)
	{
		System.out.println(e);
		return false;
	}
}
public boolean whiten(TheoryOption a) throws IOException//marks a TheoryOption as free
{
	try {
	if(!this.check(a))
	{
		return false;//check this
	}
	Iterator<Slot> iterator=a.option.iterator();
	while (iterator.hasNext())
	{
		Slot slot=iterator.next();
		this.whiten(slot,a.course);
	}
	return true;
	}catch(IOException e)
	{
		System.out.println(e);
		return false;
	}
}
public boolean plop(Course a) throws IOException// not used
{
	Iterator<Course> CourseIterator = this.courses.iterator();
	while(CourseIterator.hasNext())
	{
		Course CurrentCourse = CourseIterator.next();
		int count=0,j=0;
		while(!check(CurrentCourse.theorys[count]))
		{
			count++;
			if(count>CurrentCourse.count)
			{
				break;
			}
		}
		darken(CurrentCourse.labs[j]);
		while(!check(CurrentCourse.labs[j]))
		{
			count++;
			if(j>CurrentCourse.j)
			{
				break;
			}
		}
		darken(CurrentCourse.theorys[j]);
	}
	return true;
}
public boolean fit(Course a) throws IOException
{
	try {
	SystemLog log = new SystemLog("C:\\xampp\\htdocs\\log.txt");
	log.log("fit function entered for course "+a.name);
	int l=0,m=0,x=0,y=0;
	while(x<a.count)
	{
		if(this.check(a.theorys[x]))
		{
			this.darken(a.theorys[x]);
			l=1;
			break;
		}
		x++;
	}
	if(l==0)
	{
		return false;
	}
	while(y<a.j)
	{
		if(this.check(a.labs[y]))
		{
			this.darken(a.labs[y]);
			m=1;
			break;
		}
		y++;
	}
	if(m==0)
	{
		return false;
	}
	return true;
	}
	catch(IOException e)
	{
		System.out.println(e);
		return false;
	}
}
public void print() throws IOException
{
	try {
	SystemLog log=new SystemLog("C:\\xampp\\htdocs\\log.txt");
	log.log("Print function executed");
	String str=new String();
	String OutputFilePath = new String("C:\\xampp\\htdocs\\output.txt");
	File OutputFile=new File(OutputFilePath);
	log.log("File object created");
	if(OutputFile.exists()==false)
	{
		System.out.println("Creating output file...");
		log.log("Creating output file with path "+OutputFilePath);
		OutputFile.createNewFile();
		System.out.println("Output file created.");
		log.log("Output file created at "+OutputFilePath);
	}
	FileWriter fl = new FileWriter(OutputFile,true);
	for(int i=1;i<=60;i++)
	{
		if(tt[i].taken)
		{
			str=i+" "+tt[i].course+"\r\n";
			fl.write(str);
		}
		else
		{
			str=i+"\r\n";
			fl.write(str);
		}
	}
	fl.write("---------------------------------------------------------------------------------------------\r\n");
	fl.close();
	}
	catch(IOException e)
	{
		System.out.println(e);
	}
}
public boolean plops(int i) throws IOException
{
	try {
	if(i==0)
	{
	SystemLog log = new SystemLog("C:\\xampp\\htdocs\\log.txt");
	Iterator<Course> CourseIterator = this.courses.iterator();
	while(CourseIterator.hasNext())
	{
		Course course=CourseIterator.next();
		log.log("going to fit "+course.name);
			this.fit(course);
			log.log("inside plops method");
			if(CourseIterator.hasNext()==false)
			{
				this.print();
			}
	}
	}
	return true;
	}
	catch(IOException e)
	{
		System.out.println(e);
		return false;
	}
}
}
