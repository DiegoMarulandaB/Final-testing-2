package com.RestAssured;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import static com.RestAssured.testGetAccountsOverview.customerId;
import static com.RestAssured.testGetUser.userDemo;
import static com.RestAssured.testGetUser.password;
import static io.restassured.RestAssured.given;

/**
 * Author: Diego Marulanda B. Date:30/11/23 -18:11 Project_Name:marulanda_diego_final_testing
 */

public class testPostOpenAccount {
  /**url-1*/
/**int fromAccountId = 13788;*/
/**String url = "https://parabank.parasoft.com/parabank/services_proxy/bank/createAccount?customerId=" + customerId + "&newAccountType=1&fromAccountId=" + fromAccountId;*/
//**url-2*/
 int fromAccountId = 15675;
 String url = "https://parabank.parasoft.com/parabank/services/bank/createAccount?customerId=" + customerId + "&newAccountType=1&fromAccountId=" + fromAccountId;
  @Test
  @DisplayName("Abrir nueva cuenta")
  @Tag("TestCase-Back")
  public void testOpenAccount() {
    JSONObject req = new JSONObject();

    given().auth().basic(userDemo, password).
        log().all().contentType(ContentType.JSON).
        body(req.toString()).
        when().
        post(url).
        then().
        statusCode(200).
        log().status()
        .log().body();

    /**url-1*/
        /* response:
            HTTP/1.1 200 OK
            {
                "id": 14676,
                "customerId": 12989,
                "type": "SAVINGS",
                "balance": 0
            }
         */

    /**Url-2*/
      /* response:
            HTTP/1.1 200 OK
            {
                "id": 13334,
                "customerId": 12212,
                "type": "SAVINGS",
                "balance": 0
            }
         */
  }
}
