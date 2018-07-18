package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;



public class EnterPage 
{
	@FindBy(xpath="//div[contains(text(),'Help')]")
	private WebElement help;
	
	@FindBy(linkText="About your ActiTIME")
	private WebElement aboutAT;
	
	@FindBy(xpath="//span{@class='productVersion")
	private WebElement version;
	
	public EnterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public void clickHelp()
	{
		help.click();
	}
	
	public void clickAboutActiTIME()
	{
		aboutAT.click();
	}
	
	public void verifyProductVersion(String ExpectedVersion)
	{
		String ActualVersion = version.getText();
		Assert.assertEquals(ActualVersion, ExpectedVersion);
	}
	
	

}
