package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validateFeesAndChargesSlider() {
		
		logger.info("---- TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider Started ----");
		try {
			LoanCalculatorPage obj1 = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			obj1.navigatorForEMICalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Validating if Fees And Charges Slider is visible
			if(obj1.getFeesAndChargesSlider().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not visible.");
				System.out.println("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not visible.");
				myAssert.fail();
			}
			
			//Validating if Fees And Charges Slider is enabled
			if(obj1.getFeesAndChargesSlider().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not enabled.");
				System.out.println("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, Fees And Charges Slider is not enabled.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, validation of Fees And Charges Slider was unsuccessful");
			
			logger.error("TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider got failed, validation of Fees And Charges Slider was not successful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_03_11_EMICalculator_ValidatingFeesAndChargesSlider Ended ----");
	}
}
