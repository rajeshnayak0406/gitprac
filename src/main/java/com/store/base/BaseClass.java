package com.store.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public WebDriver driver;
	Properties prop;

	public void readDataFromProperties() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./configurations/store.properties");
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void launch_browser() {
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
			Sysytem.out.println("Hello");

		}

		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
}
