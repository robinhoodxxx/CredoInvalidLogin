package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;

public class Baseclass {
	
	 protected static WebDriver driver;
	   

	   
	    
	    @BeforeMethod
	    @Parameters("browser")
	    public void lauchBrowser(String browser) {
	    	String url ="https://mycredo.ge/landing/main/auth";
	        Allure.step("launching the "+browser+" browser");
	        driver = BrowserSetup(browser);     
	        Allure.step("Navigate to the application {url}");
	        driver.get(url);
	        driver.manage().deleteAllCookies();
	        driver.manage().window().maximize();


	    }
	    
	    @AfterMethod
	    public void teardown() {
	        Allure.step("closing the application");
	    	driver.quit();
	    	
	    }
	    
	    
	    

public static WebDriver BrowserSetup(String browser) {
	    
		browser=browser.trim();
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup(); 
			return new ChromeDriver();
		}
		
		 if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup(); 
			return new FirefoxDriver();
		}
		
		 if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup(); 
			return new EdgeDriver();
		 }
			System.out.println("Browser is not existed");
			return null;
		}
	
	
public WebDriver getDriver(){
	
return driver;}

}

