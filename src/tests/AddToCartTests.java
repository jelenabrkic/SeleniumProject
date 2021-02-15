package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTests extends TestBase {

	JavascriptExecutor js;
	Actions actions;
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		this.js = (JavascriptExecutor) driver;
		this.actions = new Actions(driver);
		
		driver.navigate().to("http://automationpractice.com/index.php");
		Thread.sleep(2000);
	}
	
	@Test (priority = 1)
	public void addOneProduct() throws InterruptedException {
		String productName = excelReader.getStringData("Add product to cart", 9, 3);
		
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		
		actions.moveToElement(mainPage.getProduct()).perform();
		mainPage.addToCartClick();
		Thread.sleep(5000);
		mainPage.proceedToCheckoutClick();
		Thread.sleep(5000);
		
		String assertProductName = pageCart.getProductName().getText();
		Assert.assertEquals(assertProductName, productName);
	}
	
	@Test (priority = 5)
	public void addOneProductQuantityIsThree() throws InterruptedException {
		String quantity = String.valueOf(excelReader.getIntData("Add product to cart", 19, 3));
		String quantityCart = String.valueOf(excelReader.getIntData("Add product to cart", 23, 3));
		
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		
		actions.moveToElement(mainPage.getProduct()).perform();
		mainPage.moreButtonClick();
		pageProductDetails.inputQuantity(quantity);
		pageProductDetails.addToCartButtonClick();
		mainPage.proceedToCheckoutClick();
		
		Thread.sleep(2000);
		
		String quantityFromCart = pageCart.getQuantity().getAttribute("value");
		Assert.assertEquals(quantityCart, quantityFromCart);
		
		pageCart.deleteClick();
	}
	
	@Test (priority = 10)
	public void addMultipleProducts() throws InterruptedException {
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(2000);
		
		mainPage.addThreeProductsToCart();
		
		int numberOfDeleteButtons = excelReader.getIntData("Add product to cart", 36, 3);
		int deleteButtons = pageCart.getDeleteButtons().size();
		Assert.assertEquals(numberOfDeleteButtons, deleteButtons);
		
		pageCart.deleteAllProducts();
	}
	
	@Test (priority = 15)
	public void deleteProduct() throws InterruptedException {
		addOneProduct();
		pageCart.deleteAllProducts();
		Thread.sleep(5000);
		
		int numberOfDeleteButtons = excelReader.getIntData("Add product to cart", 45, 3);
		int deleteButtons = pageCart.getDeleteButtons().size();
		Assert.assertEquals(numberOfDeleteButtons, deleteButtons);
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.navigate().refresh();
	}
}
