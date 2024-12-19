package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	@Test(description="Login with correct username and password", groups= {"regression"})
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
	
		String usernaamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNmae(usernaamevalue).password(passwordvalue).signin();
		//loginpage.password(passwordvalue);
		//loginpage.signin();
	boolean ishomepageavailable=	loginpage.isHomePageloaded();
	Assert.assertTrue(ishomepageavailable,Constants.CREDENTIALS);
		
	}
	@Test(description="Login with correct username and incorrect password")
	public void verifyTheUserIsNotAbleTologinWithIncorrectpswd() throws IOException
	{
		
		String usernaamevalue=ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getIntegerData(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNmae(usernaamevalue).password(passwordvalue).signin();
		//loginpage.password(passwordvalue);
		//loginpage.signin();
		boolean alertmessage=loginpage.isAssertChecked();
		Assert.assertTrue(alertmessage,Constants.CREDENTIALS2);
	}
	@Test(description="Login with incorrect username and correct password")
	public void verifyTheUserIsNotAbleTologinWithIncorrectusername() throws IOException
	{
		
		String usernaamevalue=ExcelUtility.getStringData(3, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNmae(usernaamevalue).password(passwordvalue).signin();
		//loginpage.password(passwordvalue);
		//loginpage.signin();
		boolean alertmessage=loginpage.isAssertChecked();
		Assert.assertTrue(alertmessage, Constants.CREDENTIALS3);
	}
@Test(description="Login with incorrect username and password", dataProvider ="LoginProvider")
public void verifyTheUserIsNotAbleTologinWithBothIncorrectUsernameAndPassword(String usernaamevalue,String passwordvalue ) throws IOException
{
	
	//String usernaamevalue=ExcelUtility.getStringData(4, 0, "LoginPage");
	//String passwordvalue=ExcelUtility.getIntegerData(4, 1, "LoginPage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUserNmae(usernaamevalue).password(passwordvalue).signin();
	//loginpage.password(passwordvalue);
//	loginpage.signin();
	boolean alertmessage=loginpage.isAssertChecked();
	Assert.assertTrue(alertmessage, Constants.CREDENTIALS4);
}
@DataProvider(name="LoginProvider")
public Object[][] getDataFromTestData() throws IOException{
	return new Object[][] {{ExcelUtility.getStringData(4, 0,"LoginPage"),ExcelUtility.getStringData(4,1,"LoginPage")}};
}
}
