import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver webDriver;

    //Поле Email
    private final By emailFieldLocator = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and@type = 'text']");
    //Поле пароль
    private final By passwordFieldLocator = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and@type = 'password']");
    //кнопка Войти
    private final By buttonLoginLocator = By.xpath(".//button[text()='Войти']");
    //кнопка Зарегистрироваться
    private final By buttonRegisterLocator = By.xpath(".//a[text()='Зарегистрироваться']");
    //кнопка Восстановить пароль
    private final By buttonRecoverPasswordLocator = By.xpath(".//a[text()='Восстановить пароль']");
    //сообщение об ошибке
    private final By messageErrorLocator = By.xpath(".//p[text()='Некорректный пароль']");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Заполнение полей для входа в аккаунт")
    public void inputLoginInfoUser(String email,String password) {
        new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable (emailFieldLocator));
        WebElement emailInput = webDriver.findElement(emailFieldLocator);
        emailInput.sendKeys(email);
        WebElement passwordInput = webDriver.findElement(passwordFieldLocator);
        passwordInput.sendKeys(password);
        new WebDriverWait(webDriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable (buttonLoginLocator));
        WebElement loginButton = webDriver.findElement(buttonLoginLocator);
        loginButton.click();
    }
    @Step("Нажатие на кнопку Зарегистрироваться")
    public void clickRegisterButton(){
        WebElement registerButton = webDriver.findElement(buttonRegisterLocator);
        registerButton.click();
    }
    @Step("Нажатие на кнопку Восстановить пароль")
    public void clickRecoverPasswordButton(){
        WebElement recoverPasswordButton = webDriver.findElement(buttonRecoverPasswordLocator);
        recoverPasswordButton.click();
    }
    @Step("Проверить видимость поля ввода email")
    public boolean loginInfoIsDisplayed (){
        new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable (emailFieldLocator));
        return webDriver.findElement(emailFieldLocator).isDisplayed();
    }
    @Step("Ожидание загрузки страницы")
    public void waitForLoad() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Вход']")));
    }
    @Step("Проверка ошибки при невалидном пароле")
    public boolean messageErrorIsDisplayed (){
        return webDriver.findElement(messageErrorLocator).isDisplayed();
    }
}