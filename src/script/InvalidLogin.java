package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel_Data;
import page.LoginPage;

public class InvalidLogin extends BaseTest
{
	@Test(priority=1,groups= {"login"})
	public void testInvalidLogin() throws InterruptedException
	{
		int rc = Excel_Data.getRowCount(EXCEL_PATH, "InvalidLogin");
		for(int i=1;i<=rc;i++)
		{
			String un = Excel_Data.getValue(EXCEL_PATH, "InvalidLogin", i, 0);
			String pw = Excel_Data.getValue(EXCEL_PATH, "InvalidLogin", i, 1);
			String ExpectedMSG=Excel_Data.getValue(EXCEL_PATH, "InvalidLogin", i, 2);
			
			LoginPage l=new LoginPage(driver);
			l.setuserName(un);
			l.setPassword(pw);
			l.clickLogin();
			Thread.sleep(2000);
			l.verifyErrorMSG(ExpectedMSG);
			
		}
		
	}

}
