package testCases;

import org.testng.annotations.Test;

import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;

public class TestCase_03_37_EMICalculator_ValidationForYearAndMonthOption extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	Assertions myAssert = new Assertions();
	@Test
	public void validatingDataFlowBetweenYearAndMonthButton() {
		
		logger.info("---- TestCase_03_37_EMICalculator_ValidationForYearAndMonthOption Started ----");
		try {
			LoanCalculatorPage loanCalculatorPageObj = new LoanCalculatorPage(driver);
			
			//Waiting for the main menu to load
			wait.waitForMainMenu(driver);
			
			//Navigating to the EMI Calculator Section
			loanCalculatorPageObj.navigatorForEMICalc();
			
			//Waiting for all the fields to be visible
			wait.waitForTheTextBoxAndSlider(driver);
			
			//Clicking on the year button
			loanCalculatorPageObj.clickYear();
			
			//Storing the value of year in a string 
			String yearVal = loanCalculatorPageObj.getLoanTenureTextBoxValue();
			
			//Converting the year value to the month value
			int yearValInInt = Integer.parseInt(yearVal);
			
			//Clicking on the month Button
			loanCalculatorPageObj.clickMonth();
			
			//Storing the value of month in a string 
			String monthVal = loanCalculatorPageObj.getLoanTenureTextBoxValue();
			
			//Asserting the values
			if(monthVal.equals(Integer.toString(yearValInInt*12))) {
				myAssert.pass();
			}
			else {
				logger.error("TestCase_03_37_EMICalculator_ValidationForYearAndMonthOption got failed, The data flow between the year and month is not proper in the EMI Calculator Section.");
				System.out.println("TestCase_03_37_EMICalculator_ValidationForYearAndMonthOption got failed, The data flow between the year and month is not proper in the EMI Calculator Section..");
				myAssert.fail();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_03_37_EMICalculator_ValidationForYearAndMonthOption got failed, Validation for Year and Month Button was unsuccessful");
			
			logger.error("TestCase_03_37_EMICalculator_ValidationForYearAndMonthOption got failed, Validation for Year and Month Button was not successful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_03_37_EMICalculator_ValidationForYearAndMonthOption Ended ----");
	}
}
