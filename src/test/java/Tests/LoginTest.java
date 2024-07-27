package Tests;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Pompages.LanguageSetup;
import com.Pompages.LoginPage;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import utils.Baseclass;

public class LoginTest extends Baseclass{
	 LoginPage loginPage ;
	 LanguageSetup lan;
	 SoftAssert softAssert = new SoftAssert();
	 
	 


    @Test(dataProvider = "loginData", dataProviderClass = data.LoginData.class)
    @Description("Test invalid login attempts with username and password")
    @Feature("Login")
    @Story("Invalid Login Attempts")
    public void InvalidLogin(String username, String password, String language) {
    	lan = new LanguageSetup(driver);
    	loginPage =new LoginPage(driver);
        Allure.step("opening the language setup");
        lan.clickLanguageBtn();
        Allure.step("selcting the language: "+language);
        lan.selectLanguage(language);
        Allure.step("Entering username: "+username);
        loginPage.enterUsername(username);
        Allure.step("Entering password: "+password);
        loginPage.enterPassword(password);
        Allure.step("clciking on login button");
        loginPage.clickLoginButton();

        String errorMsg = loginPage.getErrorMessage();
        //softAssert.assertTrue(errorMsg.contains("Invalid"), "Error message validation failed for: " + username + " / " + password);
        softAssert.assertTrue(loginPage.isErrorDisplayed());
       // System.out.println(loginPage.getErrorMessage());
        softAssert.assertAll();
    }
    
  
    

   
}

