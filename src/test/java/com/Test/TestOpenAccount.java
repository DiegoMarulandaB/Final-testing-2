package com.Test;

import com.Base.BasePage;
import com.Pages.PageOpenAccount;
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
 * Author: Diego Marulanda B. Date:30/11/23 -20:01 Project_Name:marulanda_diego_final_testing
 */
public class TestOpenAccount extends BaseTest {
  private WebDriver driver;
  PageOpenAccount pageOpenAccount;
  By resultSuccess = By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]");
  public ExtentReports report;
  public ExtentTest test;

  @BeforeEach
  public void setUp() {
    pageOpenAccount = new PageOpenAccount(driver);
    driver = pageOpenAccount.chromeDriverConnection();
    driver.manage().window().maximize();
    pageOpenAccount.goToLink("https://parabank.parasoft.com/parabank/index.htm");
    loginUser();
    report = Reports.getInstance();
  }

  @AfterEach
  public void tearDown() {
    report.flush();
    driver.quit();
  }

  @Test
  @DisplayName("2- Apertura de nueva cuenta")
  @Tag("TestCase-Front")
  public void testOpenAccount() throws InterruptedException {
    test = report.startTest("Apertura de nueva cuenta");
    test.log(LogStatus.INFO, "Inicia test");
    pageOpenAccount.openAccount();

    BasePage.compareResultContainsExpected(pageOpenAccount.getText(resultSuccess), "Congratulations, your account is now open.");
    test.log(LogStatus.PASS, "Cuenta abierta exitosamente");
  }
}
