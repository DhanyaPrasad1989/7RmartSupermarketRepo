package pages;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtilities;
import utilities.PageUtility;

public class SubCategoryPage {
	WebDriver driver;
	public SubCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver , this);
		
	}
	@FindBy(xpath="//select[@id='cat_id']")private WebElement category;
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")private WebElement moreinfosub;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement buttonnew;
	@FindBy(xpath="//input[@id='subcategory']")private WebElement subcat;
	@FindBy(xpath="//input[@id='main_img']")private WebElement file;
	@FindBy(xpath="//button[@type='submit']")private WebElement savebut;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[2]")private WebElement deletebutton;
	@FindBy(xpath="//i[@class='icon fas fa-check']")private WebElement alertfordelete;
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/delete?del=1844&page_ad=1']")private WebElement deletebutton;
	/*public SubCategoryPage subCategoryMoreInfo()
	{
		moreinfosub.click();
		return this;
	}*/
	public SubCategoryPage newButton()
	{
		buttonnew.click();
		return this;
	}

public SubCategoryPage category()
{
	PageUtility dropdown=new PageUtility();
	dropdown.selectByVisibleText(category, "Electronics");
	return this;
}
public SubCategoryPage subCategory(String text)
{
	subcat.sendKeys(text);
	return this;
}
public SubCategoryPage image() throws AWTException
{
	FileUploadUtilities fileupload=new FileUploadUtilities();
	fileupload.fileUploadSendkeys(file, Constants.TVIMAGE);
	return this;
}
public SubCategoryPage saveButton()
{
	//savebut.click();
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();",savebut);
	return this;
}
public boolean isAlertDisplayed()
{
	return alert.isDisplayed();
}
public SubCategoryPage deletebutton()
{
	deletebutton.click();
	driver.switchTo().alert().accept();
	return this;
	
}
public boolean isAlertDisplayedForDeleteButton()
{
	return alertfordelete.isDisplayed();
}
}



