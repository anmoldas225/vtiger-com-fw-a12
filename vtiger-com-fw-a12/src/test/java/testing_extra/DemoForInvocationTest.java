package testing_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoForInvocationTest {
	
	@Test(invocationCount = 0)
	
	public void case1() {
		
		System.out.println("Hey");
		
	}
	
	@Test(enabled = false)
	public void case2() {
		
		System.out.println("Hey");
		
	}
	
	@Test(invocationCount = 10, threadPoolSize = 3)
	
	public void case3() throws InterruptedException {
		
		WebDriver driver =  new ChromeDriver();
        Thread.sleep(2000);
        driver.quit();
	}
	

}
