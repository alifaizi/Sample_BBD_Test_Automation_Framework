package com.base;

import com.page.objects.LoginPageObject;
import com.page.objects.LoginToTeSchoolRetailPageObject;
import com.page.objects.MainPageObject;
import com.page.objects.NewUserRegistrationPageObj;

public class PageInitializer extends Base{
	
	public static LoginPageObject loginPage;
	public static MainPageObject mainPage;
	
	public static NewUserRegistrationPageObj newuserregistration;
	
	public static LoginToTeSchoolRetailPageObject logintotekretail;
	
	public static void initialize() {
		
		loginPage = new LoginPageObject();
		mainPage = new MainPageObject();
		
		newuserregistration = new NewUserRegistrationPageObj();
		
		logintotekretail = new LoginToTeSchoolRetailPageObject();
		
	}

}
