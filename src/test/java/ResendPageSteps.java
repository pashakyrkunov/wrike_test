import org.openqa.selenium.WebDriver;

public class ResendPageSteps {
    private ResendPage resendPage;


    public ResendPageSteps(WebDriver driver){
        resendPage = new ResendPage(driver);
    }

    public void action () {
        resendPage.clickAnswers();
        resendPage.clickSubmitButton();
        resendPage.checkTwitterButton();
        resendPage.checkTwitterLink();
    }
}
