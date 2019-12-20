package steps;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.ResendPage;

import java.util.Random;

public class ResendPageSteps extends AbstractSteps {
    private final Random random = new Random();

    private ResendPage resendPage;

    public ResendPageSteps(WebDriver driver) {
        super(driver);
        resendPage = new ResendPage(driver);
    }

    @Step("Choose random answer for the 1st question")
    public ResendPageSteps sendFirstAnswer() {
        sendFirstAnswer(random.nextInt(2) + 1);
        return this;
    }

    //overloaded method if necessary to check certain button
    @Step("Choose answer number {ans} for the 1st question")
    public ResendPageSteps sendFirstAnswer(int ans) {
        switch (ans) {
            case 1:
                getVisibleWebElement(resendPage.ANS1_1).click();
                break;
            case 2:
                getVisibleWebElement(resendPage.ANS1_2).click();
                break;
        }
        return this;
    }

    @Step("Choose random answer for the 2nd question")
    public ResendPageSteps sendSecondAnswer() {
        sendSecondAnswer(random.nextInt(5) + 1);
        return this;
    }

    //overloaded method if necessary to check certain button
    @Step("Choose answer number {ans} for the 2nd question")
    public ResendPageSteps sendSecondAnswer(int ans) {
        switch (ans) {
            case 1:
                getVisibleWebElement(resendPage.ANS2_1).click();
                break;
            case 2:
                getVisibleWebElement(resendPage.ANS2_2).click();
                break;
            case 3:
                getVisibleWebElement(resendPage.ANS2_3).click();
                break;
            case 4:
                getVisibleWebElement(resendPage.ANS2_4).click();
                break;
            case 5:
                getVisibleWebElement(resendPage.ANS2_5).click();
                break;
        }
        return this;
    }

    @Step("Choose random answer for the 3rd question")
    public ResendPageSteps sendThirdAnswer() {
        sendThirdAnswer(random.nextInt(3) + 1);
        return this;
    }

    //overloaded method if necessary to check certain button
    @Step("Choose answer number {ans} for the 3rd question")
    public ResendPageSteps sendThirdAnswer(int ans) {
        switch (ans) {
            case 1:
                getVisibleWebElement(resendPage.ANS3_1).click();
                break;
            case 2:
                getVisibleWebElement(resendPage.ANS3_2).click();
                break;
            case 3:
                getVisibleWebElement(resendPage.ANS3_3).click();
                WebElement commentField = getVisibleWebElement(resendPage.ANS3_3_COMMENT);
                commentField.clear();
                commentField.sendKeys(RandomStringUtils.randomAlphabetic(10));
                break;
        }
        return this;
    }

    @Step("Press 'Submit' button")
    public ResendPageSteps clickSubmitButton() {
        getVisibleWebElement(resendPage.SUBMIT_BUTTON).click();
        return this;
    }

    @Step("Check 'Thanks for helping us out!' is displayed")
    public ResendPageSteps checkSurveySuccessIsDisplayed() {
        Assert.assertTrue(elementIsDisplayed(resendPage.SHOW_THANKS));
        return this;
    }

    @Step("Check 'Thanks for helping us out!' is not displayed")
    public ResendPageSteps checkSurveySuccessIsNotDisplayed() {
        Assert.assertTrue(elementIsNotDisplayed(resendPage.SHOW_THANKS));
        return this;
    }

    @Step("Check existing of Twitter link")
    public ResendPageSteps checkTwitterButton() {
        Assert.assertTrue(elementIsDisplayed(resendPage.TWITTER));
        return this;
    }

    @Step("Check correctness of Twitter link")
    public ResendPageSteps checkTwitterLink() {
        Assert.assertEquals(
                "https://twitter.com/wrike",
                getVisibleWebElement(resendPage.TWITTER).getAttribute("href"));
        return this;
    }

}
