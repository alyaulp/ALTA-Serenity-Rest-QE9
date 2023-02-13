package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

public class RegisterStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;

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
