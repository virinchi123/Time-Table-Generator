
public class Slot {
int number;
boolean taken=false;
String course;
public Slot()
{
	
}
public Slot(int n)
{
	number=n;
}
public int toggle()
{
	taken=!taken;
	return 0;
}
}
