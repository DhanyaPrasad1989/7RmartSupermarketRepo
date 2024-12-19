package testScripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base{
	HomePage homepage;
	SubCategoryPage subcatpage;
	@Test(description="Update the details in sub category option")
	public void SubCategoryTab() throws IOException, AWTException
	{
		String usernaamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
		String textvalue=ExcelUtility.getStringData(3, 0, "SubCategory");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNmae(usernaamevalue).password(passwordvalue);
		//loginpage.password(passwordvalue);
		homepage=loginpage.signin();
		subcatpage=homepage.subCategoryMoreInfo();
		//SubCategoryPage subcatpage=new SubCategoryPage(driver);
		subcatpage.newButton().category().subCategory(textvalue).image().saveButton();
		//subcatpage.newButton();
		//subcatpage.category();
		//subcatpage.subCategory(textvalue);
		//subcatpage.image();
		//subcatpage.saveButton();
		boolean alertdisplay=subcatpage.isAlertDisplayed();
		Assert.assertTrue(alertdisplay,Constants.SUBCATEGORYALERT);
		
	}
	@Test(description = "Delete one row from the sub category option")
	public void deleteOneRoweFromSubCategory() throws IOException
	{
		String usernaamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
	//	String textvalue=ExcelUtility.getStringData(3, 0, "SubCategory");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNmae(usernaamevalue).password(passwordvalue);
		//loginpage.password(passwordvalue);
		homepage=loginpage.signin();
		subcatpage=homepage.subCategoryMoreInfo();
		//SubCategoryPage subcatpage=new SubCategoryPage(driver);
		subcatpage.deletebutton();
		//subcatpage.deletebutton();
		boolean alertdisplay=subcatpage.isAlertDisplayedForDeleteButton();
		Assert.assertTrue(alertdisplay, Constants.SUBCATEGORYALERT);
	}

}
