import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import steps.ResendPageSteps;
import steps.StartPageSteps;
import utils.Utils;

import java.util.concurrent.TimeUnit;

public class MainTest {
    private WebDriver webdriver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @DisplayName("Test complete survey with random answer")
    @Description("Complete survey with random answer and check that survey successfully shows up and hides")
    @Test
    public void completeSurveyTest() {
        login(webdriver);
        new ResendPageSteps(webdriver)
                .sendFirstAnswer()
                .sendSecondAnswer()
                .sendThirdAnswer()
                .clickSubmitButton()
                .checkSurveySuccessIsDisplayed()
                .checkSurveySuccessIsNotDisplayed();
    }

    @DisplayName("Test twitter")
    @Description("Check that twitter button is displayed and twitter link is correct")
    @Test
    public void twitterTest() {
        login(webdriver);
        new ResendPageSteps(webdriver)
                .checkTwitterButton()
                .checkTwitterLink();
    }

    private void login(WebDriver webdriver) {
        String email = Utils.generateMail();
        webdriver.get("https://www.wrike.com/");
        new StartPageSteps(webdriver)
                .clickGetStartedButton()
                .typeEmail(email)
                .clickCreateAccountButton();
    }

    @After
    public void tearDown() {
        webdriver.quit();
    }
}
