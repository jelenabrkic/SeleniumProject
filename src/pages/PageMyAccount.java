package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageMyAccount {

	WebDriver driver;
	WebElement titleMyAccount;
	WebElement signOutButton;
	WebElement myAddresessButton;
	WebElement myPersonalInfoButton;
	WebElement myWishlistsButton;
	
	public PageMyAccount(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getTitleMyAccount() {
		return driver.findElement(By.className("page-heading"));
	}

	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}
	
	public WebElement getMyAddressesButton() {
		return driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/ul/li[3]/a/span"));
	}

	public WebElement getMyPersonalInfoButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span"));
	}

	public WebElement getMyWishlistsButton() {
		return driver.findElement(By.className("lnk_wishlist"));
	}

	public void signOutButtonClick() {
		getSignOutButton().click();
	}
	
	public void myAddressesButtonClick() {
		getMyAddressesButton().click();
	}
	
	public void myPersonalInfoClick() {
		getMyPersonalInfoButton().click();
	}
	
	public void myWishlistsClick() {
		getMyWishlistsButton().click();
	}
	
	
}
