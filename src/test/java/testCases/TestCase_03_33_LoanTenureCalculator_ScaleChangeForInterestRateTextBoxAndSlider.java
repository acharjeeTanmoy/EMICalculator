package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TestCase_03_33_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validateDataFlowBetweenInterestRateSliderAndTextBox() {
		
		logger.info("---- TestCase_03_33_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			loanCalculatorPageObj.navigatorForLoanTenureCalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Moving the Slider to Initial Position
			loanCalculatorPageObj.moveIntRateSlider(0);
			
			//Validating if the value passed to the text box is same as it is showing in the slider
			myAssert.assertIt(loanCalculatorPageObj.getIntRateTextBoxValue(), "10.75", "The initial value of the interest rate textbox is not 10.75");
			
			//Moving the slider to Desired Position
			loanCalculatorPageObj.moveIntRateSlider(112);
			
			//Validating if the value passed to the text box is same as it is showing in the slider
			if(loanCalculatorPageObj.getIntRateTextBoxValue().equals("14.25")) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_33_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and slider was not successful");
				System.out.println("TestCase_03_33_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was unsuccessful");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_03_33_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was unsuccessful");
			
			logger.error("TestCase_03_33_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider got failed, Scale Change for Interest Rate Text Box and Slider was unsuccessful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_03_33_LoanTenureCalculator_ScaleChangeForInterestRateTextBoxAndSlider Ended ----");
	}	
}
