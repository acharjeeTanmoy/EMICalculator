package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validateLoanAmountSlider() {
		
		logger.info("---- TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			loanCalculatorPageObj.navigatorForLoanTenureCalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Validating if Loan Amount Slider is visible
			if(loanCalculatorPageObj.getLoanAmtSlider().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not visible.");
				System.out.println("TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not visible.");
				myAssert.fail();
			}
			
			//Validating if Loan Amount Slider is enabled
			if(loanCalculatorPageObj.getLoanAmtSlider().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not enabled.");
				System.out.println("TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, Loan Amount Slider is not enabled.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, validation of Loan Amount Slider was unsuccessful");
			
			logger.error("TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider got failed, validation of Loan Amount Slider was not successful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_03_26_LoanTenureCalculator_ValidatingLoanAmountSlider Ended ----");
	}
}
