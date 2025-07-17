package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//Constructor
public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
//locator
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement myAccount;

	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(xpath="//a[normalize-space()='Login']") 
	WebElement login;
	
	@FindBy(xpath="//input[@placeholder='Search']")  //For Search Product Test
	WebElement txtSearchbox;

	@FindBy(xpath="//div[@id='search']//button[@type='button']") //For Search Product Test
	WebElement btnSearch;

// Action Method 

public void clickmyaccount() {
	myAccount.click();
}	

public void clickregister() {
	register.click();
}

public void clicklogin() {
	login.click();
}

public void enterProductName(String pName)   //For Search Product Test
{
	txtSearchbox.sendKeys(pName);
}

public void clickSearch()  //For Search Product Test
{
	btnSearch.click();
}
}