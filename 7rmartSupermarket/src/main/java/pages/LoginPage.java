package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver , this);
		
	}
	@FindBy(xpath="//input[@name='username']")private WebElement user;
	@FindBy(xpath=" //input[@name='password']")private WebElement pass;
	@FindBy(xpath="//button[@type='submit']")private WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alert;

public LoginPage enterUserNmae(String username )
{
	user.sendKeys(username);
	return this;
	
}
public LoginPage password(String passwd)
{
	pass.sendKeys(passwd);
	return this;
}
public HomePage signin()
{
	signin.click();
	return new HomePage(driver);
}
public boolean isHomePageloaded()
{
	return dashboard.isDisplayed();
}
public boolean isAssertChecked()
{
	return alert.isDisplayed();
}
}