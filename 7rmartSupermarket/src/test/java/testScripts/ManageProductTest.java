package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageProductPage;
import utilities.ExcelUtility;

public class ManageProductTest extends Base {
	HomePage homepage;
	ManageProductPage managepage;
	@Test(description ="Update only few fields in manage product option and check whether alert is present or not ")
	public void CheckWhetherAlertIsPresentInManageProduct() throws IOException
	{
		String usernaamevalue=ExcelUtility.getStringData(1, 0, "LoginPage");
		String passwordvalue=ExcelUtility.getStringData(1, 1, "LoginPage");
		String titlevalue=ExcelUtility.getStringData(1, 0, "ManageProduct");
		String tagvalue=ExcelUtility.getStringData(1, 1, "ManageProduct");
		//String phonenumber=ExcelUtility.getIntegerData(1, 2, "ManageProduct");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserNmae(usernaamevalue).password(passwordvalue);
		//loginpage.password(passwordvalue);
		homepage=loginpage.signin();
		managepage=homepage.moreInfoOptionProduct();
		//ManageProductPage managepage = new ManageProductPage(driver);
		managepage.newButton().titleText(titlevalue).productRadio().tagText(tagvalue).saveButton();
		//managepage.newButton();
		//managepage.titleText(titlevalue);
		//managepage.productRadio();
		//managepage.tagText(tagvalue);
		//managepage.saveButton();
		String actualalerttext = managepage.getAlertText();
		String expectedalerttext = "Please enter weight price";
		Assert.assertEquals(actualalerttext, expectedalerttext, Constants.PRODUCTALERTDISPLAYED);
		
		
	}

}
