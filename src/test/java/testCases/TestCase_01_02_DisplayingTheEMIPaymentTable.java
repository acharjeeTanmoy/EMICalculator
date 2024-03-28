package testCases;

import org.testng.annotations.Test;

import pageObjects.EmiCalculatorHomePage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TestCase_01_02_DisplayingTheEMIPaymentTable extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void displayResult() {
		
		logger.info("---- TestCase_01_02_DisplayingTheEMIPaymentTable Started ----");
		try {
			EmiCalculatorHomePage homePageObj = new EmiCalculatorHomePage(driver);
			
			//Scroll to Table
			homePageObj.scrollToTable();

			//Click on the Years
			homePageObj.clickOnYears();
			
			//Displaying the data
			homePageObj.printTheEMIPaymentTable();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_01_01_EnteringRequiredValuesInHomePage got failed, displaying the datas wasn't successful");
			
			logger.error("TestCase_01_01_EnteringRequiredValuesInHomePage got failed, displaying the datas wasn't successful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_01_02_DisplayingTheEMIPaymentTable Ended ----");
	}
}
