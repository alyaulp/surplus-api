package starter.Surplus.StepDefinitions.FeatureSurplus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.assertj.core.api.Assertions;
import starter.Surplus.SurplusAPI;
import starter.Surplus.SurplusAPIcontoh;
import starter.Surplus.Utils.ConstantSurplus;

import java.io.File;

public class PostContohStepdefs {
    @Steps
    SurplusAPIcontoh surplusAPIcontoh;
    @Given("Post create new with request body contoh")
    public void postCreateNewWithRequestBodyContoh() {
        File jsonReq = new File(ConstantSurplus.JSON_REQ_BODY_POST_CONT + "PostSurplusReqBodyContoh.json");
        surplusAPIcontoh.setPostCreateNewWithRequestBody(jsonReq);
    }

    @When("Send Post create new contoh")
    public void sendPostCreateNewContoh() {
    }

    @Then("Status code should be Created contoh")
    public void statusCodeShouldBeCreatedContoh( File jsonReq) {
        int responsCode = surplusAPIcontoh.setPostCreateNewWithRequestBody(jsonReq);
               Assertions.assertThat(responsCode).isEqualTo(201);
    }

    @And("Validate resource json schema contoh")
    public void validateResourceJsonSchemaContoh() {
    }
}
