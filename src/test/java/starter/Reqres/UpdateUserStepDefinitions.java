package starter.Reqres;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.Utils.Constant;

import java.io.File;

public class UpdateUserStepDefinitions {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Update user with invalid json and parametera id {int}")
    public void updateUserWithInvalidJsonAndParameteraId(int id) {
        File jsonInvName = new File(Constant.ReqBody+"UpdateUserInvalidNameBody.json");
        reqresAPI.putUpdateUser(id ,jsonInvName);
    }

    @Given("Update user with invalid job json and parameter id {int}")
    public void updateUserWithInvalidJobJsonAndParameterId(int id) {

        File jsonInvJob = new File(Constant.ReqBody+"UpdateUserInvalidJobBody.json");
        reqresAPI.putUpdateUser(id ,jsonInvJob);
    }

    @Given("Update user with blank name and job, json and parameter id {int}")
    public void updateUserWithBlankNameAndJobJsonAndParameterId(int id) {
        File jsonblank = new File(Constant.ReqBody+"UpdateUserBlankBody.json");
        reqresAPI.putUpdateUser(id ,jsonblank);
    }

}
