package com.Assignment.Web.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.Assignment.Web.base.TestBase;




public class blazedemoPages_OR extends TestBase{
	
	
	@FindBy(xpath = "//div[@class='jumbotron']//h1[contains(text(),'Welcome')]")
    WebElement welcomeTitle;

    @FindBy(name = "fromPort")
    WebElement departureDropDown;

    @FindBy(name = "toPort")
    WebElement destinationDropDown;

    @FindBy(xpath = "//input[@value='Find Flights']")
    WebElement findFlightsButton;
		

	
}
