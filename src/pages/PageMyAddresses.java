package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageMyAddresses {

	WebDriver driver;
	WebElement updateButton;
	WebElement deleteButton;
	WebElement addANewAddressButton;
	WebElement streetUpdateText;
	WebElement streetAddedText;
	WebElement newAddressBox;
	List<WebElement> deleteButtons;
	
	public PageMyAddresses(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUpdateButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]"));
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[9]/a[2]"));
	}

	public WebElement getAddANewAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a"));
	}

	public WebElement getStreetUpdateText() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[1]/ul/li[4]/span[1]"));
	}

	public WebElement getStreetAddedText() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div[2]/ul/li[4]/span[1]"));
	}
	
	public WebElement getNewAddressBox() {
		return driver.findElement(By.className("alternate_item"));
	}
	
	public List<WebElement> getDeleteButtons() {
		return driver.findElements(By.xpath("//*[@title='Delete']"));
	}

	public void updateButtonClick() {
		getUpdateButton().click();
	}
	
	public void deleteButtonClick() {
		getDeleteButton().click();
	}
	
	public void addANewAddressButtonClick() {
		getAddANewAddressButton().click();
	}
}
