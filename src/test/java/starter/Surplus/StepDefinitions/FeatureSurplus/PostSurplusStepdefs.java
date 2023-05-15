package starter.Surplus.StepDefinitions.FeatureSurplus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Surplus.SurplusAPI;
import starter.Surplus.Utils.ConstantSurplus;

import java.io.File;

public class PostSurplusStepdefs {
    @Steps
    SurplusAPI surplusAPI;

    //Post create new with request body
    @Given("Post create new with request body")
    public void postCreateNewWithRequestBody() {
        File jsonReq = new File(ConstantSurplus.JSON_REQ_BODY_POST + "PostSurplusReqBody.json");
        surplusAPI.setPostCreateNewWithRequestBody(jsonReq);
    }

    @When("Send Post create new")
    public void sendCreateNew() {SerenityRest.when().post(SurplusAPI.API_SURPLUS);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int oke) {
        SerenityRest.then().statusCode(oke);
    }

    @And("Validate resource json schema")
    public void validateResourceJsonSchema(){
        File jsonSchemaResources = new File(ConstantSurplus.JSON_SCHEMA_POST +"CreateNewJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaResources));
    }

    //Post create with body empty data

    @Given("Post create with body title {string} body {string} userID {int}")
    public void postCreateWithBodyInvalidData(String title, String body, int userID ) {
        surplusAPI.SetPostCreateWithBodyInvalidData(title, body, userID);
    }
    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(SurplusAPI.API_SURPLUS);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int bad) {
        SerenityRest.then().statusCode(bad);
    }

}
