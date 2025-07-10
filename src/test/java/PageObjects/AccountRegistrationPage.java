package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
// constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
// locators

@FindBy(xpath="//input[@id='input-firstname']") 
WebElement firstName;

@FindBy(xpath="//input[@id='input-lastname']") 
WebElement lastName;

@FindBy(xpath="//input[@id='input-email']") 
WebElement Mail;

@FindBy(xpath="//input[@id='input-telephone']") 
WebElement telephone;

@FindBy(xpath="//input[@id='input-password']") 
WebElement password;

@FindBy(xpath="//input[@id='input-confirm']") 
WebElement passwordConfirm;

@FindBy(xpath="//input[@value='Continue']") 
WebElement continue_btn;

@FindBy(xpath="//input[@name='agree']") 
WebElement agree_btn;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") 
WebElement msgAccountCreated;



//Action Methods
 public void setFirstName(String fname) {
	 firstName.sendKeys(fname);
}
 
 public void setLastName(String lname) {
	 lastName.sendKeys(lname);
}
 
 public void setEmail(String ml) {
	 Mail.sendKeys(ml);
}
 
 public void setTelephone(String tl) {
	 telephone.sendKeys(tl);
}

 public void setPassword(String pswd) {
	 password.sendKeys(pswd);
}
 
 public void setcnfrmPassword(String pswd) {
	 passwordConfirm.sendKeys(pswd);
}
 
 public void clickAgreeBtn() {
	 agree_btn.click();;
}
 
 public void ClickContinueBtn() {
	 continue_btn.click();
//   sol2
//	 continue_btn.submit();
// 
// 	 and many other solutions if click button is not working
}
 
 public String getCOnfirmationMessage() {
	try {
		return(msgAccountCreated.getText());
	}catch(Exception e) {
		return(e.getMessage());
	}
 }
}
