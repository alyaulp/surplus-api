package starter.Surplus;


import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import starter.Surplus.Utils.ConstantSurplus;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SurplusAPI {
    public static  String API_SURPLUS = ConstantSurplus.BASE_URL;

    @Step("Post create new with request body")
    public void setPostCreateNewWithRequestBody(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Given("Get list all")
    public void getListAll() { SerenityRest.given(); }

    @Step("Post create with body invalid data")
    public void SetPostCreateWithBodyInvalidData(String title, String body, int userID) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", title);
        requestBody.put("body", body);
        requestBody.put("userID", userID);
        SerenityRest.given().contentType(ContentType.JSON).body(requestBody);
    }
}