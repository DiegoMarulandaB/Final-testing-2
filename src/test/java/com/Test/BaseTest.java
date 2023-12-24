package com.Test;

/**
 * Author: Diego Marulanda B. Date:30/11/23 -19:26 Project_Name:marulanda_diego_final_testing
 */
import com.Base.BasePage;

public class BaseTest {
  public static String username = "john";
  public static String password = "demo";
  BasePage basePage;

  public void loginUser() {
    basePage = new BasePage();
    basePage.login(username, password);
  }
}