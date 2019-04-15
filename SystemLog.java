package Logger;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Date;
//Used to write a log to specified file
public class SystemLog {
String path;
//FileWriter fl;
public SystemLog(String path)// throws IOException
{
	this.path=path;
	/*try {
			this.path=path;
			File file = new File(path);
			if(file.exists()==false)
			{
				file.createNewFile();
			}
			fl=new FileWriter(path,true);
		}
	catch(IOException e)
	{
		System.out.println(e);
	}*/
	}
public boolean log(String message) throws IOException
{
	try {
		this.path=path;
		File file = new File(path);
		if(file.exists()==false)
		{
			System.out.println("Creating log file...");
			file.createNewFile();
			System.out.println("Log created!");
		}
		FileWriter fl=new FileWriter(path,true);
		Date date=new Date();
		message= date.toString() +": "+ message+"\r\n";
		fl.write(message);
		fl.close();
		return true;
	}
catch(IOException e)
{
	System.out.println(e);
	return false;
}
}
}
