package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constant;
import starter.Utils.ReqresResponses;

import java.io.File;

public class ReqresAPI {
    public static String GET_LIST_USERS = Constant.BASE_URL +"users?page={page}";
    public static String DELETE_SINGLE_USER = Constant.BASE_URL+"users/{id}";
    public static  String POST_CREATE_USER = Constant.BASE_URL+"users";
    public static  String GET_SINGLE_USER = Constant.BASE_URL+"users/{id}";
    public static  String PUT_UPDATE_USER = Constant.BASE_URL+"users/{id}";
    public static String POST_REGISTER_USER = Constant.BASE_URL+"register";
    public static String POST_LOGIN_USER = Constant.BASE_URL+"login";
    public static String GET_LIST_RESOURCE = Constant.BASE_URL+"unknown";
    public static  String GET_SINGLE_RESOURCE = Constant.BASE_URL+"unknown/{id}";


    @Step("Get list users")
    public void getListUsers(int page) {
        SerenityRest.given()
                .pathParam(ReqresResponses.PAGE, page);
    }

    @Step("Get list resource user")
    public void getListResourceUsers() {
        SerenityRest.given();
    }

    @Step("Post create new user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }


    @Step("Post register user")
    public void postRegisterUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post login user")
    public void postLoginUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id)
                .contentType(ContentType.JSON)
                .body(json);
    }


    @Step
    public void deleteUser(int id) {
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id);
    }



    @Step("Get single user")
    public void getSingleUser(int id) {
        SerenityRest.given()
                .pathParam(ReqresResponses.ID, id);
    }
 //   @Step("Get single user not found")
//    public void getSingleUserNotFound(int id) {
//        SerenityRest.given()
//                .pathParam(ReqresResponses.ID, id);
//    }

}
