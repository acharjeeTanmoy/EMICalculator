package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TestCase_03_36_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validatingDataFlowBetweenFeesAndChargesSliderAndTextBox() {
		
		logger.info("---- TestCase_03_36_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			loanCalculatorPageObj.navigatorForLoanTenureCalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Moving the Slider to Initial Position
			loanCalculatorPageObj.moveFeesAndChargesSlider(0);
			
			//Validating if the value passed to the text box is same as it is showing in the slider
			myAssert.assertIt(loanCalculatorPageObj.getFeesAndChargesTextBoxValue(), "10,000", "The initial value of the fees and charges textbox is not 10,000");
			
			//Moving the slider to Desired Position
			loanCalculatorPageObj.moveFeesAndChargesSlider(97);
			
			//Validating if the value passed to the text box is same as it is showing in the slider
			if(loanCalculatorPageObj.getFeesAndChargesTextBoxValue().equals("25,000")) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_36_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and slider was not successful");
				System.out.println("TestCase_03_36_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was unsuccessful");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_03_36_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box and Slider was unsuccessful");
			
			logger.error("TestCase_03_36_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider got failed, Scale Change for Fees And Charges Text Box ans Slider was not successful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_03_36_LoanTenureCalculator_ScaleChangeForFeesAndChargesTextBoxAndSlider Ended ----");
	}
}
