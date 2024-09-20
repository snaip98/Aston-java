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
            waitForElementToBeVisible("//button[@class =  'btn btn_black cookie__ok']", 2);
            driver.findElement(By.xpath("//button[@class =  'btn btn_black cookie__ok']")).click();
        } catch (TimeoutException e) {
            System.out.println("Cookie не отображаются");
        }
    }

    @BeforeEach
    public void restartWebSite() {
        driver.navigate().to("https://www.mts.by/");
        checkCookie();
    }

    @AfterAll
    public static void closeWebSite() {
        driver.quit();
    }

    private static void waitForElementToBeVisible(String xpath, int timeOut) {
        new WebDriverWait(driver, Duration.ofSeconds(timeOut))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    @Test
    @Order(1)
    @DisplayName("Проверка названия блока 'Онлайн пополнение без комиссии'")
    public void blockNameValidationTest() {
        String blokNameXPath = "//div[@class = 'pay__wrapper']/h2";
        waitForElementToBeVisible(blokNameXPath, 2);
        WebElement blockName = driver.findElement(By.xpath(blokNameXPath));
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
                waitForElementToBeVisible(xpathOfLogo, 2);
                Assertions.assertTrue(driver.findElement(By.xpath(xpathOfLogo)).isDisplayed(), "Логотип не отображается" + " " + xpathOfLogo);
            } catch (TimeoutException e) {
                Assertions.fail("Логотип не найден в течение ожидания: " + xpathOfLogo);
            }
        }
    }

    @Test
    @Order(3)
    @DisplayName("Проверка ссылки на страницу оплаты и безопасности")
    public void serviceLinkTest() {
        String xPathesOfLink = "//a[@href = '/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/' ]";
        waitForElementToBeVisible(xPathesOfLink, 2);
        driver.findElement(By.xpath(xPathesOfLink)).click();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    @Order(4)
    @DisplayName("Заполнение полей формы и проверка кнопки 'Продолжить'")
    public void fillFieldsAndVerifyContinueButtonTest() {
        String phoneNumberXPath = "//input[@placeholder = 'Номер телефона']";
        String valueXPath = "//input[@placeholder = 'Сумма']";
        String emailXPath = "//input[@placeholder = 'E-mail для отправки чека']";
        String buttonContinueXPath = "//button[@Class = 'button button__default ']";
        String inputPhoneNumber = "297777777";
        String inputCountOfMoney = "1";
        String inputEmail = "aksnovich.ivan@gmail.com";
        waitForElementToBeVisible(phoneNumberXPath, 2);
        String[] xPathes = new String[]{
                phoneNumberXPath,
                valueXPath,
                emailXPath,
                buttonContinueXPath
        };
        String[] inputData = new String[]{
                inputPhoneNumber,
                inputCountOfMoney,
                inputEmail
        };
        WebElement[] inputFields = new WebElement[xPathes.length];

        for (int i = 0; i < inputData.length; i++) {
            waitForElementToBeVisible(xPathes[i], 2);
            inputFields[i] = driver.findElement(By.xpath(xPathes[i]));
            inputFields[i].sendKeys(inputData[i]);
        }
        checkCookie();
        WebElement continueButton = driver.findElement(By.xpath(buttonContinueXPath));
        Assertions.assertTrue(continueButton.isEnabled(), "Кнопка 'Продолжить' должна быть доступна для нажатия.");
        continueButton.click();
    }
}