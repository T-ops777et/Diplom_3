import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import steps.Steps;
import static constants.Url.URL;

public abstract class BaseTest {
    public static WebDriver webDriver;
    public final Steps steps = new Steps();
    @Before
    public void setup(){
        webDriver = WebDriverFactory.getWebDriver();
        webDriver.get(URL);
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = URL;
    }
    @After
    public void tearDown(){
        webDriver.quit();
    }
}
