package Ashish.TestProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

@Listeners(Ashish.TestProject.Listener.class)

public class NewTest{
	
	
	 private WebDriver driver;
	 //@Parameters("browser")
	 
	 SoftAssert softAssert=new SoftAssert();
  
@Test(priority=1)
  public void googleTitleCheck() {
	
	driver.get("https://www.google.com");
	System.out.println(driver.getTitle());
	Assert.assertEquals("Google", "Google");
  }
@Test(priority=0)
public void facebookTitleCheck() {
	
	driver.get("https://www.facebook.com");
	System.out.println(driver.getTitle());
	System.out.println("==============Soft Assertion: Before Test case failed======================");
	softAssert.assertEquals("Facebook", "Ashish");
	softAssert.assertEquals("fail1", "fail2");
	softAssert.assertEquals("Facebook", "Facebook");
	softAssert.assertAll();
	
}
//@Test(priority=2, retryAnalyzer=Ashish.TestProject.RetryAnalyzer.class)
@Test(priority=3)
public void failedRetryTest() {
	
	driver.get("https://www.amazon.com");
	System.out.println(driver.getTitle());
	System.out.println("==============Hard Assertion: Before Test case failed======================");
	Assert.assertEquals("Amazon", "Invalid");
	System.out.println("==============Hard Assertion: After Test case failed======================");
	
}

  @Parameters("browser")
  @BeforeMethod
  public void beforeTest(String browser) {
	  System.out.println("1");
	  if(browser.equalsIgnoreCase("chrome"))
	  {
	  driver=new ChromeDriver();
	  }
	  
	  else if(browser.equalsIgnoreCase("safari"))
	  {
		  driver=new SafariDriver();
		  
	  }
	  driver.switchTo().window(driver.getWindowHandle());
	  driver.manage().window().maximize();
      System.out.println("2");
  }

  @AfterMethod
  public void afterTest() {
	  
	  driver.quit();
  }

}
