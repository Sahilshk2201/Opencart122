package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountpage;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void Verify_Login() {
		logger.info("**********Starting TC002_LoginTest ");
		
		try {
			
		//homepage
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		//loginpage
		LoginPage lp = new LoginPage(driver);
		lp.setMailAddress(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickSubmit();
		
		//MyAccountPage
		MyAccountpage MAcc = new MyAccountpage(driver);
		boolean targetpage = MAcc.ismyAccountPageExists();
		
		//Assert.assertEquals(targetpage, true,"Login Failed");
		Assert.assertTrue(targetpage);
		}
		catch(Exception e) {
			Assert.fail();
		logger.info("**********TC002_LoginTest Failed");
		}
		logger.info("**********Finished TC002_LoginTest ");
	}

} 
