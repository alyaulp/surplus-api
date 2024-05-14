package starter.Surplus;


import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.Surplus.Utils.ConstantSurplus;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SurplusAPIcontoh {
    public static  String API_SURPLUS = ConstantSurplus.BASE_URL_CONTOH;
public static  String POST_CONTOH = API_SURPLUS + "/api/users";
    @Step("Post create new with request body")
    public int setPostCreateNewWithRequestBody(File json) {
      //  SerenityRest.given().contentType(ContentType.JSON).body(json);
        SerenityRest.given().contentType(ContentType.JSON).body(json).when().post(POST_CONTOH);
    int responsCode = SerenityRest.given().contentType(ContentType.JSON).body(json).when().post(POST_CONTOH).getStatusCode();
    return responsCode; }


//    @Step("Status code should be 201 Created contoh")
//    public void setPostCreateNewWithRequestBody(File json) {
//        //  SerenityRest.given().contentType(ContentType.JSON).body(json);
//        SerenityRest.given().contentType(ContentType.JSON).body(json).when().post(POST_CONTOH);

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