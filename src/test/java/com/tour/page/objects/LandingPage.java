package com.tour.page.objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tour.ui.utils.browser.Browsers;

public class LandingPage extends Browsers {
	
	public LandingPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(name = "userName")
    public WebElement txtUserName;
	
	@FindBy(name = "password")
    public WebElement txtPassword;
	
	@FindBy(name = "login")
    public WebElement btnLogin;
	
	@FindBy(xpath = "//*[@href]")
    public List<WebElement> landingPageLink;
	
}
