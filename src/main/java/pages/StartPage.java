package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends BasePage {

    private static final String TRIAL_LABEL = ".//*[@class='modal-form-trial__label']";
    private static final String EMAIL = "//*[@name='email']";
    private static final String SUBMIT = "//*[@type='submit']";

    public final By GET_STARTED_BUTTON = By.xpath("//*[@class='wg-header__desktop']//button[contains(@class,'free-trial-button')]");
    public final By EMAIL_FIELD = By.xpath(TRIAL_LABEL + EMAIL);
    public final By CREATE_ACCOUNT_BUTTON = By.xpath(TRIAL_LABEL + SUBMIT);

    public StartPage(WebDriver driver) {
        super(driver);
    }
}
