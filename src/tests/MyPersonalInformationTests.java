package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPersonalInformationTests extends TestBase {
	
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
		
		String emailAddress = excelReader.getStringData("Login", 7, 3);
		String password = excelReader.getStringData("Login", 8, 3);
		logIn(emailAddress, password);
		pageMyAccount.myPersonalInfoClick();
	}
	
	@Test
	public void editPersonalInformation() throws InterruptedException {
		String firstName = excelReader.getStringData("My personal information", 7, 3);
		String lastName = excelReader.getStringData("My personal information", 8, 3);
		String currentPassword = excelReader.getStringData("My personal information", 9, 3);
		String newPassword = excelReader.getStringData("My personal information", 10, 3);
		String confirmPassword = excelReader.getStringData("My personal information", 11, 3);
		String message = excelReader.getStringData("My personal information", 12, 3);
	
		editPersonalInfo(firstName, lastName, currentPassword, newPassword, confirmPassword);
		
		String assertMessage = pageMyPersonalInformation.getMessage().getText();
		Assert.assertEquals(assertMessage, message);
		
		driver.navigate().back();
		restoreOldInformation();
	}
	
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		pageMyAccount.signOutButtonClick();
		driver.navigate().refresh();
		Thread.sleep(1000);
	}
}
