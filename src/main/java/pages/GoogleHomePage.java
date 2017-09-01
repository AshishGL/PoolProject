package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class GoogleHomePage extends PageBase {
	
	public GoogleHomePage(WebDriver driver) {
		super(driver);
	}
	
	/*******************************************************************************************
	 * All WebElements are identified by @FindBy annotation
	 *******************************************************************************************/
	
	
	WebDriver driver;
	//Web Element for Google Search Box
	@FindBy(name="q")
	WebElement searchBox;

}
