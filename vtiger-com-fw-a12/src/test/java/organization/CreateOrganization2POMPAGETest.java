package organization;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.OrgPage;
import object_repository.VerifyOrgPage;


public class CreateOrganization2POMPAGETest {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
	    FileUtility futil = new FileUtility();	

//	    GET THE DATA FROM PROPERTIES FILE:	
	    String BROWSER  = futil.getDataFromPropertiesFile("bro");
	    String URL      = futil.getDataFromPropertiesFile("url");
//	    String USERNAME = futil.getDataFromPropertiesFile("un");
//	    String PASSWORD = futil.getDataFromPropertiesFile("pwd");
	
//      Open Browser	
		WebDriver driver = null;
		
		if (BROWSER.equalsIgnoreCase("chrome")) { 
			 driver = new ChromeDriver(); 
		} else if (BROWSER.equalsIgnoreCase("edge")) { 
			driver = new EdgeDriver(); 
		} else if (BROWSER.equalsIgnoreCase("firefox")) { 
			driver = new FirefoxDriver(); 
		} else {  
			driver = new ChromeDriver();      // Default to Chrome 
		}
		
		WebDriverUtility wdutil = new WebDriverUtility(driver);
		wdutil.winmax();
		
		wdutil.implicitlywait();
		
//		wdutil.url();
		driver.get(URL);
		
//      Get the data from from excel file
		String orgname          = futil.getStringDatafromExcelfile("Org",3, 0) + JavaUtility.generateRandomNum();
        String websitename      = futil.getStringDatafromExcelfile("WebsiteName", 2, 0);
        String emailaddress     = futil.getStringDatafromExcelfile("EmailAddress", 4, 0);        
        int phoneno             = futil.getNumericDatafromExcelfile("PhoneNo", 5, 0);       // It's cells contain numeric value
        int employeeno          = futil.getNumericDatafromExcelfile("Employees", 1, 0);     // It's cells contain numeric value
        int revenuefigure       = futil.getNumericDatafromExcelfile("RevenueAmount", 3, 0); // It's cells contain numeric value
			
//      LOGIN PAGE Procedure POM IMPLEMENTATION
		LoginPage log = new LoginPage(driver);
		
		log.login();
		
		Thread.sleep(2000);
		
//      HOME  PAGE PROCEDURE POM IMPLEMENTATION
		
		HomePage homep = new HomePage(driver);
		
//      Click on the ORGANIZATION TAB		
		homep.getOrgtag().click();
		
//		ORGANIZATION  PAGE PROCEDURE POM IMPLEMENTATION
		OrgPage org = new OrgPage(driver);
		
//		Click on the ADD BUTTON TAB
		org.getOrgaddbtn().click();;

		
//		Send the Organization name to Organization TextField.
		WebElement orgfield = org.getOrgField();
		orgfield.sendKeys(orgname);

//		Send the WebSite name to WebSite TextField.
		org.getWebsite().sendKeys(websitename);
		
//		Send the Employees Number to Employee TextField.		
		org.getemployee().sendKeys(String.valueOf(employeeno));

//		Send the Phone number to Phone no TextField.		
		org.getphone().sendKeys(String.valueOf(phoneno));

//		Send the Email Address to Email TextField.		
		org.getemail().sendKeys(emailaddress);
		
//		Send the Revenue detail to Revenue TextField.		
		org.getannualrevenue().sendKeys(String.valueOf(revenuefigure));
		
//		Select the Industry name in DROP DOWN.		
		WebElement indusDD = org.getIndustry();
		wdutil.selectbyindex(indusDD, 1);
		
	    List<String> Industry = wdutil.getOptions(indusDD);    
	    for (String detail : Industry) {	    	
	    System.out.println("Industries name is : "+ detail);
		}
	    
	    System.out.println("");
	    
	    Thread.sleep(1000);
	    
//		Select the TYPE name in DROP DOWN.	    
	    WebElement typeDD = org.gettype();
		wdutil.selectbyvalue(typeDD,"Analyst");
		
		List<String> Type = wdutil.getOptions(typeDD);
	    for (String detail : Type) {
	    	System.out.println("Type name is : "+ detail);
		}
	    
	    System.out.println("");
	    
	    Thread.sleep(1000);
	    
//		Select the RATING name in DROP DOWN.	    
	    WebElement ratingDD = org.getrating();
        wdutil.selectbyvalue(ratingDD, "Active");
		
        List<String> Rating = wdutil.getOptions(ratingDD);
	    for (String detail : Rating) {
	    	System.out.println("Rating name is : "+ detail);
		}
	    
	    System.out.println("");
	    
	    Thread.sleep(1000);
	    
//		Click on Save Button
	    org.getsavebtn().click();
	    
//	    Verification PAGE PROCEDURE POM IMPLEMENTATION
	    VerifyOrgPage verifyop = new  VerifyOrgPage(driver);
	    
//		Verification
	    String actOrgName = verifyop.getactorgName().getText();
		
		if (actOrgName.equals(orgname)) {
			System.out.println("Created Organization successfully!!!!");
		} else {
			System.out.println("Failed....");
		}
		
//		Logout 
		WebElement ProfilePic= homep.getProfilePic();
		
	    wdutil.hover(ProfilePic);
	    
	    Thread.sleep(2000);
	    
//	    Click on SignOut Button
		homep.getSignoutBtn().click();
	    
		Thread.sleep(3000);
		
//      Close Browser		
		driver.quit();
	}	
}
