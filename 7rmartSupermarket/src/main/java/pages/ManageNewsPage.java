package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;
	public ManageNewsPage(WebDriver driver )
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']")private WebElement managenews;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement news;
	@FindBy(xpath="//textarea[@id='news']")private WebElement newstext;
	@FindBy(xpath="//button[@type='submit']")private WebElement save;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alert;
	
	/*public ManageNewsPage moreInfo()
	{
	managenews.click();	
	return this;
	}*/
	public ManageNewsPage newsButton()
	{
	news.click();	
	return this;
	}
public ManageNewsPage newsTextField(String text)
{
	newstext.sendKeys(text);
	return this;
}
public ManageNewsPage saveButton()
{
	save.click();
	return this;
}
public boolean isAssertChecked()
{
	return alert.isDisplayed();
}

}
