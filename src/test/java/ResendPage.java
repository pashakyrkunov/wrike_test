import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class ResendPage extends BasePage{

    final Random random = new Random();

    private By ANS1_1 = By.xpath(".//*[@data-code='interest_in_solution']//*[contains(text(),'Very interested')]");
    private By ANS1_2 = By.xpath(".//*[@data-code='interest_in_solution']//*[contains(text(),'Just looking')]");
    private By ANS2_1 = By.xpath(".//*[@data-code='team_members']//*[contains(text(),'1–5')]");
    private By ANS2_2 = By.xpath(".//*[@data-code='team_members']//*[contains(text(),'6–15')]");
    private By ANS2_3 = By.xpath(".//*[@data-code='team_members']//*[contains(text(),'16–25')]");
    private By ANS2_4 = By.xpath(".//*[@data-code='team_members']//*[contains(text(),'26–50')]");
    private By ANS2_5 = By.xpath(".//*[@data-code='team_members']//*[contains(text(),'50+')]");
    private By ANS3_1 = By.xpath(".//*[@data-code='primary_business']//*[contains(text(),'Yes')]");
    private By ANS3_2 = By.xpath(".//*[@data-code='primary_business']//*[contains(text(),'No')]");
    private By ANS3_3 = By.xpath(".//*[@data-code='primary_business']//*[contains(text(),'Other')]");
    private By ANS3_3_COMMENT = By.xpath(".//*[@data-code='primary_business']//*[contains(text(),'Other')]//*input[@placeholder='Your comment'");
    private By SUBMIT_BUTTON = By.xpath(".//*[@class='submit wg-btn wg-btn--navy js-survey-submit']");
    private By TWITTER = By.xpath(".//*[@class='wg-footer__social-item']//*[contains(@href,'twitter')]");
    private  By FOLLOW_US = By.xpath(".//*[@class='wg-footer__social-block']");


    public ResendPage(WebDriver driver) {
        super(driver);
        check();
    }


    public void check() {
        Assert.assertTrue( "Не дождались кнопки",
                new WebDriverWait(driver, 20).until((ExpectedCondition<Boolean>) d
                        -> isElementVisible(ANS2_1)));
        Assert.assertTrue( "Не дождались раздела FOLLOW_US",
                new WebDriverWait(driver, 20).until((ExpectedCondition<Boolean>) d
                        -> isElementVisible(FOLLOW_US)));
        Assert.assertTrue( "Не дождались кнопки submit",
                new WebDriverWait(driver, 20).until((ExpectedCondition<Boolean>) d
                        -> isElementVisible(SUBMIT_BUTTON)));
    }

    @Description("Ответы на вопросы в анкете")
    @Step
    public ResendPage clickAnswers() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        switch (random.nextInt(2) + 1) {
            case 1:
                driver.findElement(ANS1_1).click();
                break;
            case 2:
                driver.findElement(ANS1_2).click();
                break;
        }

        switch (random.nextInt(5) + 1) {
            case 1:
                driver.findElement(ANS2_1).click();
                break;
            case 2:
                driver.findElement(ANS2_2).click();
                break;
            case 3:
                driver.findElement(ANS2_3).click();
                break;
            case 4:
                driver.findElement(ANS2_4).click();
                break;
            case 5:
                driver.findElement(ANS2_5).click();
                break;
        }

       /* switch (random.nextInt(3) + 1) {
            case 1:
                driver.findElement(ANS3_1).click();
                break;
            case 2:
                driver.findElement(ANS3_2).click();
                break;
            case 3:
                driver.findElement(ANS3_3).click();
                driver.findElement(ANS3_3_COMMENT).sendKeys("123");
                break;

        } */
        driver.findElement(ANS3_3).click();
        driver.findElement(ANS3_3_COMMENT).clear();
        driver.findElement(ANS3_3_COMMENT).sendKeys("123");
        return this;
    }

    @Description("Нажатие кнопки submit")
    @Step
    public ResendPage clickSubmitButton() {
        driver.findElement(SUBMIT_BUTTON).click();
        return this;
    }

    @Description("Проверка наличия ссылки на Twitter")
    @Step
    public ResendPage checkTwitterButton() {
        Assert.assertTrue(isElementPresent(TWITTER));

        return this;
    }

    @Description("Проверка корректности ссылки перехода на Twitter")
    @Step
    public ResendPage checkTwitterLink() {
        Assert.assertEquals(
                "https://twitter.com/wrike",
                driver.findElement(TWITTER).getAttribute("href"));

        return this;
    }


}
