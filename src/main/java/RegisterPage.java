import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private final WebDriver webDriver;

    //Поле Имя
    private final By nameFieldLocator = By.xpath(".//label[text()='Имя']/parent::div/input[@class = 'text input__textfield text_type_main-default']");
    //Поле Email
    private final By emailFieldLocator = By.xpath(".//label[text()='Email']/parent::div/input[@class = 'text input__textfield text_type_main-default']");
    //Поле пароль
    private final By passwordFieldLocator = By.xpath(".//input[@class = 'text input__textfield text_type_main-default' and@type = 'password']");
    //кнопка Зарегистрироваться
    private final By buttonRegisterLocator = By.xpath(".//button[text()='Зарегистрироваться']");
    //кнопка Войти
    private final By buttonLoginLocator = By.xpath(".//a[text()='Войти']");

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Регистрация пользователя")
    public void inputLoginInfoUser(String name, String email,String password) {
        WebElement nameInput = webDriver.findElement(nameFieldLocator);
        nameInput.sendKeys(name);
        WebElement emailInput = webDriver.findElement(emailFieldLocator);
        emailInput.sendKeys(email);
        WebElement passwordInput = webDriver.findElement(passwordFieldLocator);
        passwordInput.sendKeys(password);
        WebElement registerButton = webDriver.findElement(buttonRegisterLocator);
        registerButton.click();
    }
    @Step("Нажатие на кнопку Войти")
    public void clickLoginButton(){
        WebElement loginButton = webDriver.findElement(buttonLoginLocator);
        loginButton.click();
    }
}