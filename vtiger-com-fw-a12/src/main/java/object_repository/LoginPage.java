package object_repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

import genericUtility.FileUtility;

public class LoginPage {

	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

//	@FindBy(css= "input[name='user_name']")
//	 private WebElement un;

// Provide More Accuracy it uses AND 	
//	@FindBys({
//		@FindBy(name = "user_name"), 
//		@FindBy(css = "input[type='text']"),
//		@FindBy(xpath = "//input[@type='text']")
//	})
//	private WebElement un;

//	Auto - Healing

	@FindAll({ 
		@FindBy(name = "user_name"), 
		@FindBy(css = "input[type='text']"),
	    @FindBy(xpath = "//input[@type='text']")

	})
	private WebElement un;

	@FindBy(css = "input[name='user_password']")

	private WebElement pwd;

	@FindBy(id = "submitButton")

	private WebElement loginbtn;

	public WebElement getun() {
		return un;

	}

	public WebElement getpwd() {
		return pwd;
	}

	public WebElement getloginBtn() {
		return loginbtn;
	}

	public void login() throws IOException {

		FileUtility futil = new FileUtility();
		String UserName = futil.getDataFromPropertiesFile("un");
		String Password = futil.getDataFromPropertiesFile("pwd");
        un.sendKeys(UserName);
        pwd.sendKeys(Password);
        loginbtn.click();
	}
	
}
