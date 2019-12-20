package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResendPage extends BasePage {

    public final By ANS1_1 = By.xpath("//*[@for='interest_in_solution_1']//button");
    public final By ANS1_2 = By.xpath("//*[@for='interest_in_solution_2']//button");
    public final By ANS2_1 = By.xpath("//*[@data-code='1-5']/../button");
    public final By ANS2_2 = By.xpath("//*[@data-code='6-15']/../button");
    public final By ANS2_3 = By.xpath("//*[@data-code='16-25']/../button");
    public final By ANS2_4 = By.xpath("//*[@data-code='26-50']/../button");
    public final By ANS2_5 = By.xpath("//*[@data-code='50+']/../button");
    public final By ANS3_1 = By.xpath("//*[@data-code='yes']/../button");
    public final By ANS3_2 = By.xpath("//*[@data-code='no']/../button");
    public final By ANS3_3 = By.xpath("//*[@data-code='other']/../button");
    public final By ANS3_3_COMMENT = By.xpath("//*[@data-code='other']/../button//input[@placeholder='Your comment']");
    public final By SUBMIT_BUTTON = By.xpath("//*//*[@class='survey-form']//button[@type='submit']");
    public final By TWITTER = By.xpath("//*[@class='wg-footer__social-item']//*[contains(@href,'twitter')]");
    public final By SHOW_THANKS = By.xpath("//*[@class='survey-success']");

    public ResendPage(WebDriver driver) {
        super(driver);
    }
}
