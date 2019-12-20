package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractSteps {

    protected WebDriver driver;
    private WebDriverWait wait;

    public AbstractSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    public WebElement getVisibleWebElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean elementIsDisplayed(By by) {
        return driver.findElement(by).isDisplayed();
    }

    public boolean elementIsNotDisplayed(By by) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}
