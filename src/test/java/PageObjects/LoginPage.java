package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

//constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
//locators

@FindBy(xpath="//input[@id='input-email']") 
WebElement MailAddress;

@FindBy(xpath="//input[@id='input-password']") 
WebElement password;

@FindBy(xpath="//input[@value='Login']") 
WebElement btn_login;


// Action Methods

public void setMailAddress(String mail){
	MailAddress.sendKeys(mail);
}

public void setPassword(String psswrd){
	password.sendKeys(psswrd);
}

public void clickSubmit() {
	btn_login.click();
}

}
