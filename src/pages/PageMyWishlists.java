package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageMyWishlists {

	WebDriver driver;
	WebElement nameInputField;
	WebElement saveButton;
	List<WebElement> wishlists;
	WebElement deleteButton;
	
	public PageMyWishlists(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getNameInputField() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}
	
	public WebElement getDeleteButton() {
		return driver.findElement(By.className("icon-remove"));
	}
	
	public List<WebElement> getWishlists() {
		return driver.findElements(By.xpath("//tr[starts-with(@id ,'wishlist')]"));
	}

	public void inputNewWishlist(String name) {
		getNameInputField().clear();
		getNameInputField().sendKeys(name);
	}
	
	public void saveButtonClick() {
		getSaveButton().click();
	}
	
	public void addThreeWishlists(String name1, String name2, String name3) throws InterruptedException {
		inputNewWishlist(name1);
		saveButtonClick();
		Thread.sleep(2000);
		inputNewWishlist(name2);
		saveButtonClick();
		Thread.sleep(2000);
		inputNewWishlist(name3);
		saveButtonClick();
	}
	
	public void deleteButtonClick() {
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 4);
			wait.until(ExpectedConditions.elementToBeClickable(getDeleteButton()));
			getDeleteButton().click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			driver.navigate().refresh();
		} 
		catch (Exception e) 
		{
			System.out.println("\"Delete\" button is not displayed");
		}
	}
	
	public void deleteAllWishlists() throws InterruptedException {
		for (int i = 0; i < getWishlists().size(); i++) {
			Thread.sleep(2000);
			deleteButtonClick();
			Thread.sleep(2000);
		}
		deleteButtonClick();
	}
	
}
