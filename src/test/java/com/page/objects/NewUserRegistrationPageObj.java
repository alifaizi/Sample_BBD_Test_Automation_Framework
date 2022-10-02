package com.page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;


public class NewUserRegistrationPageObj extends Base{
	// This is just to create new account to be used to run in each time we run the Capstone project
	public NewUserRegistrationPageObj(){
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//h1//a[text()='TEST ENVIRONMENT']")
	public WebElement testEnvironmentTextFromUI;
	@FindBy(xpath = "//span[text()='My Account']")
	public WebElement myAccountLink;
	@FindBy(xpath = "//a[text()='Register']")
	public WebElement registerLinkInDropDown;
	@FindBy(id = "input-firstname")
	public WebElement firstNameFieldEntry;
	@FindBy(id = "input-lastname")
	public WebElement lastNameFieldEntry;
	@FindBy(id = "input-email")
	public WebElement emailEntryField;
	@FindBy(id = "input-telephone")
	public WebElement telephoneEntryField;
	@FindBy(id = "input-password")
	public WebElement passwordEntryField;
	@FindBy(id = "input-confirm")
	public WebElement confirmPasswordEntryField;
	@FindBy(xpath = "(//input[@name=\"newsletter\"])[1]")
	public WebElement yesNewsLetterSelect;
	@FindBy(xpath = "//input[@type='checkbox']")
	public WebElement privacyPolicyCheckBoxSelect;
	@FindBy(xpath = "//input[@value='Continue']")
	public WebElement continueButtonOnRegisteringNewAccountSelect;
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	public WebElement successMessageOnCreatingNewAccount;

	}
