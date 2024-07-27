package Listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.testng.AllureTestNg;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.Baseclass; 

public class AllureListener extends AllureTestNg implements ITestListener {
	


    @Override
    public void onTestStart(ITestResult result) {

    	super.onTestStart(result);
        
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	attachScreenshot(result,"Passed");
        super.onTestSuccess(result);

    }

    @Override
    public void onTestFailure(ITestResult result) {
    	attachScreenshot(result,"Failed");

        super.onTestFailure(result);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	attachScreenshot(result,"Skipped");

        super.onTestSkipped(result);
    }

    @Override
    public void onStart(ITestContext context) {
    	
    	super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        super.onFinish(context);
        
    }

    private void attachScreenshot(ITestResult result,String name) {
    	WebDriver driver = getDriverFromResult(result);
    	if(driver==null) return;
        // Capture screenshot
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        // Attach to Allure
        Allure.addAttachment(name+"_"+result.getName(), "image/png", new ByteArrayInputStream(screenshot), ".png");
    }

    private WebDriver getDriverFromResult(ITestResult result) {
        Object testClass = result.getInstance();
        if (testClass instanceof Baseclass) {
        	return ((Baseclass) testClass).getDriver(); 
        	
        }
        return null;
    }
    
//    @Attachment(value = "Screenshot", type = "image/png")
//    public byte[] saveScreenshotPNG(WebDriver driver) {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }
//
//    private void captureScreenshot(ITestResult result) {
//        Object testClass = result.getInstance();
//        if (testClass instanceof Baseclass) {
//            WebDriver driver = ((Baseclass) testClass).getDriver();
//            if (driver != null) {
//                saveScreenshotPNG(driver);
//                System.out.println("screen");
//            }
//        }
//    }
   

}
