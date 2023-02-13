package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;
import starter.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ResourceUserStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;

    // Get List Resource
    @Given("Get list resource user with valid data")
    public void getListResourceUserWithValidData() {
        reqresAPI.getListResourceUsers();
    }

    @When("Send request get list resource user")
    public void sendRequestGetListResourceUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_RESOURCE);
    }

    @And("Response body id should be {int} and name is {string}") // Belum berhasil validasi response array
    public void responseBodyIdShouldBeAndNameIs(int id, String name) {
        SerenityRest.and()
                .body(ReqresResponses.DATA_ID, equalTo(id))
                .body(ReqresResponses.DATA_NAME, equalTo(name));
    }

    @Given("Get single resource user with id {int}")
    public void getSingleResourceUserWithId(int id) {
        reqresAPI.getSingleUser(id);
    }

    @And("Validate get list Resource body")
    public void validateGetListResourceBodyIdShouldBeAndNameIs() {
        File jsonResource = new File(Constant.JSONSchema + "ListResourceUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonResource));
    }

    @When("Send request get single resource user")
    public void sendRequestGetSingleResourceUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_RESOURCE);
    }

    @And("Validate get single resource body")
    public void validateGetSingleResourceBody() {
        File jsonSingleResource = new File(Constant.JSONSchema + "SingleResourceJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSingleResource));
    }
}
