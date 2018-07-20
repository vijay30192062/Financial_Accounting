package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConstants
{
	public WebDriver driver;
	
	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	@BeforeMethod(alwaysRun=true)
	public void OpenApp()
	{
		String appURL=AutoUtils.getValue(CONFIG_PATH, "URL");
		String StrITO=AutoUtils.getValue(CONFIG_PATH, "ITO");
		long ITO=Long.parseLong(StrITO);
		driver=new ChromeDriver();
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}
	
	@AfterMethod(alwaysRun=true)
	public void CloseApp(ITestResult testResult)
	{
		String TestName = testResult.getName();
		int TestStatus = testResult.getStatus();
		if(TestStatus==1)
		{
			Reporter.log(TestName+" Is Passed",true);
		}
		else
		{
			Reporter.log(TestName+" Is Failed",true);
			AutoUtils.getPhoto(driver, IMAGE_PATH,TestName);
		}
		driver.close();
	}

}
