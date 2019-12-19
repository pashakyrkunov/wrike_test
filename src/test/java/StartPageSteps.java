import org.openqa.selenium.WebDriver;

public class StartPageSteps {
    private StartPage startPage;


    public StartPageSteps(WebDriver driver){
        startPage = new StartPage(driver);
    }

    public void login() {
        startPage.clickGetStartedButton();
        String email = MailGenerator.generateMail();
        startPage.typeEmail(email);
        startPage.clickCreateAccountButton();
    }
}
