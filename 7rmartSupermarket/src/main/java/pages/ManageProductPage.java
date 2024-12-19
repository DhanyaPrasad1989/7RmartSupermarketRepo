package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.PageUtility;

public class ManageProductPage {
	WebDriver driver;
	PageUtility pageutility =new PageUtility();
	public ManageProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver , this);
		
	}
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and @class='small-box-footer']")private WebElement moreinfoproduct;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newbutton;
	@FindBy(xpath="//input[@id='title']")private WebElement title;
	@FindBy(xpath="//input[@value='Veg']")private WebElement producttype;
	@FindBy(xpath="//input[@id='tag']")private WebElement tag;
	@FindBy(xpath="//button[@type='submit']")private WebElement update;
	//@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	
/*	public ManageProductPage moreInfoOption()
	{
		moreinfoproduct.click();
		return this;
		}*/
	public ManageProductPage newButton()
	{
		newbutton.click();
		return this;
	}
	public ManageProductPage titleText(String titlefield)
	{
		title.sendKeys(titlefield);
		return this;
	}
	public ManageProductPage productRadio()
	{
		producttype.click();
		return this;
	}
	public ManageProductPage tagText(String tagfield)
	{
		tag.sendKeys(tagfield);
		return this;
	}
	public ManageProductPage saveButton()
	{
		//update.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",update);
		return this;
	}
	public String getAlertText() {
		return pageutility.getTextFromAlert(driver);
	}


	
}
