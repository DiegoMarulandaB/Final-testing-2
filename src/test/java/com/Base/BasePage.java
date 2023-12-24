package com.Base;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Author: Diego Marulanda B. Date:28/11/23 -18:02 Project_Name:marulanda_diego_final_testing
 */
public class BasePage {
  protected static WebDriver driver;

 public WebDriver chromeDriverConnection() {
    /**Google chrome for developer version 121.0.6129.0, chrome driver version 121.0.6129.0*/
    /** Path macOs*/
   /** System.setProperty("webdriver.chrome.driver", "/Users/diegomarulanda/Programming/dh2023/especializacion/testing2/marulanda_diego_final_testing/src/test/resources/chromedriver");*/
    driver = new ChromeDriver();
    return driver;
  }

  public void login(String username, String password) {
    By btnSubmit = By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input");
    write(username, By.name("username"));
    write(password, By.name("password"));
    click(btnSubmit);
  }

  public void goToLink(String url) { driver.get(url); }

  public static void write(String inputText, By locator) {
    WebElement input = driver.findElement(locator);
    input.clear();
    input.sendKeys(inputText);
  }

  public static void click(By locator) {
    driver.findElement(locator).click();
  }

  public String getText(By locator) {
    return driver.findElement(locator).getText();
  }

  public static void compareResultContainsExpected(String result, String expected) {
    assertTrue(result.contains(expected));
  }

  public static void waitForElementToBePresent(int time, By locator) {
    new WebDriverWait(driver, Duration.ofSeconds(time))
        .until(ExpectedConditions.elementToBeClickable(locator));
  }

  public void waitForTextToBePresent(int time, By locator, String text) {
    new WebDriverWait(driver, Duration.ofSeconds(time))
        .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
  }

  public void waitForUrlToBe(int time, String url) {
    new WebDriverWait(driver, Duration.ofSeconds(time))
        .until(ExpectedConditions.urlToBe(url));
  }

  public void waitForUrlToContain(int time, String url) {
    new WebDriverWait(driver, Duration.ofSeconds(time))
        .until(ExpectedConditions.urlContains(url));
  }
}

