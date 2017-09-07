package base;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public abstract class TestBase {
	
	
	public static Properties env=null;
	public static Logger log=null;
	public static Properties config=null;
	public static WebDriver driver=null;
	public static WebDriverWait wait=null;
	public static boolean isInitalized=false;
	
	
	protected TestBase() {
		if(!isInitalized){
			initLogs();
			
			initDriver();
		}
	}
	
	
//Initializing the driver
	private static void initLogs(){
		if (log == null){
			// Initialize Log4j logs

			DOMConfigurator.configure(System.getProperty("user.dir")+File.separator+"config"+File.separator+"log4j.xml");
			log = Logger.getLogger("MyLogger");
			log.info("Logger is initialized..");
		}
		
	}
	private static void initDriver() {
		// TODO Auto-generated method stub
		
		
		//if(config.getProperty("browser").equalsIgnoreCase("Google Chrome")||config.getProperty("Browser").equalsIgnoreCase("Chrome"))
			boolean flag=true;
			if(flag==true)
		{	
			//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("test-type");
			//capabilities.setCapability("chrome.binary",System.getProperty("user.dir")+ File.separator +"drivers"+ File.separator +"chromedriver.exe");
			//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver();
			log.info("Chrome driver is initialized..");
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
