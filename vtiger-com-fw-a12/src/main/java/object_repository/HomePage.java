package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	
	private WebElement Orgtaglink;
 
	
	public WebElement getOrgtag() {
		
		return Orgtaglink;
	}
	
	
	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	
	private WebElement Profilepic;
	
	public WebElement getProfilePic() {
		
		return Profilepic;
	}
	
	@FindBy(linkText = "Sign Out")
	
	private WebElement SignoutBtn;
	
	public WebElement getSignoutBtn() {
		
		return SignoutBtn;
	}
}
