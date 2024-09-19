import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        checkCookie();

    }

    private static void checkCookie() {
        try {
            waitForElementToBeVisible("//button[@class =  'btn btn_black cookie__ok']", 5);
            driver.findElement(By.xpath("//button[@class =  'btn btn_black cookie__ok']")).click();
        } catch (TimeoutException e) {
            System.out.println("Cookie не отображаются");
        }
    }

    @AfterAll
    public static void closeWebSite() {
        driver.quit();
    }

    @Test
    @Order(1)
    @DisplayName("Проверка названия блока 'Онлайн пополнение без комиссии'")
    public void blockNameValidationTest() {
        waitForElementToBeVisible("//div[@class = 'pay__wrapper']/h2", 5);
        WebElement blockName = driver.findElement(By.xpath("//div[@class = 'pay__wrapper']/h2"));
        Assertions.assertEquals("Онлайн пополнение\n" +
                "без комиссии", blockName.getText());
    }

    @Test
    @Order(2)
    @DisplayName("Проверка наличия логотипов платёжных систем")
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
    @Order(3)
    @DisplayName("Проверка ссылки на страницу оплаты и безопасности")
    public void serviceLinkTest() {
        waitForElementToBeVisible("//a[@href = '/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/' ]", 5);
        driver.findElement(By.xpath("//a[@href = '/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/' ]")).click();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    @Order(4)
    @DisplayName("Заполнение полей формы и проверка кнопки 'Продолжить'")
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
        checkCookie();
        WebElement continueButton = driver.findElement(By.xpath("//button[@Class = 'button button__default ']"));
        Assertions.assertTrue(continueButton.isEnabled(), "Кнопка 'Продолжить' должна быть доступна для нажатия.");
        continueButton.click();

        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // WebElement parentIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@data-tagging-id='G-7C99PNNT06']")));
        /*driver.switchTo().frame(parentIframe);
        WebElement childIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(childIframe);*/

    }
}