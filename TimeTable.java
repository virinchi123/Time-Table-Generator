import java.util.*;
import java.io.*;
public class TimeTable {
Slot[] tt= new Slot[90];
ArrayList<Course> courses =new ArrayList<Course>();
public TimeTable(ArrayList<Course> courses)
{
	this.courses=courses;
	int i=0;
	Slot c=new Slot(-1);
	for(i=0;i<90;i++)
	{
		tt[i]=c;
	}
}
public int toggle(int n)
{
	tt[n].toggle();
	return 0;
}
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
public int addCourse(Course a)
{
	courses.add(a);
	return 0;
}
public int darken(Slot a,String name)//marks a slot as taken
{
	this.tt[a.number].taken=true;
	this.tt[a.number].course=name;
	return 0;
}
public int darken(TheoryOption a)//marks a TheoryOption as taken
{
	if(!this.check(a))
	{
		return 1;
	}
	Iterator<Slot> iterator=a.option.iterator();
	while (iterator.hasNext())
	{
		Slot slot=iterator.next();
		this.darken(slot,a.course);
	}
	return 0;
}
public int whiten(TheoryOption a)//marks a TheoryOption as free
{
	Iterator<Slot> iterator=a.option.iterator();
	while (iterator.hasNext())
	{
		Slot slot=iterator.next();
		this.whiten(slot);
	}
	return 0;
}
public int whiten(Slot a)//marks a slot as free
{
	this.tt[a.number].taken=false;
	return 0;
}
public int plop(Course a)
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
	return 0;
}
public boolean fit(Course a)
{
	System.out.println("hi");
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
		if(this.check(a.theorys[y]))
		{
			this.darken(a.theorys[y]);
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
public void print() throws IOException
{
	System.out.println("hit");
	String str=new String();
	FileWriter fl = new FileWriter("C:\\xampp\\htdocs\\test\\output.txt");
	for(int i=1;i<=60;i++)
	{
		if(tt[i].taken)
		{
			str=i+" "+tt[i].course+"\n";
			fl.write(str);
		}
	}
	fl.write("---------------------------------------------------------------------------------------------\r\n");
	fl.close();
}
public int plops(int i) throws IOException
{
	if(i==0)
	{
	Iterator<Course> CourseIterator = this.courses.iterator();
	while(CourseIterator.hasNext())
	{
		Course course=CourseIterator.next();
		if(this.fit(course)==false)
		{
			System.out.println("his");
			if(CourseIterator.hasNext()==false)
			{
				this.print();
			}
		}
	}
	}
	return 0;
}
}
