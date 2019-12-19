import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainTest {
    private WebDriver webdriver;

    @Before
    public void setUp() {
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
    }

    @Test
    public void test() {
        webdriver.get("https://www.wrike.com/");
        StartPageSteps sps = new StartPageSteps(webdriver);
        sps.login();
        ResendPageSteps rps = new ResendPageSteps(webdriver);
        rps.action();

    }

    @After
    public void tearDown() {
        webdriver.quit();
    }
}
