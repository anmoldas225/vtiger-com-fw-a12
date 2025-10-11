package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtility.FileUtility;
import genericUtility.WebDriverUtility;

public class CreateOrganization1Test {

	public static void main(String... args) throws InterruptedException, EncryptedDocumentException, IOException {

	    FileUtility futil = new FileUtility();	

//	    GET THE DATA FROM PROPERTIES FILE:	
	    String BROWSER = futil.getDataFromPropertiesFile("bro");
	    String URL = futil.getDataFromPropertiesFile("url");
	    String USERNAME = futil.getDataFromPropertiesFile("un");
	    String PASSWORD = futil.getDataFromPropertiesFile("pwd");
	
//      Open Browser	
		WebDriver driver = null;
		
		if (BROWSER.equalsIgnoreCase("chrome")) { 
			 driver = new ChromeDriver(); 
		} else if (BROWSER.equalsIgnoreCase("edge")) { 
			driver = new EdgeDriver(); 
		} else if (BROWSER.equalsIgnoreCase("firefox")) { 
			driver = new FirefoxDriver(); 
		} else {  
			driver = new ChromeDriver(); // Default to Chrome 
		}
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		wdutil.winmax();
		wdutil.implicitlywait();
		
//		wdutil.url();
		driver.get(URL);
		
//      Get the data from from excel file
        String orgname       = futil.getStringDatafromExcelfile("Org",3, 0);
        String employeeno    = futil.getStringDatafromExcelfile("Website", 1, 0);
        String phoneno       = futil.getStringDatafromExcelfile("PhoneNo", 5, 0);
        String emailaddress  = futil.getStringDatafromExcelfile("EmailAddress", 4, 0);
        String websitename   = futil.getStringDatafromExcelfile("WebsiteName", 2, 0);
        String revenuefigure = futil.getStringDatafromExcelfile("RevenueAmount", 3, 0);
        
//      Login Procedure
		WebElement un = driver.findElement(By.cssSelector("input[name='user_name']"));
		un.sendKeys(USERNAME);

		WebElement pwd = driver.findElement(By.cssSelector("input[name='user_password']"));
		pwd.sendKeys(PASSWORD);
		
		WebElement loginbtn = driver.findElement(By.id("submitButton"));
		loginbtn.click();
		
//      Add Data to Organization Module with the help of Automation

//      Click on the ORGANIZATION TAB		
		driver.findElement(By.linkText("Organizations")).click();;
		
//		Click on the ADD BUTTON TAB
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

//		Send the Organization name to Organization TextField.
		WebElement orgfield = driver.findElement(By.cssSelector("input[name='accountname']"));
//      String organname = "automationWithPiyush01";
		orgfield.sendKeys(orgname);

//		Send the WebSite name to WebSite TextField.
		driver.findElement(By.cssSelector("input[name='website']")).sendKeys(websitename);
		
//		Send the Employees Number to Employee TextField.		
		driver.findElement(By.id("employees")).sendKeys(employeeno);

//		Send the Phone number to Phone no TextField.		
		driver.findElement(By.id("phone")).sendKeys(phoneno);

//		Send the Email Address to Email TextField.		
		driver.findElement(By.id("email1")).sendKeys(emailaddress);
		
//		Send the Revenue detail to Revenue TextField.		
		driver.findElement(By.cssSelector("input[name='annual_revenue']")).sendKeys(revenuefigure);
		
//		Select the Industry name in DROP DOWN.		
		WebElement indusDD = driver.findElement(By.xpath("//select[@name='industry']"));
		wdutil.selectbyindex(indusDD, 1);
		
	    List<String> Industry = wdutil.getOptions(indusDD);    
	    for (String detail : Industry) {	    	
	    System.out.println("Industries name is : "+ detail);
		}
	    
	    System.out.println("");
	    Thread.sleep(1000);
	    
//		Select the TYPE name in DROP DOWN.	    
	    WebElement typeDD = driver.findElement(By.xpath("//select[@name='accounttype']"));
		wdutil.selectbyvalue(typeDD,"Analyst");
		
		List<String> Type = wdutil.getOptions(typeDD);
	    for (String detail : Type) {
	    	System.out.println("Type name is : "+ detail);
		}
	    
	    System.out.println("");
	    Thread.sleep(1000);
	    
//		Select the RATING name in DROP DOWN.	    
	    WebElement ratingDD = driver.findElement(By.xpath("//select[@name='rating']"));
        wdutil.selectbyvalue(ratingDD, "Active");
		
        List<String> Rating = wdutil.getOptions(ratingDD);
	    for (String detail : Rating) {
	    	System.out.println("Rating name is : "+ detail);
		}
	    System.out.println("");
	    Thread.sleep(1000);
	    
//		Click on Save Button
	    driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
	    
//		Verification
	    String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		if (actOrgName.equals(orgname)) {
			System.out.println("Created Organization successfully!!!!");
		} else {
			System.out.println("Failed....");
		}
		
//		Logout
	    WebElement profilepic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
//	    Actions act = new Actions(driver);
//	    act.moveToElement(profilepic).build().perform();
	    wdutil.hover(profilepic);
	    
	    Thread.sleep(2000);
	    
//	    Click on SignOut Button
		driver.findElement(By.linkText("Sign Out")).click();
	    
		Thread.sleep(3000);
		
//      close Browser		
		driver.quit();
	}

}