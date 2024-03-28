package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validatingValidatingEMITextBox() {
		
		logger.info("---- TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			loanCalculatorPageObj.navigatorForLoanAmountCalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Validating if EMI Text Box is visible
			if(loanCalculatorPageObj.getEMITextBox().isDisplayed()) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox got failed, EMI Text Box is not visible.");
				System.out.println("TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox got failed, EMI Text Box is not visible.");
				myAssert.fail();
			}
			
			//Validating if EMI Text Box is enabled
			if(loanCalculatorPageObj.getEMITextBox().isEnabled()) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox got failed, EMI Text Box is not enabled.");
				System.out.println("TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox got failed, EMI Text Box is not enabled.");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox got failed, validation of EMI Text Box was unsuccessful");
			
			logger.error("TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox got failed, validation of EMI Text Box was not successful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_03_13_LoanAmtCalculator_ValidatingEMITextBox Ended ----");
	}
}
