import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver webDriver;

    //кнопка Конструктор
    private final By constructorButtonLocator = By.xpath(".//a[@class='AppHeader_header__link__3D_hX' and @href = '/']");
    //кнопка Логотип
    private final By logotypeButtonLocator = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    //кнопка Выход
    private final By exitButtonLocator = By.xpath(".//button[text()='Выход']");

    public ProfilePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Нажатие на кнопку Конструктор")
    public void clickConstructorButton(){
        WebElement constructorButton = webDriver.findElement(constructorButtonLocator);
        constructorButton.click();
    }
    @Step("Нажатие на Логотип")
    public void clickLogotypeButton(){
        WebElement logotypeButton = webDriver.findElement(logotypeButtonLocator);
        logotypeButton.click();
    }
    @Step("Нажатие на кнопку Выход")
    public void clickExitButton(){
        new WebDriverWait(webDriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable (exitButtonLocator));
        WebElement exitButton = webDriver.findElement(exitButtonLocator);
        exitButton.click();
    }
    @Step("Проверка видимости кнопки Выход")
    public boolean exitButtonIsDisplayed(){
        new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable (exitButtonLocator));
        return webDriver.findElement(exitButtonLocator).isDisplayed();
    }

}
