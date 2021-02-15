package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageYourAddresses {

	WebDriver driver;
	WebElement addressInputField;
	WebElement saveButton;
	WebElement cityInputField;
	WebElement listOfStates;
	WebElement postalCodeInputField;
	WebElement homeNumberInputField;
	WebElement newAddressTitle;
	
	
	public PageYourAddresses(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAddressInputField() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}
	
	public WebElement getCityInputField() {
		return driver.findElement(By.id("city"));
	}
	
	public WebElement getListOfStates() {
		return driver.findElement(By.id("id_state"));
	}
	
	public WebElement getPostalCodeInputField() {
		return driver.findElement(By.id("postcode"));
	}

	public WebElement getHomeNumberInputField() {
		return driver.findElement(By.id("phone"));
	}
	
	public WebElement getNewAddressTitle() {
		return driver.findElement(By.id("alias"));
	}

	public void editAddress(String newAddress) {
		getAddressInputField().clear();
		getAddressInputField().sendKeys(newAddress);
	}
	
	public void inputCity(String city) {
		getCityInputField().clear();
		getCityInputField().sendKeys(city);
	}
	
	public void inputPostalCode(String postalCode) {
		getPostalCodeInputField().clear();
		getPostalCodeInputField().sendKeys(postalCode);
	}
	
	public void inputPhoneNumber(String phoneNumber) {
		getHomeNumberInputField().clear();
		getHomeNumberInputField().sendKeys(phoneNumber);
	}
	
	public void inputNewAdressTitle(String newTitle) {
		getNewAddressTitle().clear();
		getNewAddressTitle().sendKeys(newTitle);
	}
	
	public void saveButtonClick() {
		getSaveButton().click();
	}
	
	public void selectState() {
		Select objSelect = new Select(getListOfStates());
		objSelect.selectByValue("5");
	}
	
	public void restoreOldAddress(String oldAddress) {
		editAddress(oldAddress);
		saveButtonClick();
	}
}
