package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageProductDetails {

	WebDriver driver;
	
	WebElement quantityInputField;
	WebElement addToCartButton;
	
	public PageProductDetails(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getQuantityInputField() {
		return driver.findElement(By.id("quantity_wanted"));
	}
	
	public WebElement getAddToCartButton() {
		return driver.findElement(By.xpath("//button[@name='Submit']"));
	}

	public void inputQuantity(String quantity) {
		getQuantityInputField().clear();
		getQuantityInputField().sendKeys(quantity);
	}
	
	public void addToCartButtonClick() {
		getAddToCartButton().click();
	}
}
