package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver , this);
		
	}
	@FindBy(xpath="//a[@data-toggle='dropdown']")private WebElement admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")private WebElement logout;
	@FindBy(xpath="//input[@type='text']")private WebElement username;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")private WebElement moreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-footertext']")private WebElement moreinfofooter;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")private WebElement managenews;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and @class='small-box-footer']")private WebElement moreinfoproduct;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")private WebElement moreinfosub;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")private WebElement moreinfoadmin;
	public ManageContactPage moreInfoOption()
	{
		moreinfo.click();
	return new ManageContactPage(driver) ;
	}
	public ManageFooterTextPage moreInfoButton()
	{
		moreinfofooter.click();
		return new ManageFooterTextPage(driver);
		}
	public ManageNewsPage moreInfo()
	{
	managenews.click();	
	return new ManageNewsPage(driver);
	}
	public ManageProductPage moreInfoOptionProduct()
	{
		moreinfoproduct.click();
		return new ManageProductPage(driver);
		}
	public SubCategoryPage subCategoryMoreInfo()
	{
		moreinfosub.click();
		return new SubCategoryPage(driver);
	}
	public AdminUsersPage moreInfoAdmin()
	{
		//moreinfo.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",moreinfoadmin);
		return new AdminUsersPage(driver);
	}
	
public HomePage adminButton()
{
	admin.click();
	return this;
	}
public LoginPage logoutButton()
{
	logout.click();
	return new LoginPage(driver);
}
public boolean isLoggedOutSucessfully()
{
	return username.isDisplayed();
}
}
