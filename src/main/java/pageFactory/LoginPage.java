package pageFactory;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//button[@data-testid='enter-mail-primary']")
    WebElement login;

    @FindBy(xpath = ".//input[@name='username']")
    WebElement username;

    @FindBy(xpath = ".//div[@class='login-row password']/div/div/div/div/div/input")
    WebElement password;

    @FindBy(xpath = ".//div[@class='login-row']/div/div/div/button/span")
    WebElement next;

    @FindBy(xpath = ".//div[@class='login-row']/div/div/div/div/button/span")
    WebElement submit;

    @FindBy(xpath = "//iframe[@class='ag-popup__frame__layout__iframe']")
    WebElement frame;

    @FindBy(xpath = "//a[contains(@class,'js-letter-list-item')]")
    List<WebElement> elements;

    @FindBy(className = "MsoNormal_mr_css_attr")
    List<WebElement> texts;

    @Step("getting login button")
    public WebElement getLogin() { return login; }

    @Step("getting username")
    public WebElement getEmail() {
        return username;
    }

    @Step("getting password")
    public WebElement getPassword() {
        return password;
    }

    @Step("getting next button")
    public WebElement getNext() { return next; }

    @Step("getting submit button")
    public WebElement getSubmit() { return submit; }

    @Step("getting into frame")
    public WebElement getFrame() { return frame; }

    @Step("getting list of elements")
    public List getListOfElements() { return elements; }

    @Step("getting list of texts in elements")
    public List getListOfTexts() { return texts; }

    @Step("signing up into account")
    public void logingUpIntoAccount(String username, String password) {
        this.getLogin().click();

        //move to loginpage locators
        driver.switchTo().frame(this.getFrame());
        this.getEmail().sendKeys(username);
        this.getNext().click();
        this.getPassword().sendKeys(password);

        this.getSubmit().click();
        driver.switchTo().defaultContent();
    }

}
