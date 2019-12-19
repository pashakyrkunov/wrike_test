import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage extends BasePage {

    private By GET_STARTED_BUTTON = By.xpath(".//*[@class='wg-header__desktop']//*[@class='wg-header__free-trial-button wg-btn wg-btn--green']");
    private By EMAIL_FIELD = By.xpath(".//*[@class='modal-form-trial__label']//*[@name='email']");
    private By CREATE_ACCOUNT_BUTTON = By.xpath(".//*[@class='modal-form-trial__label']//*[@type='submit']");



    public StartPage(WebDriver driver) {
        super(driver);
        check();
    }

    public void check() {
        Assert.assertTrue( "Не дождались кнопки get started",
                new WebDriverWait(driver, 20).until((ExpectedCondition<Boolean>) d ->
                        isElementVisible(GET_STARTED_BUTTON)));
    }

    @Description("Нажатие кнопки GetStarted")
    @Step
    public StartPage clickGetStartedButton() {
        driver.findElement(GET_STARTED_BUTTON).click();

        return this;
    }

    @Description("Ввод email")
    @Step
    public StartPage typeEmail(String email) {
        driver.findElement(EMAIL_FIELD).clear();
        driver.findElement(EMAIL_FIELD).sendKeys(email);

        return this;
    }

    @Description("Нажатие кнопки Create account")
    @Step
    public ResendPage clickCreateAccountButton() {
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();

        return  new ResendPage(driver);
    }
}
