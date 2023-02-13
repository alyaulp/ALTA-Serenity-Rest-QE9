package starter.Reqres;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class DeleteStepDefinitions {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete user with invalid id {int}")
    public void deleteUserWithInvalidParameterId(int id) {
        reqresAPI.deleteUser(id);
    }
}
