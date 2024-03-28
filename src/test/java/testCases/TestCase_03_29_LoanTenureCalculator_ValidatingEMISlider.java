package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validatingEMISlider() {
		
		logger.info("---- TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			loanCalculatorPageObj.navigatorForLoanTenureCalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Validating if EMI Slider is visible
			if(loanCalculatorPageObj.getEMISlider().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider got failed, EMI Slider is not visible.");
				System.out.println("TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider got failed, EMI Slider is not visible.");
				myAssert.fail();
			}
			
			//Validating if EMI Slider is enabled
			if(loanCalculatorPageObj.getEMISlider().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider got failed, EMI Slider is not enabled.");
				System.out.println("TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider got failed, EMI Slider is not enabled.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider got failed, validation of EMI Slider was unsuccessful");
			
			logger.error("TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider got failed, validation of EMI Slider was not successful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_03_29_LoanTenureCalculator_ValidatingEMISlider Ended ----");
	}
}
