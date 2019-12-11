package com.tour.page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tour.ui.utils.browser.Browsers;

public class RegistrationPage extends Browsers {
	
	public RegistrationPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(name = "firstName")
    public WebElement txtFirstName;
	
	@FindBy(name = "lastName")
    public WebElement txtLastName;
	
	@FindBy(name = "phone")
    public WebElement txtPhone;
	
	@FindBy(id = "userName")
	public WebElement txtEmail;
	
	@FindBy(name = "address1")
	public WebElement txtAddress1;
	
	@FindBy(name = "city")
	public WebElement txtCity;
	
	@FindBy(name = "state")
	public WebElement txtState;
	
	@FindBy(name = "postalCode")
	public WebElement txtPostalCode;
	
	@FindBy(name = "country")
	public WebElement selectcountry;
	
	@FindBy(name = "email")
	public WebElement txtUserName;
	
	@FindBy(name = "password")
	public WebElement txtPassword;
	
	@FindBy(name = "confirmPassword")
	public WebElement txtConfirmPassword;
	
	@FindBy(name = "register")
	public WebElement btnSubmit;
	
	@FindBy(xpath = "(//b)[2]")
	public WebElement lblRegisterCheck; 
	
}
