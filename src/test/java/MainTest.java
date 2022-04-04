import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFactory.LoginPage;

import java.io.IOException;
import java.util.List;

public class MainTest extends Base{

    @Test(dataProvider = "data-provider")
    @Severity(SeverityLevel.NORMAL)
    @Description("Logging into mail.ru and validating one text message")
    public void basePageNavigation(String username, String password) throws IOException {
        driver = initializerDriver();
        driver.get(prop.getProperty("url"));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logingUpIntoAccount(username, password);

        Actions actions = new Actions(driver);

        List<WebElement> elements = loginPage.getListOfElements();

        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equalsIgnoreCase("Нурмагамбетова Алуа")) {
                actions.moveToElement(elements.get(i)).click().perform();
                List<WebElement> texts = loginPage.getListOfTexts();
                for (int j = 0; j < texts.size(); j++) {
                    if (texts.get(j).getText().equalsIgnoreCase("Welcome to KIMEP University!")) {
                        Assert.assertEquals(texts.get(j).getText(), "Welcome to KIMEP University!");
                        break;
                    }
                }
            }
        }

    }

    @DataProvider (name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"fakeusername00@mail.ru", "qaz85201234"}, {"alua@mail.ru","12345" }};
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}