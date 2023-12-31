package com.RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Author: Diego Marulanda B. Date:30/11/23 -17:58 Project_Name:marulanda_diego_final_testing
 */
public class testGetUser {
  public static String userDemo = "john";
  public static String password = "demo";
  String url = "https://parabank.parasoft.com/parabank/services/bank/login/" + userDemo + "/" + password;
  Response res = RestAssured.get(url);

  @Test
  public void testLogin() {
    int statusCode = 200;
    int responseCode = res.getStatusCode();
    System.out.println(res.getBody().asString());

    Assertions.assertEquals(statusCode, responseCode);

        /*
         <?xml version="1.0" encoding="UTF-8"standalone="yes"?>
            <customer>
                <id>14876</id>
                <firstName>Jennifer</firstName>
                <lastName>Lawrence</lastName>
                <address>
                    <street>707 State</street>
                    <city>New York</city>
                    <state>NY</state>
                    <zipCode>12345</zipCode>
                </address>
                <phoneNumber>1-521-456-4576</phoneNumber>
                <ssn>56545</ssn>
            </customer>
        * */
  }
}

