package testScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	HomePage homepage;
	ManageContactPage managecontact;
	@Test(description="Fill all the fields in manage contact option and update the details")
	public void UpdateManageContactDetails() throws IOException
	{
		String usernaamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");	
		String phonevalue=ExcelUtility.getIntegerData(1, 0, "ManageContact");
		String emailvalue=ExcelUtility.getStringData(1, 1, "ManageContact");	
		String addressvalue=ExcelUtility.getStringData(1, 2, "ManageContact");
		String timevalue=ExcelUtility.getStringData(1, 3, "ManageContact");	
		String limitvalue=ExcelUtility.getIntegerData(1, 4, "ManageContact");	
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNmae(usernaamevalue).password(passwordvalue);
		//loginpage.password(passwordvalue);
		homepage=loginpage.signin();
		managecontact=homepage.moreInfoOption();
		//ManageContactPage managecontact =new ManageContactPage(driver);
		managecontact.actionButton().phoneText(phonevalue).emailText(emailvalue).addressText(addressvalue).deliveryTime(timevalue).deliveryChargeLimit(limitvalue).update();
		//managecontact.actionButton();
		//managecontact.phoneText(phonevalue);
		//managecontact.emailText(emailvalue);
		//managecontact.addressText(addressvalue);
		//managecontact.deliveryTime(timevalue);
		//managecontact.deliveryChargeLimit(limitvalue);
		//managecontact.update();
		boolean alertmessage = managecontact.isAlertDisplayed();
		Assert.assertTrue(alertmessage, Constants.MANAGECONTACTMESSAGE);
	}

}
