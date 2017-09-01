package base;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;


public abstract class TestBase {
	
	
	public static Properties env=null;
	public static Logger log=null;
	public static Properties config=null;
	public static WebDriver driver=null;
	public static WebDriverWait wait=null;
	private static boolean isInitialized=false;
	
	//Checking whether the driver is already initiated or not
	protected TestBase()
	{
		if(!isInitialized)
		{
			initDriver();
			
		}
		
	}
//Initializing the driver
	private static void initDriver() {
		// TODO Auto-generated method stub
		
		
		if(config.getProperty("browser").equalsIgnoreCase("Google Chrome")||config.getProperty("Browser").equalsIgnoreCase("Chrome"))
		{	
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			//capabilities.setCapability("chrome.binary",System.getProperty("user.dir")+ File.separator +"drivers"+ File.separator +"chromedriver.exe");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			log.info(config.getProperty("browser")+" driver is initialized..");
		}
		
		else if(config.getProperty("browser").equalsIgnoreCase("Safari"))
		{	
			driver=new SafariDriver();
			log.info(config.getProperty("browser")+ "driver is initiated...");
		}
		
		String waitTime="30";
		
		driver.manage().timeouts().implicitlyWait(Long.parseLong(waitTime), TimeUnit.SECONDS);
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().maximize();
		
	}	
	@AfterSuite
	public void tearDown() {
		quitDriver();
	}

	public static void quitDriver() {

		driver.quit();
		driver = null;
		log.info("Closing Browser.");

	}
}
