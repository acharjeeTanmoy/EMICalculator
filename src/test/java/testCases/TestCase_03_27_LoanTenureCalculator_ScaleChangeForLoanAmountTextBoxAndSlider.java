package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TestCase_03_27_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validatingDataFlowBetweenLoanAmountSliderAndTextBox() {
		
		logger.info("---- TestCase_03_27_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			loanCalculatorPageObj.navigatorForLoanTenureCalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Moving the Slider to Initial Position
			loanCalculatorPageObj.moveLoanAmtSlider(0);
			
			//Validating if the value passed to the text box is same as it is showing in the slider
			myAssert.assertIt(loanCalculatorPageObj.getLoanAmtTextBoxValue(), "10,00,000", "The initial value of the loan amount textbox is not 10,00,000");
			
			//Moving the slider to Desired Position
			loanCalculatorPageObj.moveLoanAmtSlider(130);
			
			//Validating if the value passed to the text box is same as it is showing in the slider
			if(loanCalculatorPageObj.getLoanAmtTextBoxValue().equals("50,00,000")) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_27_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Change for Loan Amount Text Box and slider was not successful");
				System.out.println("TestCase_03_27_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Change for Loan Amount Text Box and Slider was unsuccessful");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_03_27_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Change for Loan Amount Text Box and Slider was unsuccessful");
			
			logger.error("TestCase_03_27_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider got failed, Scale Change for Loan Amount Text Box and Slider was not successful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_03_27_LoanTenureCalculator_ScaleChangeForLoanAmountTextBoxAndSlider Ended ----");
	}
}
