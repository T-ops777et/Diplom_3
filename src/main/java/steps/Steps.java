package steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import models.User;

import static io.restassured.RestAssured.given;

public class Steps {
    public static final String REGISTER = "/api/auth/register";
    public static final String LOGIN = "/api/auth/login";
    public static final String USER = "/api/auth/user";

    @Step("Создание пользователя")
    public ValidatableResponse createUser(User user) {

        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(REGISTER)
                .then();
    }

    @Step("Авторизация пользователя")
    public ValidatableResponse authUser(User user) {

        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(LOGIN)
                .then();
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .header("authorization", accessToken)
                .when()
                .delete(USER)
                .then();
    }
}