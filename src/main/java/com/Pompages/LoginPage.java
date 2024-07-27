package com.Pompages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
import java.time.Duration;


public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By usernameField = By.xpath("//input[@id='userName']");
    By passwordField = By.xpath("//input[@id='newPass']");
    By loginButton = By.xpath("//button[@id='submitAuth']");
    By errorMessage = By.xpath("//p[@id='growlText']");
    By errorpopup=By.xpath("//section[@class='notification-container error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Entering username")
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
    }

    @Step("Entering password")
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    @Step("Clicking login button")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    @Step("Getting error message")
    public String getErrorMessage() {
    	try {
            if(isErrorDisplayed()) 
            	return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
            
              
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }// Popup not found or not displayed
        
        return null;

    	
    }
    @Step("Displaying Error message")
    public boolean isErrorDisplayed() {
    	try {
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(errorpopup));
            if( popup.isDisplayed()) {
            	//System.out.println(popup.getText());
            	return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
            } 
            return false;
            
            
        } catch (Exception e) {
        	e.printStackTrace();
            return false; // Popup not found or not displayed
        }
    	
    }
    
}

