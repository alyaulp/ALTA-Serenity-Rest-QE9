package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import javax.swing.*;

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
        SerenityRest.then().body("page",equalTo(page));
    }

    // Scenario 2
    @Given("Create new user with valid json")
    public void createNewUserWithValidJson() {
        File jsonReq = new File(ReqresAPI.DIR+"/src/test/resources/JSON/ReqBody/UserReqBody.json");
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
                .body("name",equalTo(name))
                .body("job",equalTo(job));
    }
}
