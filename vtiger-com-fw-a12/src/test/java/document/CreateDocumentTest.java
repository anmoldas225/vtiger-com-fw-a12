package document;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateDocumentTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888/");
		
		
		//Login Procedure
		WebElement un = driver.findElement(By.cssSelector("input[name='user_name']"));
		un.sendKeys("admin");

		WebElement pwd = driver.findElement(By.cssSelector("input[name='user_password']"));
		pwd.sendKeys("manager");
		
		WebElement loginbtn = driver.findElement(By.id("submitButton"));
		loginbtn.click();

		WebElement documents = driver.findElement(By.linkText("Documents"));
		documents.click();
		
		WebElement documentsaddbtn = driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']"));
		documentsaddbtn.click();
		
		WebElement title = driver.findElement(By.cssSelector("input[name='notes_title']"));
		String titl="A12SUPERSTAR";
		title.sendKeys(titl);
		
		
        WebElement notes = driver.findElement(By.xpath("//td[@id=\"cke_contents_notecontent\"]/iframe"));
        notes.sendKeys("This document was created via Selenium automation script.");
        
        WebElement fileupload= driver.findElement(By.id("filename_I__"));
        fileupload.sendKeys("C:\\Users\\Virtual_Gamer\\git\\vtiger-a12\\vtiger-com-fw-a12\\src\\main\\resources\\testScriptData.xlsx");
		
        driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
//		Verification
	    String acttitle = driver.findElement(By.id("dtlview_Title")).getText();
		
		if (acttitle.equals(titl)) {
			System.out.println("Created Document successfully!!!!");
		} else {
			System.out.println("Failed....");
		}
		
//		Logout
	    WebElement profilepic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	    Actions act = new Actions(driver);
	    act.moveToElement(profilepic).build().perform(); 	
        
	    Thread.sleep(2000);
	    
//	    Click on SignOut Button
		driver.findElement(By.linkText("Sign Out")).click();
	    
		Thread.sleep(3000);
		
//      close Browser		
		driver.quit();
	}

}
