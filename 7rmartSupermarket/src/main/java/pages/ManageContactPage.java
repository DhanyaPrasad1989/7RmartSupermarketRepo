package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {
	WebDriver driver;
	public ManageContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver , this);
		
	}
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")private WebElement moreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")private WebElement action;
	@FindBy(xpath="//input[@id='phone']")private WebElement phone;
	@FindBy(xpath="//input[@id='email']")private WebElement email;
	@FindBy(xpath="//textarea[@id='content' and @name='address']")private WebElement address;
	@FindBy(xpath="//textarea[@id='content' and @name='del_time']")private WebElement deliverytime;
	@FindBy(xpath="//input[@id='del_limit']")private WebElement deliverychargelimit;
	@FindBy(xpath="//button[@type='submit']")private WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;

	/*public ManageContactPage moreInfoOption()
	{
		moreinfo.click();
	return this;
	}*/
	public ManageContactPage actionButton()
	{
		action.click();
		return this;
	}
	public ManageContactPage phoneText(String phonenumber)
	{
		phone.clear();
		phone.sendKeys(phonenumber);
		return this;
	}
	public ManageContactPage emailText(String emailid)
	{
		email.clear();
		email.sendKeys(emailid);
		return this;
	}
	public ManageContactPage addressText(String addressfield)
	{
		address.clear();
		address.sendKeys(addressfield);
		return this;
	}
	public ManageContactPage deliveryTime(String time)
	{
		deliverytime.clear();
		deliverytime.sendKeys(time);
		return this;
	}
	public ManageContactPage deliveryChargeLimit(String chargelimit)
	{
		deliverychargelimit.clear();
		deliverychargelimit.sendKeys(chargelimit);
		return this;
	}
	public ManageContactPage update()
	{
		//update.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",update);
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
}
