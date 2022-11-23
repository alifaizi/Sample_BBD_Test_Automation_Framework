package com.page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Created by Ali Faizi for demonstration and learning purposes only. 
import com.base.Base;

public class LoginToTeSchoolRetailPageObject extends Base {
	
	public LoginToTeSchoolRetailPageObject() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h1//a[text()='TEST ENVIRONMENT']")
	public WebElement retailPage;
	@FindBy(xpath = "//span[text()='My Account']")
	public WebElement myAccountLink;
	@FindBy(xpath = "//li//a[text()='Login']")
	public WebElement loginLink;
	@FindBy(xpath = "//input[@id='input-email']")
	public WebElement emailField;
	@FindBy(xpath = "//input[@id='input-password']")
	public WebElement passwordField;
	@FindBy(xpath = "//div//input[@value='Login']")
	public WebElement loginButton;
	@FindBy (xpath = "//div[@id='content']//h2[text()='My Account']")
	public WebElement myAccuntDashboard;
}
