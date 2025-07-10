package TestCases;

import java.lang.System.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups = {"Regression","Master"})
	void verify_account_registration() {
		logger.info("*********Starting TC001_AccountRegistrationTest ");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		logger.info("*********clicked on homepage");
		
		hp.clickregister();
		logger.info("*********clicked on register");
		
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		logger.info("*********Provding customer information");
		arp.setFirstName(RandomeString().toUpperCase());
		arp.setLastName(RandomeString().toUpperCase());
		arp.setEmail(RandomeString()+"@gmail.com");
		arp.setTelephone(RandomeNumbers());
		
		String password = RandomeString();
		arp.setPassword(password);
		arp.setcnfrmPassword(password);
		arp.clickAgreeBtn();
		arp.ClickContinueBtn();
		logger.info("*****validating expected message");
		String confmsg = arp.getCOnfirmationMessage();
		
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			logger.info("****Finished TC001_AccountRegistrationTest");
	
		}
		else {
			logger.error("************TEst Failed....");
			logger.debug("Debug LOgs...");
			Assert.assertTrue(false);
		}	
		}
		catch(Exception e) {
			Assert.fail();
		}
	}  
	
}
