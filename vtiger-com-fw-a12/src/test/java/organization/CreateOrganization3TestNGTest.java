package organization;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseUtility.BaseClass;
import genericUtility.FileUtility;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.OrgPage;
import object_repository.VerifyOrgPage;

public class CreateOrganization3TestNGTest extends BaseClass {

	@Test
	public void createOrgTest() throws EncryptedDocumentException, IOException {

//      Create Organization		
//      HOME  PAGE PROCEDURE TESTNG IMPLEMENTATION

		HomePage hp = new HomePage(driver);
//      Click on the ORGANIZATION TAB		
		hp.getOrgtag().click();
//		ORGANIZATION  PAGE PROCEDURE TESTNG IMPLEMENTATION
		OrgPage op = new OrgPage(driver);
//		Click on the ADD BUTTON TAB		
		op.getOrgaddbtn().click();

		FileUtility futil = new FileUtility();
//      Get the data from from excel file		
		String orgName = futil.getStringDatafromExcelfile("Org", 3, 0) + JavaUtility.generateRandomNum();
		String websitename      = futil.getStringDatafromExcelfile("WebsiteName", 2, 0);
        String emailaddress     = futil.getStringDatafromExcelfile("EmailAddress", 4, 0);        
        int phoneno             = futil.getNumericDatafromExcelfile("PhoneNo", 5, 0);       // It's cells contain numeric value
        int employeeno          = futil.getNumericDatafromExcelfile("Employees", 1, 0);     // It's cells contain numeric value
        int revenuefigure       = futil.getNumericDatafromExcelfile("RevenueAmount", 3, 0); // It's cells contain numeric value

//		Send the Organization name to Organization TextField.        
		WebElement orgField = op.getOrgField();
		orgField.sendKeys(orgName);

//    	Send the WebSite name to WebSite TextField.
		op.getWebsite().sendKeys(websitename);

//      Send the Employees Number to Employee TextField.		        
		WebElement employeeField = op.getemployee();
		employeeField.sendKeys(String.valueOf(employeeno));

//      Send the Phone number to Phone no TextField.		
		op.getphone().sendKeys(String.valueOf(phoneno));

//		Send the Email Address to Email TextField.		
		op.getemail().sendKeys(emailaddress);

//		Send the Revenue detail to Revenue TextField.		
		op.getannualrevenue().sendKeys(String.valueOf(revenuefigure));

		WebDriverUtility wdutil = new WebDriverUtility(driver);

//		Select the Industry name in DROP DOWN.		
		WebElement indusDD = op.getIndustry();
		wdutil.selectbyindex(indusDD, 1);

		List<String> Industry = wdutil.getOptions(indusDD);
		for (String detail : Industry) {
			System.out.println("Industries name is : " + detail);
		}
		System.out.println("");

//		Select the TYPE name in DROP DOWN.	    
		WebElement typeDD = op.gettype();
		wdutil.selectbyvalue(typeDD, "Analyst");

		List<String> Type = wdutil.getOptions(typeDD);
		for (String detail : Type) {
			System.out.println("Type name is : " + detail);
		}
		System.out.println("");

//		Select the RATING name in DROP DOWN.	    
		WebElement ratingDD = op.getrating();
		wdutil.selectbyvalue(ratingDD, "Active");

		List<String> Rating = wdutil.getOptions(ratingDD);
		for (String detail : Rating) {
			System.out.println("Rating name is : " + detail);
		}
		System.out.println("");

//		Click on Save Button
		op.getsavebtn().click();

//		Verification
		VerifyOrgPage vop = new VerifyOrgPage(driver);
		String actorgname = vop.getactorgName().getText();

		Assert.assertEquals(actorgname, orgName);

//		if (actorgname.equals(orgName + "abc")) {
//		System.out.println("Created Organization successfully!!!!");
//	}   else {
//		System.out.println("Failed....");
//	}	    
		
	}
}
