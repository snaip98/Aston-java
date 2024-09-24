package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final By cookieButton = By.xpath("//button[@class = 'btn btn_black cookie__ok']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void waitElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement findElement(By xpath) {
        waitElement(xpath);
        return driver.findElement(xpath);
    }

    protected void checkText(By locator, String expText) {
        Assert.assertEquals(findElement(locator).getText(), expText);
    }

    protected void fillInput(By data, String value) {
        findElement(data).sendKeys(value);
    }

    protected void iteratorLogo(By[] logos) {
        for (By locator : logos) {
            try {
                waitElement(locator);
                Assert.assertTrue(findElement(locator).isDisplayed(), "Логотип не отображается" + logos.toString());
            } catch (TimeoutException e) {
                Assert.fail("Логотип не найден в течении ожидания: " + logos.toString());
            }
        }
    }

    public void checkCookie() {
        try {
            waitElement(cookieButton);
            findElement(cookieButton).click();

        } catch (TimeoutException e) {
            System.out.println("Cookie не обнаружены");
        }
    }
}