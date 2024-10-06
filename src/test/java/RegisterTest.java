
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import models.ResponseUser;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {
    private final String name = RandomStringUtils.randomAlphabetic(6);
    private final String email = RandomStringUtils.randomAlphabetic(10) + "@" + "yandex.ru";
    private final String password = RandomStringUtils.randomAlphabetic(6);

    @Test
    @DisplayName("user registration")
    @Description("to register, the user must fill in the name, email and password fields")
    public void registerTest () {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickPersonalAccountButton();

        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.clickRegisterButton();

        RegisterPage registerPage = new RegisterPage(webDriver);
        registerPage.inputLoginInfoUser(name, email, password);

        loginPage.waitForLoad();
        loginPage.inputLoginInfoUser(email, password);

        assertTrue(homePage.createOrderButtonIsEnabled());
    }
    @After
    public void deleteUser(){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        ResponseUser responseUser =
                steps
                        .authUser(user)
                        .extract().as (ResponseUser.class);
        String accessToken = responseUser.getAccessToken();
        steps
                .deleteUser(accessToken)
                .statusCode(202);
    }
}
