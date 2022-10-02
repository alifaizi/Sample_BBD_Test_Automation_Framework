package com.steps.definition;

import org.junit.Assert;

import com.utilities.CommonUtils;
import com.utilities.ConfigsReader;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps extends CommonUtils{

	@When("user enters valid username")
	public void user_enters_valid_username() {
		sendText(loginPage.userName, ConfigsReader.getProperty("username"));
	}

	@When("user enters valid password")
	public void user_enters_valid_password() {
		sendText(loginPage.password, ConfigsReader.getProperty("password"));

	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		loginPage.loginButton.click();
	}

	@Then("user should be logged in")
	public void user_should_be_logged_in() {
		Assert.assertTrue(mainPage.swagLabLogo.isDisplayed());
		highlightelementRedBorder(mainPage.swagLabLogo);
		wait(2);
	
	}

	@When("user leaves passwors field empty")
	public void user_leaves_passwors_field_empty() {
		sendText(loginPage.password, "");
	}

	@Then("user should see the error message {string} displayed on the screen")
	public void user_should_see_the_error_message_displayed_on_the_screen(String expectedMessage) {
		String actualMessage = loginPage.errorMsg.getText();
		Assert.assertEquals( expectedMessage,actualMessage);
	}

	@When("user enters invalid username as {string}")
	public void user_enters_invalid_username_as(String username) {
		sendText(loginPage.userName, username);
	
	}

	@When("user enters invalid password as {string}")
	public void user_enters_invalid_password_as(String password) {
		sendText(loginPage.password, password);
	
	}
	
	@Then("user should see the error message {string}")
	public void user_should_see_the_error_message(String expectedMessage2) {
		String actualMessage = loginPage.errorMsg2.getText();
		Assert.assertEquals(expectedMessage2,actualMessage);
	}

}
