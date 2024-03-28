package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TestCase_03_21_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validatingDataFlowBetweenLoanTenureSliderAndTextBox() {
		
		logger.info("---- TestCase_03_21_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			loanCalculatorPageObj.navigatorForLoanAmountCalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Moving the Slider to Initial Position
			loanCalculatorPageObj.moveLoanTenureSlider(0);
			
			//Validating if the value passed to the text box is same as it is showing in the slider
			myAssert.assertIt(loanCalculatorPageObj.getLoanTenureTextBoxValue(), "5", "The initial value of the loan tenure textbox is not 5");
			
			//Moving the slider to Desired Position
			loanCalculatorPageObj.moveLoanTenureSlider(105);
			
			//Validating if the value passed to the text box is same as it is showing in the slider
			if(loanCalculatorPageObj.getLoanTenureTextBoxValue().equals("10")) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_21_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and slider was not successful");
				System.out.println("TestCase_03_21_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and Slider was unsuccessful");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_03_21_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and Slider was unsuccessful");
			
			logger.error("TestCase_03_21_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider got failed, Scale Change for Loan Tenure Text Box and slider was not successful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_03_21_LoanAmtCalculator_ScaleChangeForLoanTenureTextBoxAndSlider Ended ----");
	}
}
