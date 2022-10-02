package com.page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base;

public class MainPageObject extends Base{
	
	public MainPageObject() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div//div[@class='app_logo']")
	public WebElement swagLabLogo;
	
	

}

