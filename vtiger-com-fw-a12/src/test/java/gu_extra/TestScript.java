package gu_extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtility.WebDriverUtility;

public class TestScript {
	
	public static void main(String... args) {
		
		WebDriver driver = new ChromeDriver();
		  
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		
	//open the WebSite for performing the Automation.
		wdutil.url();
	//open the WebSite for performing the Automation in Maximize Window	
		wdutil.winmax();
		
	  WebElement profilepic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
    /*
		 * Actions act = new Actions(driver);
		 * act.moveToElement(profilepic).build().perform();
	*/ 	  
	  wdutil.hover(profilepic);
		
	}

}
