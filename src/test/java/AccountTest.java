import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import models.ResponseUser;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AccountTest extends BaseTest{
    String accessToken;

    @Before
    public void setupUser(){
        User  user = new User();
        user.setEmail(RandomStringUtils.randomAlphabetic(10) + "@" + "yandex.ru");
        user.setPassword(RandomStringUtils.randomAlphabetic(6));
        user.setName(RandomStringUtils.randomAlphabetic(6));

        ResponseUser responseUser = steps
                .createUser(user)
                .extract().as (ResponseUser.class);
        accessToken = responseUser.getAccessToken();

        HomePage homePage = new HomePage(webDriver);
        homePage.clickLogInToAccountButton();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.inputLoginInfoUser(user.getEmail(), user.getPassword());
    }
    @Test
    @DisplayName("Переход в Личный кабинет")
    @Description("После авторизации пользователь может перейти в свой Личный кабинет")
    public void transferToPersonalAccount () {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickPersonalAccountButton();

        ProfilePage profilePage = new ProfilePage(webDriver);
        assertTrue(profilePage.exitButtonIsDisplayed());
    }
    @Test
    @DisplayName("Переход из личного кабинета в Конструктор")
    @Description("Из личного кабинета пользователь может перейти в конструктор, нажав кнопку Конструктор")
    public void clickOnTheButtonConstructorOn () {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickPersonalAccountButton();

        ProfilePage profilePage = new ProfilePage(webDriver);
        profilePage.clickConstructorButton();

        assertTrue(homePage.createOrderButtonIsEnabled());
    }
    @Test
    @DisplayName("Переход из личного кабинета в Конструктор(лого)")
    @Description("Из личного кабинета пользователь может перейти в конструктор, нажав на логотип")
    public void clickOnTheButtonLogotype () {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickPersonalAccountButton();

        ProfilePage profilePage = new ProfilePage(webDriver);
        profilePage.clickLogotypeButton();

        assertTrue(homePage.createOrderButtonIsEnabled());
    }
    @Test
    @DisplayName("Выход из личного кабинета")
    @Description("Из личного кабинета можно выйти по кнопке Выход")
    public void clickOnExitButton () {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickPersonalAccountButton();

        ProfilePage profilePage = new ProfilePage(webDriver);
        profilePage.clickExitButton();

        LoginPage loginPage = new LoginPage(webDriver);
        assertTrue(loginPage.loginInfoIsDisplayed());
    }
    @After
    public void deleteUser(){
        steps
                .deleteUser(accessToken)
                .statusCode(202);
    }
}
