package com.base;

import com.page.objects.LoginToTeSchoolRetailPageObject;
//Created by Ali Faizi for demonstration and learning purposes only. 
import com.page.objects.NewUserRegistrationPageObj;

public class PageInitializer extends Base{
	
	
	public static NewUserRegistrationPageObj newuserregistration;
	
	public static LoginToTeSchoolRetailPageObject logintotekretail;
	
	public static void initialize() {
		
		
		newuserregistration = new NewUserRegistrationPageObj();
		
		logintotekretail = new LoginToTeSchoolRetailPageObject();
		
	}

}

