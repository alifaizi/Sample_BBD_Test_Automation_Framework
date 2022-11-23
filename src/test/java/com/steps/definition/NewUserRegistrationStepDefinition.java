package com.steps.definition;

import org.junit.Assert;
//Created by Ali Faizi for demonstration and learning purposes only. 
import com.utilities.CommonUtils;
import com.utilities.ExcelUtillityTekRetailUserRegistration;

import io.cucumber.java.en.*;

public class NewUserRegistrationStepDefinition extends CommonUtils {

	@Given("I am on Test Environment Home Page")
	public void i_am_on_test_environment_home_page() {
		Assert.assertTrue(newuserregistration.testEnvironmentTextFromUI.isDisplayed());
	}  
	@When("I click on My Account button")
	public void i_click_on_my_account_button() {
		newuserregistration.myAccountLink.click();
	}   
	@And("I click on register link")
	public void i_click_on_register_link() {
		newuserregistration.registerLinkInDropDown.click();
	}   
	@And("I fill the registration form")
	public void i_fill_the_registration_form() {
    	ExcelUtillityTekRetailUserRegistration excel = new ExcelUtillityTekRetailUserRegistration();
    	try {
			excel.setExcelFile(".\\src\\test\\resources\\testdata\\TestDataForApachePoi.xlsx", "Sheet1");
			sendText(newuserregistration.firstNameFieldEntry, excel.getCellData("first_name", 3));
			sendText(newuserregistration.lastNameFieldEntry, excel.getCellData("last_name", 3));
			sendText(newuserregistration.emailEntryField, excel.getCellData("email", 3));
			sendText(newuserregistration.telephoneEntryField, excel.getCellData("telephone", 3));
			sendText(newuserregistration.passwordEntryField, excel.getCellData("password", 3));
			sendText(newuserregistration.confirmPasswordEntryField, excel.getCellData("confirm_password", 3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@And("I subscribe to newsletter")
	public void i_subscribe_to_newsletter() {
		newuserregistration.yesNewsLetterSelect.click();
	}
	@And("I agree to privacy policy")
	public void i_agree_to_privacy_policy() {
		newuserregistration.privacyPolicyCheckBoxSelect.click();
	}
	@And("I click on continue button")
	public void i_click_on_continue_button() {
		newuserregistration.continueButtonOnRegisteringNewAccountSelect.click();
	}
	@And("I validate my account is created successfully")
	public void i_validate_my_account_is_created_successfully() {
		Assert.assertTrue(newuserregistration.successMessageOnCreatingNewAccount.isDisplayed());
	}
}
