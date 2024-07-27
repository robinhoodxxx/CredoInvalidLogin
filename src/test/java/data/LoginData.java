package data;

import org.testng.annotations.DataProvider;

import utils.RandomStringUtils;
public class LoginData {
	
	



	    @DataProvider(name = "loginData")
	    public static Object[][] loginData() {
	    	
	    	RandomStringUtils r =new RandomStringUtils();
	    	
	    
	    	
      
	    	
	        return new Object[][]{
	            {r.getRandomAlphaNumeric(10), r.getRandomAlphaNumeric(), "Georgian"},
	           {r.getRandomAlphaNumeric(), r.getRandomAlphaNumeric(), "Meglish"},
	           {r.getRandomAlphaNumeric(), "   ", "Svan"},
	            {r.getRandomAlphaNumeric(), r.getRandomAlphaNumeric(5), "english"}

	            
	        };
	    }
	

}
