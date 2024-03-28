package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validateLoanAmountTextBox() {
		
		logger.info("---- TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			loanCalculatorPageObj.navigatorForLoanTenureCalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Validating if Loan Amount Text Box is visible
			if(loanCalculatorPageObj.getLoanAmtTextBox().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not visible.");
				System.out.println("TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not visible.");
				myAssert.fail();
			}
			
			//Validating if Loan Amount Text Box is enabled
			if(loanCalculatorPageObj.getLoanAmtTextBox().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not enabled.");
				System.out.println("TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, Loan Amount Text Box is not enabled.");
				myAssert.fail();
			}

		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, validation of Loan Amount Text Box was unsuccessful");
			
			logger.error("TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox got failed, validation of Loan Amount Text Box was not successful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_03_25_LoanTenureCalculator_ValidatingLoanAmountTextBox Ended ----");
	}
}
