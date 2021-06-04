package com.Assignment.Web.Functionality;



import com.Assignment.Web.Util.PropertyData;
import com.Assignment.Web.Util.ReusableFunctions;
import com.Assignment.Web.base.TestBase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class blazedemoPages extends TestBase {

    private static Logger logger = Logger.getLogger(blazedemoPages.class.getName());
    PropertyData data = new PropertyData();
    ReusableFunctions rf = new ReusableFunctions();   
      
    
    public static boolean OpenURL(String url)
    {
    	boolean flag = true;
 	    
 	    try
 	    {
 	    	driver.get(url);
 	    	Thread.sleep(5000);
 	    }    
    catch(Exception Ex){
        flag = false;
        logger.error("Exception Occurred While Opening URL: "+Ex.getMessage());
    }
    	return flag;
    }
    
    public static boolean EnterFromandToPort(String formportValue, String toportValue)
    {
    	boolean flag = true;
 	    
 	    try
 	    {
 	    	
 	    	Select FCountry = new Select(driver.findElement(By.name("fromPort")));
 	    	FCountry.selectByVisibleText(formportValue); 	    		    	
 	    	Select TCountry = new Select(driver.findElement(By.name("toPort")));
 	    	TCountry.selectByVisibleText(toportValue); 	        
 	        WebElement FindFlightBtn = driver.findElement(By.xpath("//input[@value='Find Flights']"));
 	        FindFlightBtn.click();
 	        
 	    }    
    catch(Exception Ex){
        flag = false;
        logger.error("Exception Occurred While Enter From & To Port : "+Ex.getMessage());    }
    	return flag;
    }
    
    
    public static boolean ReserveFlight()
    {
    	boolean flag = true;
 	    
 	    try
 	    {
 	    		    	  
 	       WebElement ChooseThisFlight = driver.findElement(By.xpath("/descendant::input[@type='submit'][3]"));
 	       ChooseThisFlight.click();
 	        
 	    }    
    catch(Exception Ex){
        flag = false;
        logger.error("Exception Occurred While Reserving flight : "+Ex.getMessage());    }
    	return flag;
    }
    
    public static boolean FillYourDetails()
    {
    	boolean flag = true;
 	    
 	    try
 	    {
 	    	
 	       Thread.sleep(1000);	
 	       WebElement name = driver.findElement(By.name("inputName"));      name.sendKeys("yagnesh"); 	       
 	       WebElement address = driver.findElement(By.name("address"));    address.sendKeys("pune"); 	       
 	       WebElement city =driver.findElement(By.name("city"));	       city.sendKeys("pune"); 	       
 	       WebElement state = driver.findElement(By.name("state"));        state.sendKeys("maharashtra");	       
 	       WebElement zipCode =driver.findElement(By.name("zipCode")); 	    zipCode.sendKeys("412114");    
 	       WebElement cardType =driver.findElement(By.name("cardType"));  cardType.sendKeys("Visa");	       
 	       WebElement cardNumber=driver.findElement(By.name("creditCardNumber")); cardNumber.sendKeys("123456789"); 	       
 	       WebElement month=driver.findElement(By.name("creditCardMonth"));   month.sendKeys("11");	       
 	       WebElement year=driver.findElement(By.name("creditCardYear")); 	year.sendKeys("2025");       
 	       WebElement cardName=driver.findElement(By.name("nameOnCard")); 	cardName.sendKeys("yagnesh");       
 	       WebElement rememberMeCheckBox=driver.findElement(By.name("rememberMe"));  if(!rememberMeCheckBox.isSelected()) {rememberMeCheckBox.click();}  	       
 	       WebElement purchaseFlight=driver.findElement(By.xpath("//input[@type='submit']")); purchaseFlight.click();
 	        
 	    }    
    catch(Exception Ex){
        flag = false;
        logger.error("Exception Occurred While FillYourDetails : "+Ex.getMessage());    }
    	return flag;
    }
    
    public static boolean ConfirmationPageValidation()
    {
    	boolean flag = true;
 	    
 	    try
 	    {
 	    	
 	       Thread.sleep(1000);	
 	       WebElement ConfirmationPageTitleValidation = driver.findElement(By.xpath("/descendant::h1")); 
 	       if(ConfirmationPageTitleValidation.isDisplayed())
 	       {logger.debug("Confirmation page is displayed!!");}	   
 	       
 	        
 	    }    
    catch(Exception Ex){
        flag = false;
        logger.error("Exception Occurred While ConfirmationPageValidation : "+Ex.getMessage());    }
    	return flag;
    }
    
}