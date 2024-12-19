package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base{
	HomePage homepage;
	AdminUsersPage adminuser;
	@Test
	public void VerifyAdminCanAddDetailsInAdminUserPage() throws IOException
	{

		String usernaamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
		String textusername=ExcelUtility.getStringData(1, 0, "AdminUsers");
		String textpassword=ExcelUtility.getStringData(1, 1, "AdminUsers");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNmae(usernaamevalue).password(passwordvalue);
		//loginpage.password(passwordvalue);
		homepage=loginpage.signin();
		adminuser=homepage.moreInfoAdmin();
		//AdminUsersPage adminuser=new AdminUsersPage(driver);
		adminuser.newOption().userText(textusername).passwordField(textpassword).userTypeDropDown().saveOption();
		//adminuser.newOption();
		//adminuser.userText(textusername);
		//adminuser.passwordField(textpassword);
		//adminuser.userTypeDropDown();
		//adminuser.saveOption();
		boolean alertdisplay=adminuser.isAlertDisplayed();
		Assert.assertTrue(alertdisplay);
		
		
	}

}
