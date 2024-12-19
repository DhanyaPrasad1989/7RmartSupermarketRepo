package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base{
	HomePage homepage;
	ManageFooterTextPage footertext;
	@Test(description = "Update the details in manage footer text option")
	public void UpdateDetailsInManageFooterTextTab() throws IOException
	{
		String usernaamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
		String addresstext=ExcelUtility.getStringData(1, 0, "FooterText");
		String emailtext=ExcelUtility.getStringData(1, 1, "FooterText");
		String phonenumber=ExcelUtility.getIntegerData(1, 2, "FooterText");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNmae(usernaamevalue).password(passwordvalue);
		//loginpage.password(passwordvalue);
		homepage=loginpage.signin();
		footertext=homepage.moreInfoButton();
		//ManageFooterTextPage footertext =new ManageFooterTextPage(driver);
		footertext.actionButton().addressField(addresstext).emailField(emailtext).phoneField(phonenumber).updateButton();
		//footertext.actionButton();
		//footertext.addressField(addresstext);
		//footertext.emailField(emailtext);
		//footertext.phoneField(phonenumber);
		//footertext.updateButton();
		boolean alertmessage=footertext.isAlertDisplayed();
		Assert.assertTrue(alertmessage, Constants.FOOTERTEXTALERT);
	}
	@Test(description="check whether the action button is present or not")
	public void checkWhetherActionButtonIsPresentOrnot() throws IOException
	{
		String usernaamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
		String addresstext=ExcelUtility.getStringData(1, 0, "FooterText");
		String emailtext=ExcelUtility.getStringData(1, 1, "FooterText");
		String phonenumber=ExcelUtility.getIntegerData(1, 2, "FooterText");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNmae(usernaamevalue).password(passwordvalue);
		//loginpage.password(passwordvalue);
		homepage=loginpage.signin();
		footertext=homepage.moreInfoButton();
		//ManageFooterTextPage footertext =new ManageFooterTextPage(driver);
		footertext.actionPresent();
		//footertext.actionPresent();
		boolean alertmessage=footertext.isAlertDisplayed();
		Assert.assertTrue(alertmessage, Constants.FOOTERTEXTALERT);
	}

}
