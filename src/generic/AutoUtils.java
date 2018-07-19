package generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AutoUtils 
{
	//Method to take screenshot
	public static String getPhoto(WebDriver driver,String folder)
	{
		String path=" ";
		try
		{
			String d = new Date().toString();
			String dateTime=d.replaceAll(";", "_");
			path=folder+dateTime+".png";
			System.out.println(path);
			TakesScreenshot t=(TakesScreenshot) driver;
			File sourceFile = t.getScreenshotAs(OutputType.FILE);
			File destinationFile= new File(path);
			FileUtils.copyDirectoryToDirectory(sourceFile, destinationFile);
			//FileUtils.copyFile(sourceFile, new File(path));
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return path;
	}
	public static String getValue(String path, String key)
	{
		String v="";
		try
		{
			Properties p=new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return v;
	}


}
