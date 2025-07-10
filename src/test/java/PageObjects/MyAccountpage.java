package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountpage extends BasePage{

//constructor 
	public MyAccountpage(WebDriver driver) {
		super(driver);
	}
	
//locator
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") 
	WebElement msgHeading;

	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") 
	WebElement logout;

// Action Methods
	
	public boolean ismyAccountPageExists() {
		try {
			return msgHeading.isDisplayed();	
		}catch(Exception e) {
			return false;
		}
		
	}

	public void clickLogout() {
		logout.click();
	}
}
