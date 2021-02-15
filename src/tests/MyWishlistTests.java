package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishlistTests extends TestBase {

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
		
		String emailAddress = excelReader.getStringData("Login", 7, 3);
		String password = excelReader.getStringData("Login", 8, 3);
		logIn(emailAddress, password);
		pageMyAccount.myWishlistsClick();
	}
	
	@Test (priority = 1)
	public void addWishlist() throws InterruptedException {
		String wishlist = excelReader.getStringData("My wishlists", 6, 3);
		
		pageMyWishlists.inputNewWishlist(wishlist);
		pageMyWishlists.saveButtonClick();
		
		int wishlistNumber = excelReader.getIntData("My wishlists", 8, 3);
		int numberOfWishlists = pageMyWishlists.getWishlists().size();
		Assert.assertEquals(wishlistNumber, numberOfWishlists);
		
		pageMyWishlists.deleteButtonClick();
	}
	
	@Test (priority = 5)
	public void addMultipleWishlist() throws InterruptedException {
		String wishlist1 = excelReader.getStringData("My wishlists", 16, 3);
		String wishlist2 = excelReader.getStringData("My wishlists", 18, 3);
		String wishlist3 = excelReader.getStringData("My wishlists", 20, 3);
		
		pageMyWishlists.addThreeWishlists(wishlist1, wishlist2, wishlist3);
		
		int wishlists = excelReader.getIntData("My wishlists", 22, 3);
		int numberOfWishlists = pageMyWishlists.getWishlists().size();
		Assert.assertEquals(wishlists, numberOfWishlists);
	}
	
	@Test (priority = 10)
	public void removeWishlist() throws InterruptedException {
	
		pageMyWishlists.deleteAllWishlists();
	
		int wishlists = excelReader.getIntData("My wishlists", 31, 3);
		int numberOfWishlists = pageMyWishlists.getWishlists().size();
		Assert.assertEquals(wishlists, numberOfWishlists);
	}
	
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		pageMyAccount.signOutButtonClick();
		driver.navigate().refresh();
		Thread.sleep(1000);
	}

}
