package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectByIndex(WebElement element,int index) {
		Select select =new Select(element);
		select.selectByIndex(index);
		
	}
	public void selectByValue(WebElement element,String value) {
		Select select =new Select(element);
		select.selectByValue(value);
		
	}
public void selectByVisibleText(WebElement element,String visibleText) {
		Select select =new Select(element);
		select.selectByVisibleText(visibleText);;
		
	}
public void simpleAlert(WebDriver driver)
{
	
	//element.click();
	driver.switchTo().alert().accept();

	
}
public void confirmationAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
	driver.switchTo().alert().dismiss();
}
public void promptAlert(WebDriver driver)
{
	driver.switchTo().alert().sendKeys("Dhanya");//for the text field
	driver.switchTo().alert().accept();
}
public void rightClick(WebElement dragableItem, WebDriver driver) {
	Actions actions = new Actions(driver);
	actions.contextClick(dragableItem);
}

public void doubleClick(WebElement dragableItem, WebDriver driver) {
	Actions actions = new Actions(driver);
	actions.doubleClick(dragableItem);
}
public void moveElement(WebElement dragableItem, WebDriver driver) {
	Actions actions = new Actions(driver);
	actions.moveToElement(dragableItem);
}

public void dragandDrop(WebElement dragableItem, WebElement droppeditemlist,WebDriver driver) {
	Actions actions = new Actions(driver);
	actions.dragAndDrop(dragableItem, droppeditemlist);
}
public void javaScriptScroll(WebDriver driver)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("window.scrollBy(0,150)","");//scroll by 150 in y axis
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");//end of the page
}
public String getTextFromAlert(WebDriver driver) {
	return driver.switchTo().alert().getText();
}

}



