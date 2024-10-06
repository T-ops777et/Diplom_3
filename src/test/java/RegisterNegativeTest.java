
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RegisterNegativeTest extends BaseTest{
    private final String name = RandomStringUtils.randomAlphabetic(6);
    private final String email = RandomStringUtils.randomAlphabetic(10) + "@" + "yandex.ru";
    private final String password = RandomStringUtils.randomAlphabetic(5);

    @Test
    @DisplayName("the password must be at least 6 characters long")
    @Description("you cannot register with an invalid password")
    public void registerBadTest () {HomePage homePage = new HomePage(webDriver);
        homePage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickRegisterButton();

        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.inputLoginInfoUser(name, email, password);

        assertTrue(loginPage.messageErrorIsDisplayed());

    }
}

