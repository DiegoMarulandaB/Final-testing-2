package com.Test;

import com.Base.BasePage;
import com.Pages.PageTransferFunds;
import com.Reports.Reports;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Author: Diego Marulanda B. Date:30/11/23 -21:10 Project_Name:marulanda_diego_final_testing
 */
public class TestTransferFunds extends BaseTest {
  private WebDriver driver;
  PageTransferFunds pageTransferFunds;
  By title = By.className("title");
  By resultSuccess = By.className("title");
  public ExtentReports report;
  public ExtentTest test;

  @BeforeEach
  public void setUp() {
    pageTransferFunds = new PageTransferFunds(driver);
    driver = pageTransferFunds.chromeDriverConnection();
    driver.manage().window().maximize();
    pageTransferFunds.goToLink("https://parabank.parasoft.com/parabank/index.htm");
    loginUser();
    report = Reports.getInstance();
  }

  @AfterEach
  public void tearDown() {
    report.flush();
    driver.quit();
  }

  @Test
  @DisplayName("4- Transferir fondos")
  @Tag("TestCase-Front")
  public void transferFunds() throws InterruptedException {
    test = report.startTest("Transferir fondos");
    test.log(LogStatus.INFO, "Inicia test");
    pageTransferFunds.clickTransferFundsBtn();

    BasePage.compareResultContainsExpected(pageTransferFunds.getText(title), "Transfer Funds");
    test.log(LogStatus.PASS, "El título se ubica correctamente");

    pageTransferFunds.transfer("1000");
    BasePage.compareResultContainsExpected(pageTransferFunds.getText(resultSuccess), "Transfer Complete!");
    test.log(LogStatus.PASS, "Transferencia exitosa");
  }
}
