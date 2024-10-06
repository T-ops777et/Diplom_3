
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTest extends BaseTest{
    @Test
    @DisplayName("На главное странице работает переход в раздел Соусы")
    @Description("Переход в меню Соусы, при нажмите на заголовок Соусы")
    public void transferOnSaucesTest () {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickSaucesConstructorButton();
        Assert.assertEquals("Соусы", homePage.menuSectionIsTransfer());
    }
    //На главной странице работает переход к разделу Булки
    @Test
    @DisplayName("На главное странице работает переход в раздел Булки")
    @Description("Переход в меню Булки, при нажмите на заголовок Булки")
    public void transferOnBunsTest () {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickSaucesConstructorButton();
        homePage.clickBunsConstructorButton();
        Assert.assertEquals("Булки", homePage.menuSectionIsTransfer());
    }
    @Test
    @DisplayName("На главное странице работает переход в раздел Начинки")
    @Description("Переход в меню Начинки, при нажмите на заголовок Начинки")
    public void transferOnFillingsTest () {
        HomePage homePage = new HomePage(webDriver);
        homePage.clickFillingsConstructorButton();
        Assert.assertEquals("Начинки", homePage.menuSectionIsTransfer());
    }
}
