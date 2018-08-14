package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel_Data;
import page.LoginPage;


public class ValidLogin extends BaseTest
{
	@Test(priority=3,groups= {"login"})
	public void testValidLogin()
	{
		int rc=Excel_Data.getRowCount(EXCEL_PATH, "UserDetails");
		for(int i=1;i<=rc;i++)
		{
			String un = Excel_Data.getValue(EXCEL_PATH, "UserDetails", i, 0);
			String pw = Excel_Data.getValue(EXCEL_PATH, "UserDetails", i, 1);
			LoginPage l=new LoginPage(driver);
			l.setuserName(un);
			l.setPassword(pw);
			l.clickLogin();
		}
	}

}
