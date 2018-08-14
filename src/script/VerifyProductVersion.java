package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel_Data;
import page.EnterPage;
import page.LoginPage;

public class VerifyProductVersion extends BaseTest
{
	@Test(priority=2, groups= {"login"})
	public void testVerifyProdcutVersion() throws InterruptedException
	{
		
		int rc = Excel_Data.getRowCount(EXCEL_PATH, "UserDetails");
		for(int i=1;i<=rc;i++)
		{
			String un = Excel_Data.getValue(EXCEL_PATH, "UserDetails", i, 0);
			String pw1 = Excel_Data.getValue(EXCEL_PATH, "UserDetails", i, 1);
			String version=Excel_Data.getValue(EXCEL_PATH, "UserDetails", i, 3);
			//-create object
			LoginPage l=new LoginPage(driver);
			l.setuserName(un);
			l.setPassword(pw1);
			l.clickLogin();
			EnterPage e=new EnterPage(driver);
			Thread.sleep(2000);
			e.clickHelp();
			Thread.sleep(2000);
			e.clickAboutActiTIME();
			Thread.sleep(2000);
			e.verifyProductVersion(version);
			
			
		}
	}

}
