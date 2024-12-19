package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage homepage;
	@Test
	public void VerifyLogoutOptionIsWorking() throws IOException
	{
		String usernaamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
		String textusername=ExcelUtility.getStringData(1, 0, "AdminUsers");
		String textpassword=ExcelUtility.getStringData(1, 1, "AdminUsers");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNmae(usernaamevalue).password(passwordvalue);
		//loginpage.password(passwordvalue);
		homepage=loginpage.signin();
		//HomePage homepage=new HomePage(driver);
		homepage.adminButton();
		loginpage=homepage.logoutButton();
		boolean alertdisplay=homepage.isLoggedOutSucessfully();
		Assert.assertTrue(alertdisplay,Constants.LOGOUTALERT);
	}

}
