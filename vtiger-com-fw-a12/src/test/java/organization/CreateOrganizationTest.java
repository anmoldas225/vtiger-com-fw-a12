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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationTest {

	public static void main(String... args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		
		 FileInputStream fis = new FileInputStream("./src/main/resources/testScriptData.xlsx");
			
			Workbook wb = WorkbookFactory.create(fis);
			
			Sheet sh = wb.getSheet("Org");
			
			Row row = sh.getRow(8);
			
			Cell cell = row.getCell(0);
			
			String orgn = cell.getStringCellValue() + (int)(Math.random()*1000);
			
			System.out.println(orgn + (int)(Math.random()*1000));
			
		//Login Procedure
		WebElement un = driver.findElement(By.cssSelector("input[name='user_name']"));
		un.sendKeys("admin");

		WebElement pwd = driver.findElement(By.cssSelector("input[name='user_password']"));
		pwd.sendKeys("manager");
		
		WebElement loginbtn = driver.findElement(By.id("submitButton"));
		loginbtn.click();
		
		//Add Data to Organization Module with the help of Automation
		
		WebElement org = driver.findElement(By.linkText("Organizations"));
		org.click();
		
		WebElement addbtn = driver.findElement(By.cssSelector("img[alt='Create Organization...']"));
		addbtn.click();
		
		WebElement organ = driver.findElement(By.cssSelector("input[name='accountname']"));
		//String organname = "automationWithPiyush01";
		organ.sendKeys(orgn);
		
		WebElement website = driver.findElement(By.cssSelector("input[name='website']"));
		website.sendKeys("https://www.facebook.com/");
		
		WebElement emp = driver.findElement(By.id("employees"));
		emp.sendKeys("4");
		
		WebElement pno = driver.findElement(By.id("phone"));
		pno.sendKeys("99505074");
		
		WebElement email = driver.findElement(By.id("email1"));
		email.sendKeys("anmol5674747@gmail.com");
		
		WebElement revenue = driver.findElement(By.cssSelector("input[name='annual_revenue']"));
		revenue.sendKeys("5000000");
		
		
		WebElement indusDD = driver.findElement(By.xpath("//select[@name='industry']"));
		Select sel = new Select(indusDD);
		sel.selectByIndex(1);
		
	    List<WebElement> industry = sel.getOptions();
	    
	    for (WebElement i : industry) {
	    	
	    	System.out.println("Industries name is : "+ i.getText());
			
		}
	    System.out.println("");
	    Thread.sleep(1000);
	    
	    
	    WebElement typeDD = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select seltyp = new Select(typeDD);
		seltyp.selectByValue("Analyst");
		
	    List<WebElement> type = sel.getOptions();
	    
	    for (WebElement i : type) {
	    	
	    	System.out.println("Type name is : "+ i.getText());
			
		}
	    System.out.println("");
	    Thread.sleep(1000);
	    
	    WebElement ratingDD = driver.findElement(By.xpath("//select[@name='rating']"));
		Select selrate = new Select(ratingDD);    
		selrate.selectByValue("Active");

		
	    List<WebElement> rating = sel.getOptions();
	    
	    for (WebElement i : rating) {
	    	
	    	System.out.println("Rating name is : "+ i.getText());
			
		}
	    System.out.println("");
	    Thread.sleep(1000);
	    
//		Save 
	    driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
	    
//		Verification
	    String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		if (actOrgName.equals(orgn)) {
			System.out.println("Created Organization successfully!!!!");
		}else {
			System.out.println("Failed....");
		}
		
	    WebElement profilepic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	    Actions act = new Actions(driver);
	    act.moveToElement(profilepic).build().perform();
	    
	    Thread.sleep(2000);
	    
		driver.findElement(By.linkText("Sign Out")).click();
	    
		Thread.sleep(3000);
		
		wb.close();
		driver.quit();
	}
	
}
