/**
 * 
 */
package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.AccountRegistrationPage;
import PageObjects.CheckoutPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountpage;
import PageObjects.SearchPage;
import PageObjects.ShoppingCartPage;

@Test
public class TC_006_EndToEndTest extends BaseClass {
	public void endToendTest() throws InterruptedException
	{
	//Soft assertions
		SoftAssert myassert=new SoftAssert();
		
	//Account Registration
	System.out.println("Account Registration................");
	HomePage hp = new HomePage(driver);
	hp.clickmyaccount();
	hp.clickregister();
	
	AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
	regpage.setFirstName(RandomeString().toUpperCase());
	regpage.setLastName(RandomeString().toUpperCase());
	
	String email=RandomeString() + "@gmail.com";
	regpage.setEmail(email);// randomly generated the email
			
	regpage.setTelephone("1234567");
	regpage.setPassword("test123");
	regpage.setcnfrmPassword("test123");
	regpage.clickAgreeBtn();;
	regpage.ClickContinueBtn();
	Thread.sleep(3000);

	String confmsg = regpage.getCOnfirmationMessage();
	System.out.println(confmsg);
	
	AssertJUnit.assertEquals(confmsg, "Your Account Has Been Created!"); //validation
	
	MyAccountpage mc=new MyAccountpage(driver);
	mc.clickLogout();
	Thread.sleep(3000);
	
	
	//Login
	System.out.println("Login to application...............");
	hp.clickmyaccount();
	hp.clicklogin();
	
	LoginPage lp=new LoginPage(driver);
	lp.setMailAddress(email);
	lp.setPassword("test123");
	lp.clickSubmit();;
		
	
	System.out.println("Going to My Account Page? "+ mc.ismyAccountPageExists());
	AssertJUnit.assertEquals(mc.ismyAccountPageExists(), true); //validation

	
	//search & add product to cart
	System.out.println("search & add product to cart...............");
	hp.enterProductName(p.getProperty("searchProductName"));
	hp.clickSearch();
	
	SearchPage sp=new SearchPage(driver);
	
	if(sp.isProductExist(p.getProperty("searchProductName")))
	{
		sp.selectProduct(p.getProperty("searchProductName"));
		sp.setQuantity("2");
		sp.addToCart();
		
	}
	Thread.sleep(3000);
	System.out.println("Added product to cart ? "+ sp.checkConfMsg());
	AssertJUnit.assertEquals(sp.checkConfMsg(),true);
		
		
	//Shopping cart
	System.out.println("Shopping cart...............");
	ShoppingCartPage sc=new ShoppingCartPage(driver);
	sc.clickItemsToNavigateToCart();
	sc.clickViewCart();
	Thread.sleep(3000);
	String totprice=sc.getTotalPrice();
	System.out.println("total price is shopping cart: "+totprice);
	AssertJUnit.assertEquals(totprice, "$246.40");   //validation
	sc.clickOnCheckout(); //navigate to checkout page
	Thread.sleep(3000);
	
	
	//Checkout Product
	System.out.println("Checkout Product...............");
	CheckoutPage ch=new CheckoutPage(driver);
	
	ch.setfirstName(RandomeString().toUpperCase());
	Thread.sleep(1000);
	ch.setlastName(RandomeString().toUpperCase());
	Thread.sleep(1000);
	ch.setaddress1("address1");
	Thread.sleep(1000);
	ch.setaddress2("address2");
	Thread.sleep(1000);
	ch.setcity("Delhi");
	Thread.sleep(1000);
	ch.setpin("500070");
	Thread.sleep(1000);
	ch.setCountry("India");
	Thread.sleep(1000);
	ch.setState("Delhi");
	Thread.sleep(1000);
	ch.clickOnContinueAfterBillingAddress();
	Thread.sleep(1000);
	ch.clickOnContinueAfterDeliveryAddress();
	Thread.sleep(1000);
	ch.setDeliveryMethodComment("testing...");
	Thread.sleep(1000);
	ch.clickOnContinueAfterDeliveryMethod();
	Thread.sleep(1000);
	ch.selectTermsAndConditions();
	Thread.sleep(1000);
	ch.clickOnContinueAfterPaymentMethod();
	Thread.sleep(2000);
	
	String total_price_inOrderPage=ch.getTotalPriceBeforeConfOrder();
	System.out.println("total price in confirmed order page:"+total_price_inOrderPage);
	AssertJUnit.assertEquals(total_price_inOrderPage, "$207.00"); //validation
	
	//Below code works only if you configure SMTP for emails 
	/*ch.clickOnConfirmOrder();
	Thread.sleep(3000);
		
	boolean orderconf=ch.isOrderPlaced();
	System.out.println("Is Order Placed? "+orderconf);
	myassert.assertEquals(ch.isOrderPlaced(),true);*/
		
	myassert.assertAll(); //conclusion
}

}


