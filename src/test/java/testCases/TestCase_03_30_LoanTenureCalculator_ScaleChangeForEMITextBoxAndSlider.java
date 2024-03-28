package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TestCase_03_30_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validatingDataFlowBetweenEMISliderAndTextBox() {
		
		logger.info("---- TestCase_03_30_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			loanCalculatorPageObj.navigatorForLoanTenureCalc();;
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Moving the Slider to Initial Position
			loanCalculatorPageObj.moveEMISlider(0);
			
			//Validating if the value passed to the text box is same as it is showing in the slider
			myAssert.assertIt(loanCalculatorPageObj.getEMITextBoxValue(), "21,617.95", "The initial value of the emi textbox is not 21,617.95");
			
			//Moving the slider to Desired Position
			loanCalculatorPageObj.moveEMISlider(186);
			
			//Validating if the value passed to the text box is same as it is showing in the slider
			if(loanCalculatorPageObj.getEMITextBoxValue().equals("50,000.00")) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_30_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and slider was not successful");
				System.out.println("TestCase_03_30_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and Slider was unsuccessful");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_03_30_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and Slider was unsuccessful");
			
			logger.error("TestCase_03_30_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider got failed, Scale Change for EMI Text Box and Slider was not successful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_03_30_LoanTenureCalculator_ScaleChangeForEMITextBoxAndSlider Ended ----");
	}
}
