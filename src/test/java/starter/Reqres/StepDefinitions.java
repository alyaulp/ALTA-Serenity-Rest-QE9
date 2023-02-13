package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;
import starter.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class StepDefinitions {
    @Steps
    ReqresAPI reqresAPI;

    // Scenario 1
    @Given("Get list users with valid parameter page {int}")
    public void getListUserWithValidParameterPage(int page) {
        reqresAPI.getListUsers(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUsers() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USERS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body should be {int}")
    public void responseBodyShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }

    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File jsonSchemaListUser = new File(Constant.JSONSchema+"ListUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaListUser));
    }

    // Scenario 2
    @Given("Create new user with valid json")
    public void createNewUserWithValidJson() {
        File jsonReq = new File(Constant.ReqBody+"UserReqBody.json");
        reqresAPI.postCreateUser(jsonReq);
    }

    @When("Send request post create user")
    public void sendRequestPostCreateUser() {
        SerenityRest.when().post(ReqresAPI.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body name should be {string} and jobs is {string}")
    public void responseBodyNameBeAndJobIs(String name, String job) {
        SerenityRest.and()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @Given("Update user with valid json and parameter id {int}")
    public void updateUserWithValidJsonAndParameterId(int id) {
        File jsonReq = new File(Constant.ReqBody+"UserReqBody.json");
        reqresAPI.putUpdateUser(id ,jsonReq);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresAPI.PUT_UPDATE_USER);
    }

    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidParameterId(int id) {
        reqresAPI.deleteUser(id);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(ReqresAPI.DELETE_SINGLE_USER);
    }
//contoh
    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @And("Response body first name should be {string} and last name is {string}")
    public void responseBodyFirstNameShouldBeAndLastNameIs(String firstName, String lastName) {
        SerenityRest.and()
                .body(ReqresResponses.DATA_FIRST_NAME,equalTo(firstName))
                .body(ReqresResponses.DATA_LAST_NAME,equalTo(lastName));
    }

    @Given("Register new user with valid json")
    public void registerNewUserWithValidJson() {
        File jsonReq = new File(Constant.ReqBody+"RegisterUserBody.json");
        reqresAPI.postRegisterUser(jsonReq);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }

    @And("Respose body id should be {int} and token is {string}")
    public void resposeBodyIdShouldBeAndTokenIs(int id, String token) {
        SerenityRest.and()
                .body(ReqresResponses.ID,equalTo(id))
                .body(ReqresResponses.TOKEN,equalTo(token));
    }

    @Given("Register new user with invalid json")
    public void registerNewUserWithInvalidJson() {
        File jsonReq = new File(Constant.ReqBody+"RegisterInvalidUserBody.json");
        reqresAPI.postRegisterUser(jsonReq);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Respose body error should be {string}")
    public void resposeBodyErrorShouldBe(String error) {
        SerenityRest.and()
                .body(ReqresResponses.ERROR,equalTo(error));
    }

    @And("Validate post new user json schema")
    public void validatePostNewUserJsonSchema() {
        File jsonSchemaCreateUser = new File(Constant.JSONSchema+"CreateUserJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaCreateUser));
    }

}
