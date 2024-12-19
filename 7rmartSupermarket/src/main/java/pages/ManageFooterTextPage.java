package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	WebDriver driver;
	public ManageFooterTextPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver , this);
		
	}
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")private WebElement moreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1']")private WebElement action;
	@FindBy(xpath="//textarea[@id='content']")private WebElement address;
	@FindBy(xpath="//input[@id='email']")private WebElement email;
	@FindBy(xpath="//input[@id='phone']")private WebElement phone;
	@FindBy(xpath="//button[@type='submit']")private WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	/*public ManageFooterTextPage moreInfoButton()
	{
		moreinfo.click();
		return this;
		}*/
	public ManageFooterTextPage actionButton()
	{
		action.click();
		return this;
	}
	public ManageFooterTextPage addressField(String text)
	{
		address.clear();
		address.sendKeys(text);
		return this;
		
	}
	public ManageFooterTextPage emailField(String em)
	{
		email.clear();
		email.sendKeys(em);
		return this;
	}
	public ManageFooterTextPage phoneField(String ph)
	{
		phone.clear();
		phone.sendKeys(ph);
		return this;
	}
	public ManageFooterTextPage updateButton()
	{
		update.click();
		return this;
	}
	public ManageFooterTextPage actionPresent()
	{
		if(action.isDisplayed())
			System.out.println("Action button is present");
		else
			System.out.println("Action button is not present");
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	
}
