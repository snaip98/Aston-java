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
    private static final By cookieButton = By.xpath("//button[@class = 'btn btn_black cookie__ok']");
    private By blokNameXPath = By.xpath("//div[@class = 'pay__wrapper']/h2");
    private By visaLogo = By.xpath("//img[@alt='Visa']");
    private By verifiedByVisaLogo = By.xpath("//img[@alt='Verified By Visa']");
    private By masterCardSecureCodeLogo = By.xpath("//img[@alt='MasterCard Secure Code']");
    private By belkart = By.xpath("//img[@alt='Белкарт']");
    private By phoneNumberXPath = By.xpath("//input[@placeholder = 'Номер телефона']");
    private By valueXPath = By.xpath("//input[@placeholder = 'Сумма']");
    private By emailXPath = By.xpath("//input[@placeholder = 'E-mail для отправки чека']");
    private By buttonContinueXPath = By.xpath("//button[@Class = 'button button__default ']");
    private String inputPhoneNumber = "297777777";
    private String inputCountOfMoney = "1";
    private String inputEmail = "aksnovich.ivan@gmail.com";
    private By xPathesOfLink = By.xpath("//a[@href = '/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/' ]");

    @BeforeAll
    public static void openWebSite() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        checkCookie();
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

    @Test
    @Order(1)
    @DisplayName("Проверка названия блока 'Онлайн пополнение без комиссии'")
    public void blockNameValidationTest() {
        waitForElementToBeVisible(blokNameXPath, 2);
        WebElement blockName = findElement(blokNameXPath);
        Assertions.assertEquals("Онлайн пополнение\n" +
                "без комиссии", blockName.getText());
    }

    @Test
    @Order(2)
    @DisplayName("Проверка наличия логотипов платёжных систем")
    public void paymentSystemsLogoPresenceTest() {

        By[] logos = new By[]{
                visaLogo,
                verifiedByVisaLogo,
                masterCardSecureCodeLogo,
                belkart
        };
        for (By xpathOfLogo : logos) {
            try {
                waitForElementToBeVisible(xpathOfLogo, 2);
                Assertions.assertTrue(findElement((xpathOfLogo)).isDisplayed(), "Логотип не отображается" + " " + xpathOfLogo);
            } catch (TimeoutException e) {
                Assertions.fail("Логотип не найден в течение ожидания: " + " " + xpathOfLogo);
            }
        }
    }

    @Test
    @Order(3)
    @DisplayName("Проверка ссылки на страницу оплаты и безопасности")
    public void serviceLinkTest() {
        waitForElementToBeVisible(xPathesOfLink, 2);
        findElement(xPathesOfLink).click();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
    }

    @Test
    @Order(4)
    @DisplayName("Заполнение полей формы и проверка кнопки 'Продолжить'")
    public void fillFieldsAndVerifyContinueButtonTest() {
        fillInputPlace(phoneNumberXPath, inputPhoneNumber);
        fillInputPlace(valueXPath, inputCountOfMoney);
        fillInputPlace(emailXPath, inputEmail);
        checkCookie();
        Assertions.assertTrue(findElement(buttonContinueXPath).isEnabled(), "Кнопка 'Продолжить' должна быть доступна для нажатия.");
        findElement(buttonContinueXPath).click();
    }

    private static void checkCookie() {
        try {
            waitForElementToBeVisible(cookieButton, 2);
            findElement(cookieButton).click();
        } catch (TimeoutException e) {
            System.out.println("Cookie не отображаются");
        }
    }

    private static void waitForElementToBeVisible(By xpath, int timeOut) {
        new WebDriverWait(driver, Duration.ofSeconds(timeOut))
                .until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

    private void fillInputPlace(By data, String value) {
        driver.findElement(data).sendKeys(value);
    }

    public static WebElement findElement(By xpath) {
        return driver.findElement(xpath);
    }
}