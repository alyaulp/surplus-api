package starter.Surplus.StepDefinitions.FeatureSurplus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Steps;
import starter.Surplus.SurplusAPI;
import starter.Surplus.Utils.ConstantSurplus;

import java.io.File;

public class GetSurplusStepdefs {
    @Steps
    SurplusAPI surplusAPI;


    @Given("Send get list all")
    public void sendGetListAll() {
        SerenityRest.given().when().get(SurplusAPI.API_SURPLUS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int oke) {
        SerenityRest.then().statusCode(oke);
    }


    @And("Validate Response Json Schema")
    public void validateResponseJsonSchema() {
        File jsonSchemaResources = new File(ConstantSurplus.JSON_SCHEMA_POST +"GetListJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaResources));
    }
}
