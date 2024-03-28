package testCases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import pageObjects.HomeLoanEMICalculatorPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.Assertions;
import utilities.WriteExcel;

public class TestCase_02_01_StoringTheYearTableInExcel extends BaseClass{
	AddFluentWait wait = new AddFluentWait();
	WriteExcel write = new WriteExcel();
	Assertions myAssert = new Assertions();
	
	@Test
	public void storeTable() {
		logger.info("---- TestCase_02_01_StoringTheYearTableInExcel Started ----");
		try {
			HomeLoanEMICalculatorPage HomeLoanPageObj = new HomeLoanEMICalculatorPage(driver);
			
			//Waiting for the main menu button
			wait.waitForMainMenu(driver);
			
			//Navigating to the respective page
			HomeLoanPageObj.navigator();
			
			//Scrolling to the table
			HomeLoanPageObj.scrollToTable();
			
			//Getting the year table in a 2 Dimensional Array
			String[][] datas = HomeLoanPageObj.getTableData();
			
			//Writing the data into the excel sheet
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); 	// Timestamp for the excel file
			String fileName = "YearTable" + timeStamp + ".xlsx";
			String path = ".//TestData/" + fileName;
			write.writeExcel(datas, path);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("TestCase_02_01_StoringTheYearTableInExcel got failed, storing the data was unsuccessful");
			logger.error("TestCase_02_01_StoringTheYearTableInExcel got failed, storing the data was unsuccessful");
			myAssert.fail();
		}
		
		logger.info("---- TestCase_02_01_StoringTheYearTableInExcel Ended ----");
	}
}
