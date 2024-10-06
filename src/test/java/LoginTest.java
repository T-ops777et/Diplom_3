
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import models.ResponseUser;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest{
    private User user;
    String accessToken;
    @Before
    public void setupUser(){
        user = new User();
        user.setEmail(RandomStringUtils.randomAlphabetic(10) + "@" + "yandex.ru");
        user.setPassword(RandomStringUtils.randomAlphabetic(6));
        user.setName(RandomStringUtils.randomAlphabetic(6));

        ResponseUser responseUser = steps
                .createUser(user)
                .extract().as (ResponseUser.class);
        accessToken = responseUser.getAccessToken();

    }
    @Test
    @DisplayName("Проверка входа в аккаунт")
    @Description("Пользователь может войти в учетную запись, нажав кнопку Войти на главной странице")
    public void loginToAccountButtonTest () {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickLogInToAccountButton();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.inputLoginInfoUser(user.getEmail(), user.getPassword());

        assertTrue(homePage.createOrderButtonIsEnabled());
    }
    @Test
    @DisplayName("Проверка входа в аккаунт")
    @Description("Пользователь может войти в учетную запись, нажав кнопку Личный кабинет на главной странице")
    public void loginPersonalAccountButtonTest () {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.inputLoginInfoUser(user.getEmail(), user.getPassword());

        assertTrue(homePage.createOrderButtonIsEnabled());
    }
    @Test
    @DisplayName("Проверка входа в аккаунт из формы регистрации")
    @Description("Пользователь может войти в учетную запись, нажав кнопку Войти из формы регистрации")
    public void loginFromRegistrationButtonTest () {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickRegisterButton();

        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.clickLoginButton();

        loginPage.inputLoginInfoUser(user.getEmail(), user.getPassword());

        assertTrue(homePage.createOrderButtonIsEnabled());
    }
    @Test
    @DisplayName("Проверка входа в аккаунт из формы восстановления пароля")
    @Description("Пользователь может войти в учетную запись, нажав кнопку Войти из формы восстановления пароля")
    public void loginFromRecoverPasswordTest () {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickRecoverPasswordButton();

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(webDriver);
        forgotPasswordPage.clickLoginButton();

        loginPage.inputLoginInfoUser(user.getEmail(), user.getPassword());

        assertTrue(homePage.createOrderButtonIsEnabled());
    }

    @After
    public void deleteUser(){
        steps
                .deleteUser(accessToken)
                .statusCode(202);
    }
}

