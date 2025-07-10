package TestCases;
import org.testng.Assert;
/*
 * Data is valid - login success - test pass - logout
 * Data is valid - login fail - test failed 
 * 
 * Data is invalid - login success - test fail - logout
 * Data is invalid - login failed - test pass 	
 */
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountpage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	

@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="DataDriven") // getting data providers from different class 
public void	verify_LoginDDT(String email,String pwd, String exp) 
{
	
	logger.info("*********Starting TC003_LoginDDT");
	
	try {	
	//homepage
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
				
	//loginpage
		LoginPage lp = new LoginPage(driver);
		lp.setMailAddress(email);
		lp.setPassword(pwd);
		lp.clickSubmit();
				
	//MyAccountPage
		MyAccountpage MAcc = new MyAccountpage(driver);
		boolean targetpage = MAcc.ismyAccountPageExists();
			
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				MAcc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				MAcc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	    }
	catch(Exception e){
	Assert.fail("An Exception occured "+ e.getMessage());
		}
	logger.info("**** Finished TC_003_LoginDDT *****");

	}
}