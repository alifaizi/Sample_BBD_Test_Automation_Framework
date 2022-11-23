package com.steps.definition;


import com.base.Base;
import com.utilities.CommonUtils;
//Created by Ali Faizi for demonstration and learning purposes only. 
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	@Before
	public void start() {
		Base.setup();
	}

	@After
	public void end(Scenario scenario) {
		byte[] picture;
		if (scenario.isFailed()) {
			// Take screenshot and save it in /failed
			picture = CommonUtils.takeScreenshot("failed/" + scenario.getName());
		} else {

			// Take screenshot and put it in /passed folder

			picture = CommonUtils.takeScreenshot("passed/" + scenario.getName());
		}

		scenario.attach(picture, "image/png", scenario.getName());

		Base.tearDown();

	}

}
