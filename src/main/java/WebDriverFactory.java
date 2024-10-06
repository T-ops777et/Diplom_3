import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
public class WebDriverFactory {
    public static WebDriver webDriver;
    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            String browser = System.getProperty("browser","chrome");
            switch (browser) {
                case "chrome":
                    return WebDriverManager.chromedriver().create();
                case "yandex":
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
                    return new ChromeDriver();
                default:
                    throw new RuntimeException("Unsupported browser: + browser");
            }
        }
        return webDriver;
    }
}
