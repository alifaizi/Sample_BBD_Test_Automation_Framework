package com.page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class LoginPageObject extends Base{
	
	public LoginPageObject() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user-name")
	public WebElement userName;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "login-button")
	public WebElement loginButton;
	
	@FindBy(xpath = "//h3[@data-test='error']")
	public WebElement errorMsg;
	
	@FindBy(xpath = "//h3[contains(text(),'Epic sadface: Username and password do not match a')]")
	public WebElement errorMsg2;

}
