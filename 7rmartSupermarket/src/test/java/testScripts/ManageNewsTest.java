package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	HomePage homepage;
	ManageNewsPage managenewspage;
	@Test(description = "Update the details in manage news tab")
	public void verifyWhetherTheManageNewstabIsWorkingOrNot() throws IOException
	{
		
		String usernaamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
		String textvalue=ExcelUtility.getStringData(1, 0, "ManageNews");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNmae(usernaamevalue).password(passwordvalue);
		//loginpage.password(passwordvalue);
		//loginpage.signin();
		homepage=loginpage.signin();
		managenewspage=homepage.moreInfo();
		//ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.newsButton().newsTextField(textvalue).saveButton();
		//managenewspage.newsButton();
		//managenewspage.newsTextField(textvalue);
		//managenewspage.saveButton();
		boolean alertdisplay=managenewspage.isAssertChecked();
		Assert.assertTrue(alertdisplay, Constants.MANAGENEWSALERT);
		
	}


}
