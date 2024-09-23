import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopUpWithoutCommissionTests {
    private static WebDriver driver;
    private static TopUpPage topUpPage;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        topUpPage = new TopUpPage(driver);
    }

    @BeforeMethod
    public void openPage() {
        topUpPage.open();
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1, description = "Проверка названия блока 'Онлайн пополнение без комиссии'")
    public void blockNameValidationTest() {
        topUpPage.getTextOfNameBlok();
    }

    @Test(priority = 2, description = "Проверка наличия логотипов платёжных систем")
    public void paymentSystemsLogoPresenceTest() {
        topUpPage.checkLogo();
    }

    @Test(priority = 3, description = "Проверка ссылки на страницу оплаты и безопасности")
    public void serviceLinkTest() {
        topUpPage.checkLink();
    }

    @Test(priority = 4, description = "Заполнение полей формы и проверка кнопки 'Продолжить'")
    public void fillFieldsAndVerifyContinueButtonTest(){
        topUpPage.fillData();

    }

    @Test(priority = 5, description = "проверка надписей в назаполненных полях каждого варианта оплаты услуг")
    public void validateFieldLabelsForEmptyInputsInAllPaymentMethods() {
       topUpPage.checkLabelsForInputs()  ;
    }
}