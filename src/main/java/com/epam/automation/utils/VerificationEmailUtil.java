package com.epam.automation.utils;

import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class VerificationEmailUtil {
    private static final String userEmailLogin = "rxzh6hr71b";
    private static final String emailPostfix = "esiix.com";
    private static final String emailURLPath = "https://www.1secmail.com/api/v1/";

    public static int getVerificationEmailCode(String actionValue) {
        RequestSpecification requestSpecification = given()
                .queryParam("action", actionValue)
                .queryParam("login", userEmailLogin)
                .queryParam("domain", emailPostfix);
        if (actionValue.equals("readMessage")) {
            requestSpecification.queryParam("id", getVerificationEmailCode("getMessages"));
        }
        ExtractableResponse extractableResponse = requestSpecification.when()
                .get(emailURLPath)
                .then()
                .extract();
        if (actionValue.equals("readMessage")) {
            String[] bodyOfMail = extractableResponse
                    .path("body")
                    .toString()
                    .split(" ");
            for (int i = 0; i < bodyOfMail.length; i++) {
                if (bodyOfMail[i].equals("code:")) {
                    return Integer.parseInt(bodyOfMail[i + 1].replaceAll("\\D", ""));
                }
            }
        } else if (actionValue.equals("getMessages")) {
            ArrayList emailIdList = (ArrayList) extractableResponse.path("id");
            return (Integer) emailIdList.get(0);
        }
        return 0;
    }
}