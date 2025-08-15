package com.store.scripts;

import org.testng.annotations.Test;

import com.store.base.BaseClass;

public class LaunchBrowser  extends BaseClass{
	
	@Test
	public void launchBrowser() {
		readDataFromProperties();
		launch_browser();
		
	}

	
}
