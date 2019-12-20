package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.StartPage;

public class StartPageSteps extends AbstractSteps {
    private StartPage startPage;

    public StartPageSteps(WebDriver driver) {
        super(driver);
        startPage = new StartPage(driver);
    }

    @Step("Press button 'Get started'")
    public StartPageSteps clickGetStartedButton() {
        getVisibleWebElement(startPage.GET_STARTED_BUTTON).click();
        return this;
    }

    @Step("Press button 'Create account'")
    public StartPageSteps clickCreateAccountButton() {
        getVisibleWebElement(startPage.CREATE_ACCOUNT_BUTTON).click();
        return this;
    }

    @Step("Type email")
    public StartPageSteps typeEmail(String email) {
        WebElement emailField = getVisibleWebElement(startPage.EMAIL_FIELD);
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }
}
