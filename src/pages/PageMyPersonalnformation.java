package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageMyPersonalnformation {

	WebDriver driver;
	WebElement firstNameInputField;
	WebElement lastNameInputField;
	WebElement currentPasswordInputField;
	WebElement newPasswordInputField;
	WebElement confirmNewPasswordInputField;
	WebElement saveButton;
	WebElement message;
	
	public PageMyPersonalnformation(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getFirstNameInputField() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getLastNameInputField() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement getCurrentPasswordInputField() {
		return driver.findElement(By.id("old_passwd"));
	}

	public WebElement getNewPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}
	
	public WebElement getConfirmNewPasswordInputField() {
		return driver.findElement(By.id("confirmation"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}
	
	public WebElement getMessage() {
		return driver.findElement(By.className("alert-success"));
	}
	
	public void editFirstName(String firstName) {
		getFirstNameInputField().clear();
		getFirstNameInputField().sendKeys(firstName);
	}
	
	public void editLastName(String lastName) {
		getLastNameInputField().clear();
		getLastNameInputField().sendKeys(lastName);
	}
	
	public void inputCurrentPassword(String currentPassword) {
		getCurrentPasswordInputField().clear();
		getCurrentPasswordInputField().sendKeys(currentPassword);
	}
	
	public void inputNewPassword(String newPassword) {
		getNewPasswordInputField().clear();
		getNewPasswordInputField().sendKeys(newPassword);
	}
	
	public void confirmPassword(String confirmPassword) {
		getConfirmNewPasswordInputField().clear();
		getConfirmNewPasswordInputField().sendKeys(confirmPassword);
	}
	
	public void saveButtonClick() {
		getSaveButton().click();
	}
	
	
	
}
