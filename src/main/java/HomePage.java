import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver webDriver;
    //Кнопка "Личный кабинет" на главной страницы
    private final By personalAccountButtonLocator = By.xpath(".//a[@class = 'AppHeader_header__link__3D_hX' and @href='/account']");
    //Кнопка "Войти в аккаунт" на главной страницы
    private final By logInToAccountButtonLocator = By.xpath(".//button[@class = 'button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    //Кнопка заголовка "Булки" в разделе конструктор
    private final By bunsConstructorButtonLocator = By.xpath(".//span[contains(text(),'Булки')]");
    //Кнопка заголовка "Соусы" в разделе конструктор
    private final By saucesConstructorButtonLocator = By.xpath(".//span[contains(text(),'Соусы')]");
    //Кнопка заголовка "Начинки" в разделе конструктор
    private final By fillingsConstructorButtonLocator = By.xpath(".//span[contains(text(),'Начинки')]");
    //Кнопка "Оформить заказ"
    private final By createOrderButtonLocator = By.xpath(".//button[text()='Оформить заказ']");
    //Разделы меню в контейнере
    private final By menuSectionLocator = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");


    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    @Step("Нажатие на кнопку Личный кабинет")
    public void clickPersonalAccountButton(){
        WebElement personalAccountButton = webDriver.findElement(personalAccountButtonLocator);
        personalAccountButton.click();
    }
    @Step("Нажатие на кнопку Войти в аккаунт")
    public void clickLogInToAccountButton(){
        WebElement logInToAccountButton = webDriver.findElement(logInToAccountButtonLocator);
        logInToAccountButton.click();
    }
    @Step("Нажатие на кнопку Конструктор")
    public void clickBunsConstructorButton(){
        WebElement bunsConstructorButton = webDriver.findElement(bunsConstructorButtonLocator);
        bunsConstructorButton.click();
    }
    @Step("Нажатие на кнопку Соусы в Конструкторе")
    public void clickSaucesConstructorButton(){
        WebElement saucesConstructorButton = webDriver.findElement(saucesConstructorButtonLocator);
        saucesConstructorButton.click();
    }
    @Step("Нажатие на кнопку Начинки в Конструкторе")
    public void clickFillingsConstructorButton(){
        WebElement fillingsConstructorButton = webDriver.findElement(fillingsConstructorButtonLocator);
        fillingsConstructorButton.click();
    }
    @Step("Нажатие на кнопку Создать заказ")
    public boolean createOrderButtonIsEnabled (){
        new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable (createOrderButtonLocator));
        return webDriver.findElement(createOrderButtonLocator).isEnabled();
    }
    @Step("Проверить переход в разделы")
    public String menuSectionIsTransfer (){
        WebElement menuSection = webDriver.findElement(menuSectionLocator);
        return menuSection.getText();
    }
}