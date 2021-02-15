package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends TestBase {
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@Test (priority = 0)
	public void invalidLoginInvalidPassword() throws InterruptedException {
		String emailAddress = excelReader.getStringData("Login", 18, 3);
		String password = String.valueOf(excelReader.getIntData("Login", 19, 3));
		String errorMessage = excelReader.getStringData("Login", 20, 3);
		
		logIn(emailAddress, password);
		
		String assertErrorMessage = pageLogIn.getErrorMessageInvalidPassword().getText();
		Assert.assertEquals(assertErrorMessage, errorMessage);
	}
	
	@Test (priority = 5)
	public void invalidLoginInvalidEmailAddress() throws InterruptedException {
		String emailAddress = excelReader.getStringData("Login", 28, 3);
		String password = excelReader.getStringData("Login", 29, 3);
		String errorMessage = excelReader.getStringData("Login", 30, 3);
		
		logIn(emailAddress, password);
		
		String assertErrorMessage = pageLogIn.getErrorMessageInvalidEmail().getText();
		Assert.assertEquals(assertErrorMessage, errorMessage);
	}

	@Test (priority = 10)
	public void invalidLoginEmptyFields() throws InterruptedException {
		String emailEmptyField = excelReader.getEmptyField("Login", 38, 3);
		String passwordEmptyField = excelReader.getEmptyField("Login", 39, 3);
		String errorMessage = excelReader.getStringData("Login", 40, 3);
		
		logIn(emailEmptyField, passwordEmptyField);
		
		String assertErrorMessage = pageLogIn.getErrorMessageEmptyFields().getText();
		Assert.assertEquals(assertErrorMessage, errorMessage);
	}
	
	@Test (priority = 15)
	public void loginWithValidCredentials() throws InterruptedException {
		String emailAddress = excelReader.getStringData("Login", 7, 3);
		String password = excelReader.getStringData("Login", 8, 3);
		String myAccountText = excelReader.getStringData("Login", 9, 3);
		
		logIn(emailAddress, password);
		
		String assertMyAccountText = pageMyAccount.getTitleMyAccount().getText();
		Assert.assertEquals(assertMyAccountText, myAccountText);
		
	}
	
	@Test (priority = 20)
	public void logOut() throws InterruptedException {
		String signInButton = excelReader.getStringData("Login", 47, 3);
		
		pageMyAccount.signOutButtonClick();
		
		String assertButton = mainPage.getSignInButton().getText();
		Assert.assertEquals(assertButton, signInButton);
	}
	
	
	@AfterMethod
	public void afterMethod() {
		driver.navigate().refresh();
	}
	
}

