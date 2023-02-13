package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

public class UserStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;
    // Get Single User
    @Given("Get single user with valid parameter id {int}")
    public void getSingleUserWithValidParameterIdId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @And("Response body should be null") // Belum berhasil validasi null body
    public void responseBodyShouldBeNull(int page) {
        SerenityRest.and().body("", null);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }

    @And("Validate get single user valid json schema")
    public void validateGetSingleUserValidJsonSchema() {
        File jsonSchemaSingleUser = new File(Constant.JSONSchema + "SingleUserValidJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaSingleUser));
    }

}
