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

import static  org.hamcrest.Matchers.equalTo;

public class PostStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;

    // Post User Login
    @Given("User login with valid json")
    public void userLoginWithValidJson() {
        File jsonreq = new File(Constant.ReqBody+"LoginUserBody.json");
        reqresAPI.postLoginUser(jsonreq);
    }

    @When("Send request post login")
    public void sendRequestPostLogin() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_USER);
    }

    @And("Respose body token should be {string}")
    public void resposeBodyTokenShouldBe(String token) {
        SerenityRest.then().body(ReqresResponses.TOKEN,equalTo(token));
    }

    @And("Validate post login json schema")
    public void validatePostLoginJsonSchema() {
        File jsonSchemaLoginUser = new File(Constant.JSONSchema+"LoginUserJSON.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaLoginUser));
    }

    @Given("User login with invalid json")
    public void userLoginWithInvalidJson() {
        File jsonreq = new File(Constant.ReqBody+"LoginUserFailedBody.json");
        reqresAPI.postLoginUser(jsonreq);
    }

    @And("Validate post login failed json schema")
    public void validatePostLoginFailedJsonSchema() {
        File jsonSchemaLoginUser = new File(Constant.JSONSchema+"LoginUserFailedJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaLoginUser));
    }

    @Given("User login with blank email and valid password")
    public void userLoginWithBlankEmailAndValidPassword() {
        File jsonreqblankemail = new File(Constant.ReqBody+"LoginUserFailedemailBody.json");
        reqresAPI.postLoginUser(jsonreqblankemail);
    }

    @And("Response body error should be {string}")
    public void responseBodyErrorShouldBe(String missing_email) {
        SerenityRest.then().body(ReqresResponses.ERROR,equalTo(missing_email));
    }


    @Given("User login with blank email and blank password")
    public void userLoginWithBlankEmailAndBlankPassword() {
        File jsonblankemailpass = new File(Constant.ReqBody+"LoginUserNullBody.json");
        reqresAPI.postLoginUser(jsonblankemailpass);

    }

    @And("Validate post register json schema")
    public void validatePostRegisterJsonSchema() {
        File jsonSchemaRegisterUser = new File(Constant.JSONSchema+"RegisterSuccessJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaRegisterUser));
    }

    @And("Validate post register invalid json schema")
    public void validatePostRegisterInvalidJsonSchema() {
        File jsonSchemaRegisterInvalidUser = new File(Constant.JSONSchema+"RegisterUnsuccessJSONSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaRegisterInvalidUser));
    }

    @Given("Register new user with blank email and valid password")
    public void registerNewUserWithBlankEmailAndValidPassword() {
        File jsonblankemail = new File(Constant.ReqBody+"RegisterInvalidEmailUserBody.json");
        reqresAPI.postLoginUser(jsonblankemail);
    }

    @Given("Register new user with blank email and blank password")
    public void registerNewUserWithBlankEmailAndBlankPassword() {
        File jsonblankemailandpass = new File(Constant.ReqBody+"RegisterUserNullBody.json");
        reqresAPI.postLoginUser(jsonblankemailandpass);

    }
}
