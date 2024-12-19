package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver , this);
		
	}
//	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")private WebElement moreinfoadmin;
	@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newbutton;
	@FindBy(xpath="//input[@id='username']")private WebElement username;
	@FindBy(xpath="//input[@id='password']")private WebElement pasword;
	@FindBy(xpath="//select[@id='user_type']")private WebElement usertype;
	@FindBy(xpath="//button[@name='Create']")private WebElement savebutton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alert;
	/*public AdminUsersPage moreInfoAdmin()
	{
		//moreinfo.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",moreinfoadmin);
		return this;
	}*/
	public AdminUsersPage newOption()
	{
		newbutton.click();
		return this;
	}
	public AdminUsersPage userText(String text)
	{
		username.sendKeys(text);	
		return this;
	}
	public AdminUsersPage passwordField(String pswd)
	{
		pasword.sendKeys(pswd);
		return this;
	}
	public AdminUsersPage userTypeDropDown()
	{
		PageUtility dropdown=new PageUtility();
		dropdown.selectByVisibleText(usertype, "Admin");
		return this;
	}
	public AdminUsersPage saveOption()
	{
		savebutton.click();
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
		}
	
