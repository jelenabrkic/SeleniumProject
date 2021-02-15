package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCart {

	WebDriver driver;
	WebElement productName;
	WebElement quantity;
	WebElement continueShoppingLink;
	List<WebElement> deleteButtons;
	WebElement deleteButton;
	
	
	public PageCart(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getProductName() {
		return driver.findElement(By.xpath("//*[@id=\"product_1_1_0_0\"]/td[2]/p/a"));
	}

	public WebElement getQuantity() {
		return driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr/td[5]/input[1]"));
	}

	public WebElement getContinueShoppingLink() {
		return driver.findElement(By.xpath("//a[@title='Continue shopping']"));
	}
	
	public List<WebElement> getDeleteButtons() {
		return driver.findElements(By.xpath("//i[@class='icon-trash']"));
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//a[@title='Delete']"));
	}


	public void continueShoppingClick() {
		getContinueShoppingLink().click();
	}
	
	public void deleteClick() {
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.elementToBeClickable(getDeleteButton()));
			getDeleteButton().click();
		} 
		catch (Exception e) 
		{
			System.out.println("\"Delete\" button is not displayed");
		}
	}
	
	public void deleteAllProducts() throws InterruptedException {
		for (int i = 0; i < getDeleteButtons().size(); i++) {
			getDeleteButtons().get(i).click();
			Thread.sleep(1000);
		}
	}
	
	
}
