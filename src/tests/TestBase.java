package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.MainPage;
import pages.PageCart;
import pages.PageLogIn;
import pages.PageMyAccount;
import pages.PageMyAddresses;
import pages.PageMyPersonalnformation;
import pages.PageMyWishlists;
import pages.PageProductDetails;
import pages.PageYourAddresses;


public class TestBase {

	WebDriver driver;
	ExcelReader excelReader;
	
	//pages
	MainPage mainPage;
	PageLogIn pageLogIn;
	PageMyAccount pageMyAccount;
	PageMyAddresses pageMyAddresses;
	PageYourAddresses pageYourAddresses;
	PageMyPersonalnformation pageMyPersonalInformation;
	PageMyWishlists pageMyWishlists;
	PageCart pageCart;
	PageProductDetails pageProductDetails;
	
	@BeforeClass
	public void BeforeClass() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
		mainPage = new MainPage(driver);
		pageLogIn = new PageLogIn(driver);
		excelReader = new ExcelReader("data/testPlan.xlsx");
		pageMyAccount = new PageMyAccount(driver);
		pageMyAddresses = new PageMyAddresses(driver);
		pageYourAddresses = new PageYourAddresses(driver);
		pageMyPersonalInformation = new PageMyPersonalnformation(driver);
		pageMyWishlists = new PageMyWishlists(driver);
		pageCart = new PageCart(driver);
		pageProductDetails = new PageProductDetails(driver);
		
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void logIn(String email, String password)  {
		mainPage.navigateToSignInPage();
		pageLogIn.insertEmailAddress(email);
		pageLogIn.insertPassword(password);
		pageLogIn.signInButtonClick();
	}
	
	public void editPersonalInfo(String firstName, String lastName, String currentPassword, String newPassword, String confirmPassword) {
		pageMyPersonalInformation.editFirstName(firstName);
		pageMyPersonalInformation.editLastName(lastName);
		pageMyPersonalInformation.inputCurrentPassword(currentPassword);
		pageMyPersonalInformation.inputNewPassword(newPassword);
		pageMyPersonalInformation.confirmPassword(confirmPassword);
		pageMyPersonalInformation.saveButtonClick();
	}
	
	public void restoreOldInformation() {
		String firstName = excelReader.getStringData("My personal information", 16, 3);
		String lastName = excelReader.getStringData("My personal information", 17, 3);
		String currentPassword = excelReader.getStringData("My personal information", 18, 3);
		String newPassword = excelReader.getStringData("My personal information", 19, 3);
		String confirmPassword = excelReader.getStringData("My personal information", 20, 3);
		
		editPersonalInfo(firstName, lastName, currentPassword, newPassword, confirmPassword);
	}
	
	@AfterClass
	public void AfterClass() {
		driver.close();
	}
}
