package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validateLoanTenureSlider() {
		
		logger.info("---- TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider Started ----");

		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			loanCalculatorPageObj.navigatorForEMICalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Validating if Loan Tenure Slider is visible
			if(loanCalculatorPageObj.getLoanTenureSlider().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not visible.");
				System.out.println("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not visible.");
				myAssert.fail();
			}
			
			//Validating if Loan Tenure Slider is enabled
			if(loanCalculatorPageObj.getLoanTenureSlider().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not enabled.");
				System.out.println("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, Loan Tenure Slider is not enabled.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, validation of Loan Tenure Slider was unsuccessful");
			
			logger.error("TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider got failed, validation of Loan Tenure Slider was not successful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_03_08_EMICalculator_ValidatingLoanTenureSlider Ended ----");
	}
}
