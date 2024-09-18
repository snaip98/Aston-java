import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TopUpWithoutCommissionTests {

    public static WebDriver driver;

    @BeforeAll
    public static void openWebSiteAndClickButtonOfCookie() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("//button[@class =  'btn btn_black cookie__ok']")).click();
    }

    @AfterAll
    public static void closeWebSite() {
        driver.quit();
    }

    @Test
    public void blockNameValidationTest() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.
                textToBePresentInElement(driver.findElement(By.xpath("//div[@class = 'pay__wrapper']/h2"
                )), "Онлайн пополнение\n" + "без комиссии"));
        WebElement blockName = driver.findElement(By.xpath("//div[@class = 'pay__wrapper']/h2"));
        Assertions.assertEquals("Онлайн пополнение\n" +
                "без комиссии", blockName.getText());
    }

    @Test
    public void paymentSystemsLogoPresenceTest() {
        String[] logos = new String[]{
                "//img[@alt='Visa']",
                "//img[@alt='Verified By Visa']",
                "//img[@alt='MasterCard']",
                "//img[@alt='MasterCard Secure Code']",
                "//img[@alt='Белкарт']"
        };
        for (String xpathOfLogo : logos) {
            try {
                waitForElementToBeVisible(xpathOfLogo, 5);
                Assertions.assertTrue(driver.findElement(By.xpath(xpathOfLogo)).isDisplayed(), "Логотип не отображается" + " " + xpathOfLogo);
            } catch (TimeoutException e) {
                Assertions.fail("Логотип не найден в течение ожидания: " + xpathOfLogo);
            }
        }
    }

    private static void waitForElementToBeVisible(String xpath, int timeOut) {
        new WebDriverWait(driver, Duration.ofSeconds(timeOut))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    @Test
    public void serviceLinkTest() {
        waitForElementToBeVisible("//a[@href = '/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/' ]", 5);
        driver.findElement(By.xpath("//a[@href = '/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/' ]")).click();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    public void fillFieldsAndVerifyContinueButtonTest() {
        String[] xPathes = new String[]{
                "//input[@placeholder = 'Номер телефона']",
                "//input[@placeholder = 'Сумма']",
                "//input[@placeholder = 'E-mail для отправки чека']",
                "//button[@Class = 'button button__default ']"
        };
        String[] inputData = new String[]{
                "297777777",
                "1",
                "aksnovich.ivan@gmail.com"
        };
        for (int i = 0; i < inputData.length; i++) {
            waitForElementToBeVisible(xPathes[i], 5);
            driver.findElement(By.xpath(xPathes[i])).sendKeys(inputData[i]);
        }
        WebElement continueButton = driver.findElement(By.xpath("//button[@Class = 'button button__default ']"));
        Assertions.assertTrue(continueButton.isEnabled(), "Кнопка 'Продолжить' должна быть доступна для нажатия.");
        continueButton.click();
    }
}