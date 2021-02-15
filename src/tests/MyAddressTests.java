package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyAddressTests extends TestBase {
	
	JavascriptExecutor js; 
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
		this.js = (JavascriptExecutor) driver;
		
		String emailAddress = excelReader.getStringData("Login", 7, 3);
		String password = excelReader.getStringData("Login", 8, 3);
		logIn(emailAddress, password);
		pageMyAccount.myAddressesButtonClick();
	}
	
	@Test (priority = 1)
	public void updateAddress() throws InterruptedException {
		String newAddress = excelReader.getStringData("My addresses", 8, 3);
		String oldAddress = excelReader.getStringData("My addresses", 10, 3);
		
		pageMyAddresses.updateButtonClick();
		pageYourAddresses.editAddress(newAddress);
		pageYourAddresses.saveButtonClick();
		
		String assertNewAddress = pageMyAddresses.getStreetUpdateText().getText();
		Assert.assertEquals(assertNewAddress, newAddress);
		
		pageMyAddresses.updateButtonClick();
		pageYourAddresses.restoreOldAddress(oldAddress);
	}
	
	@Test (priority = 5)
	public void addANewAddress() throws InterruptedException {
		String newAddress = excelReader.getStringData("My addresses", 18, 3);
		String city = excelReader.getStringData("My addresses", 19, 3);
		String postalCode = String.valueOf(excelReader.getIntData("My addresses", 21, 3));
		String phoneNumber = String.valueOf(excelReader.getIntData("My addresses", 22, 3));
		String addressText = excelReader.getStringData("My addresses", 23, 3);
		String title = excelReader.getStringData("My addresses", 24, 3);
	
		pageMyAddresses.addANewAddressButtonClick();
		pageYourAddresses.editAddress(newAddress);
		pageYourAddresses.inputCity(city);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		pageYourAddresses.selectState();
		pageYourAddresses.inputPostalCode(postalCode);
		pageYourAddresses.inputPhoneNumber(phoneNumber);
		pageYourAddresses.inputNewAdressTitle(title);
		pageYourAddresses.saveButtonClick();
		Thread.sleep(2000);
		
		String assertAddress = pageMyAddresses.getStreetAddedText().getText();
		Assert.assertEquals(assertAddress, addressText);
	}
	
	@Test (priority = 10)
	public void deleteAddress() throws InterruptedException {
		
		pageMyAddresses.deleteButtonClick();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		int deleteButtonsNumber = excelReader.getIntData("My addresses", 33, 3);
		int deleteButtons = pageMyAddresses.getDeleteButtons().size();
		Assert.assertEquals(deleteButtonsNumber, deleteButtons);
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		pageMyAccount.signOutButtonClick();
		driver.navigate().refresh();
	}
}
