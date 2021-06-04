package com.Assignment.Web.testcases;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Assignment.Web.Functionality.blazedemoPages;
import com.Assignment.Web.Util.ReusableFunctions;
import com.Assignment.Web.base.TestBase;
import com.Assignment.Web.listeners.ExtentManager;
import com.Assignment.Web.testData.DataReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class DriverScript extends TestBase {
    
    private static SoftAssert _softAssert;
    private static String testCaseName = null;
    private static ExtentTest extentLogger = null;
    private static ExtentReports extent = null;
    private static Logger logger = null;

    private static HashMap<String, HashMap<String, String>> tcData = DataReader.
            testDataMappedToTestName(prop.getProperty("TestDataExcelFileName"), prop.getProperty("TestDataSheetName"));

    @BeforeMethod
    public static void setUp(Method method) throws IOException {
        driverInitialization();       
        _softAssert = new SoftAssert();
        testCaseName = method.getName();
        extent = ExtentManager.getReporter();
        extentLogger = ExtentManager.getLogger(testCaseName);
        logger = Logger.getLogger(DriverScript.class.getName());
    }

    @Test(priority = 1)
    public void FlightReservation(){
        logger.info("Running Step: Automation Test 1: Flight Reservation");
        String URL = prop.getProperty("WebURL");
        
        if(!blazedemoPages.OpenURL(URL))
        {
        	logger.error("Open URL unsuccessfull ");
           _softAssert.fail("Open URL unsuccessfull ");
        }
        
        if(!blazedemoPages.EnterFromandToPort("Paris","London"))
        {
        	logger.error("From & To Port unsuccessfull ");
           _softAssert.fail("From & To Port unsuccessfull ");
        }
        
        if(!blazedemoPages.ReserveFlight())
        {
        	logger.error("Reserve flight unsuccessfull ");
           _softAssert.fail("Reserve flight unsuccessfull ");
        }
        
        if(!blazedemoPages.FillYourDetails())
        {
        	logger.error("Fill your details unsuccessfull ");
           _softAssert.fail("Fill your details unsuccessfull ");
        }
        
        if(!blazedemoPages.ConfirmationPageValidation())
        {
        	logger.error("ConfirmationPageValidation unsuccessfull ");
           _softAssert.fail("ConfirmationPageValidation unsuccessfull ");
        }
        
        
        _softAssert.assertAll();
    }
    
    @AfterMethod
    public void getResult(ITestResult result) throws Exception{

        if(result.getStatus() == ITestResult.FAILURE){
            String screenShotPath = ReusableFunctions.takeScreenShot("FailWebPage");
            extentLogger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            extentLogger.fail(result.getThrowable());
            extentLogger.fail("Snapshot below: " + extentLogger.addScreenCaptureFromPath(screenShotPath, testCaseName));

        }else if(result.getStatus() == ITestResult.SKIP){
            extentLogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test case SKIPPED due to below issues:", ExtentColor.GREY));
            extentLogger.skip(result.getThrowable());

        }else if(result.getStatus() == ITestResult.SUCCESS){
            extentLogger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test case PASSED.", ExtentColor.GREEN));
        }

        
    }
    @AfterTest
    public void tearDown(){
        extent.flush();
        driver.quit();
    }
}

