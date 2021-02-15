package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageLogIn {

	WebDriver driver;
	WebElement emailAddressInputField;
	WebElement passwordInputField;
	WebElement signInButton;
	WebElement errorMessageInvalidPassword;
	WebElement errorMessageInvalidEmail;
	WebElement errorMessageEmptyFields;
	
	public PageLogIn(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmailAddressInputField() {
		return driver.findElement(By.id("email"));
	}
	
	public WebElement getPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}
	
	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public WebElement getErrorMessageInvalidPassword() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}

	public WebElement getErrorMessageInvalidEmail() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}

	public WebElement getErrorMessageEmptyFields() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li"));
	}

	public void insertEmailAddress(String emailAddress) {
		getEmailAddressInputField().clear();
		getEmailAddressInputField().sendKeys(emailAddress);
	}
	
	public void insertPassword(String password) {
		getPasswordInputField().clear();
		getPasswordInputField().sendKeys(password);
	}
	
	public void signInButtonClick() {
		getSignInButton().click();
	}
}
