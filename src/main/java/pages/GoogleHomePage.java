package pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class GoogleHomePage extends PageBase {

	


	public GoogleHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/*******************************************************************************************
	 * All WebElements are identified by @FindBy annotation
	 *******************************************************************************************/
	
	
	WebDriver driver;
	
	//Web Element for Google Search Box
	@FindBy(name="q")
	WebElement searchBox;
	
	public void enterTextToSearch(String textString)
	{
		log.info("Searched String is "+textString);
		searchBox.sendKeys(textString);	
		
	}

}
