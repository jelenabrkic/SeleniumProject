package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

	WebDriver driver;
	
	WebElement signInButton;
	WebElement addToCartButton;
	WebElement addToCartButton2;
	WebElement addToCartButton3;
	WebElement continueShoppingButton;
	WebElement proceedToCheckoutButton;
	WebElement product;
	WebElement product2;
	WebElement product3;
	WebElement moreButton;
	
	Actions actions;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}
	
	public WebElement getProduct() {
		return driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
	}
	
	public WebElement getProduct2() {
		return driver.findElement(By.xpath("//img[@title='Blouse']"));
	}

	public WebElement getProduct3() {
		return driver.findElement(By.xpath("//img[@title='Printed Dress']"));
	}

	public WebElement getAddToCartButton() {
		return driver.findElement(By.xpath("//a[@title='Add to cart']"));
	}

	public WebElement getAddToCartButton2() {
		return driver.findElement(By.xpath("(//a[@title='Add to cart'])[2]"));
	}
	
	public WebElement getAddToCartButton3() {
		return driver.findElement(By.xpath("(//a[@title='Add to cart'])[3]"));
	}

	public WebElement getContinueShoppingButton() {
		return driver.findElement(By.xpath("//span[@title='Continue shopping']"));
	}

	public WebElement getProceedToCheckoutButton() {
		return driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
	}

	public WebElement getMoreButton() {
		return driver.findElement(By.xpath("//a[@title='View']"));
	}


	public void navigateToSignInPage() {
		getSignInButton().click();
	}
	
	public void addToCartClick() {
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(ExpectedConditions.elementToBeClickable(getAddToCartButton()));
			getAddToCartButton().click();
		} 
		catch (Exception e) 
		{
			System.out.println("\"Add to cart\" button is not displayed");
		}
	}
	
	public void continueShoppingClick() {
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 7);
			wait.until(ExpectedConditions.elementToBeClickable(getContinueShoppingButton()));
			getContinueShoppingButton().click();
		} 
		catch (Exception e) 
		{
			System.out.println("\"Continue shopping\" button is not displayed");
		}
	}
	
	public void proceedToCheckoutClick() {
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 7);
			wait.until(ExpectedConditions.elementToBeClickable(getProceedToCheckoutButton()));
			getProceedToCheckoutButton().click();
		} 
		catch (Exception e) 
		{
			System.out.println("\"Proceed to checkout\" button is not displayed");
		}
	}
	
	public void moreButtonClick() {
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(getMoreButton()));
			getMoreButton().click();
		} 
		catch (Exception e) 
		{
			System.out.println("\"More\" button is not displayed");
		}
	}
	
	public void addThreeProductsToCart() throws InterruptedException {
		actions.moveToElement(getProduct()).perform();
		addToCartClick();
		continueShoppingClick();
		actions.moveToElement(getProduct2()).perform();
		Thread.sleep(1000);
		getAddToCartButton2().click();
		continueShoppingClick();
		actions.moveToElement(getProduct3()).perform();
		Thread.sleep(1000);
		getAddToCartButton3().click();
		proceedToCheckoutClick();
		Thread.sleep(2000);
	}
}
