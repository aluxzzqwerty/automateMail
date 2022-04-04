import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {}

    public static WebDriver getInstanceOfWebdriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "/home/alua/IdeaProjects/SeleniumProject/src/main/resources/chromedriver_linux64/chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }
}
