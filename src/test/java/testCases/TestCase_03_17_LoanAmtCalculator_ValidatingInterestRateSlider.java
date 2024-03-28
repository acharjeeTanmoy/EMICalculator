package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validatingDataFlowBetweenInterestRateSliderAndTextBox() {
		
		logger.info("---- TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			loanCalculatorPageObj.navigatorForLoanAmountCalc();;
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Validating if Interest Rate Slider is visible
			if(loanCalculatorPageObj.getIntRateSlider().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not visible.");
				System.out.println("TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not visible.");
				myAssert.fail();
			}
			
			//Validating if Interest Rate Slider is enabled
			if(loanCalculatorPageObj.getIntRateSlider().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not enabled.");
				System.out.println("TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider got failed, Interest Rate Slider is not enabled.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider got failed, validation of Interest Rate Slider was unsuccessful");
			
			logger.error("TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider got failed, validation of Interest Rate Slider was not successful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_03_17_LoanAmtCalculator_ValidatingInterestRateSlider Ended ----");
	}
}
