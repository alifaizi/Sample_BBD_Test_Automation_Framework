package com.steps.definition;

import org.junit.Assert;

import com.utilities.CommonUtils;
import com.utilities.ExcelUtillityTekRetailUserRegistration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginToTeSchoolRetailPageSteps extends CommonUtils {
	
	@Given("User is on Retail website")
	public void user_is_on_retail_website() {
	logintotekretail.retailPage.getText();
	}

	@Given("User click on My Account")
	public void user_click_on_my_account() {
	logintotekretail.myAccountLink.click();	
		
	}

	@When("User click on Login")
	public void user_click_on_login() {
		logintotekretail.loginLink.click();
	}

	@When("user enters username")
	public void user_enters_username() {
		
		ExcelUtillityTekRetailUserRegistration excel = new ExcelUtillityTekRetailUserRegistration();
    	try {
			excel.setExcelFile(".\\src\\test\\resources\\testdata\\loginToTekSchoolRetail.xlsx", "Sheet1");
			sendText(logintotekretail.emailField, excel.getCellData("username", 1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("user enters password")
	public void user_enters_password() {
	
		ExcelUtillityTekRetailUserRegistration excel = new ExcelUtillityTekRetailUserRegistration();
    	try {
			excel.setExcelFile(".\\src\\test\\resources\\testdata\\loginToTekSchoolRetail.xlsx", "Sheet1");
			sendText(logintotekretail.passwordField, excel.getCellData("password", 1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		logintotekretail.loginButton.click();
	}

	@Then("user logged into the tek school retail account successfully")
	public void user_logged_into_the_tek_school_retail_account_successfully() {
		Assert.assertTrue(logintotekretail.myAccuntDashboard.isDisplayed());
	}
}
