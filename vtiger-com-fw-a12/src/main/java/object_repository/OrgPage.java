package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgPage {
	
	public OrgPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
   @FindBy(css = "img[alt='Create Organization...']")
	
	private WebElement Orgaddbtn;
	
	
	public WebElement getOrgaddbtn(){
		
		return Orgaddbtn;
	}
	
	@FindBy(css = "input[name='accountname']")
	
	private WebElement orgfield;

	public WebElement getOrgField() {
		
		return orgfield;
	}
	
	@FindBy(css = "input[name='website']" )
	
	private WebElement website;
	
	public WebElement getWebsite() {
		
		return website;
	}
	
	@FindBy(id = "employees")
	
	private WebElement employee;
	
	public WebElement getemployee() {
		
		return employee;
	}
	
	@FindBy(id = "phone")
	
	private WebElement phone;
	
	public WebElement getphone() {
		
		return phone;
	}
	
	@FindBy(id = "email1")
	
	private WebElement email; 
	
	public WebElement getemail() {
		
		return email;
	}
	
	@FindBy(css = "input[name='annual_revenue']")
	
	private WebElement annualrevenue;
	
	public WebElement getannualrevenue() {
		
		return annualrevenue;
	}
	
	@FindBy(xpath = "//select[@name='industry']")
	
	private WebElement indusDD;
	
	public WebElement getIndustry() {
		
		return indusDD;
	}
	
	@FindBy(xpath = "//select[@name='accounttype']")
	
	private WebElement typeDD;
	
	public WebElement gettype() {
		
		return typeDD;
	}
	
	@FindBy(xpath = "//select[@name='rating']")
	
	private WebElement ratingDD;
	
	public WebElement getrating() {
		
		return ratingDD;
	}
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	
	private WebElement savebtn;
	
	public WebElement getsavebtn() {
		
		return savebtn;
	}	
}
