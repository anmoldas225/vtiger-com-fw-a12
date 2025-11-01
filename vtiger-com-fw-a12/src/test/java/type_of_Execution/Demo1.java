package type_of_Execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo1 {
	
	
 @Test
 public void case1() throws InterruptedException {
	 
	 WebDriver driver = new ChromeDriver();
	 Thread.sleep(2000);
	 driver.quit();
	 
 }
 
 
 @Test
 
 public void case101() throws InterruptedException {
	 
	 WebDriver driver = new ChromeDriver();
	 Thread.sleep(2000);
	 driver.quit();
 }	
}