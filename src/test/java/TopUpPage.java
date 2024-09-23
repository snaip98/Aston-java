import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TopUpPage {
    private final By blokNameXPath = By.xpath("//div[@class = 'pay__wrapper']/h2");
    private final By cookieButton = By.xpath("//button[@class = 'btn btn_black cookie__ok']");
    private final By visaLogo = By.xpath("//img[@alt='Visa']");
    private final By verifiedByVisaLogo = By.xpath("//img[@alt='Verified By Visa']");
    private final By masterCardSecureCodeLogo = By.xpath("//img[@alt='MasterCard Secure Code']");
    private final By belkart = By.xpath("//img[@alt='Белкарт']");
    private final By xPathesOfLink = By.xpath("//a[@href = '/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/' ]");
    private final String expectedLink = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
    private final String expectedName = "Онлайн пополнение\nбез комиссии";
    private final By phoneNumberXPath = By.xpath("//input[@placeholder = 'Номер телефона']");
    private final By valueXPath = By.xpath("//input[@placeholder = 'Сумма']");
    private final By emailXPath = By.xpath("//input[@placeholder = 'E-mail для отправки чека']");
    private final By buttonContinueXPath = By.xpath("//button[@Class = 'button button__default ']");
    private final String phoneNumber = "297777777";
    private final String countOfMoney = "1";
    private final String email = "aksnovich.ivan@gmail.com";
    private WebDriver driver;
    private WebDriverWait wait;
    private static String webSiteUrl = "https://www.mts.by/";
    private final By dropDownButton = By.xpath("//button[@class = 'select__header']");
    private final By placeHolderPhone = By.xpath("//input[@placeholder='Номер телефона']");
    private final By placeHolderSum = By.xpath("//input[@class = 'total_rub']");
    private final By placeHolderEmail = By.xpath("//input[@class = 'email']");
    private final String placeholder = "placeholder";
    private final String attributeOfPhone = "Номер телефона";
    private final String attributeOfSum = "Сумма";
    private final String attributeOfEmail = "E-mail для отправки чека";
    private final String attributeOfAccountNumber = "Номер счета на 44";
    private final String attributeOfPhoneSubscriber = "Номер абонента";
    private final String attributeOfAccountNumberDebtDue = "Номер счета на 2073";

    private final By buttonHomeInternet = By.xpath("//p[text() = 'Домашний интернет']");
    private final By buttonInstallment = By.xpath("//p[text() = 'Рассрочка']");
    private final By buttonDebtDue = By.xpath("//p[text() = 'Задолженность']");
    private final By placeHolderPhoneOfHomeEnternet = By.xpath("//input[@id= 'internet-phone']");
    private final By placeHolderSumOfHomeEnternet = By.xpath("//input[@id =  'internet-sum']");
    private final By placeHolderEmailOfHomeEnternet = By.xpath("//input[@id =  'internet-email']");
    private final By placeHolderAccountNumberOfInstallment = By.xpath("//input[@id= 'score-instalment']");
    private final By placeHolderSumOfInstallment = By.xpath("//input[@id= 'instalment-sum']");
    private final By placeHolderEmailOfInstallment = By.xpath("//input[@id= 'instalment-email']");
    private final By placeHolderAccountNumberOfDebtDue = By.xpath("//input[@id= 'score-arrears']");
    private final By placeHolderSumOfDebtDue = By.xpath("//input[@id= 'arrears-sum']");
    private final By placeHolderEmailOfDebtDue = By.xpath("//input[@id= 'arrears-email']");
    private final By cardNumber = By.xpath("//label[@class='ng-tns-c46-1 ng-star-inserted']");
    private final String cardNumberExpectedText = "Номер карты";
    private final By expiryDate = By.xpath("//label[@class = 'ng-tns-c46-4 ng-star-inserted']");
    private final String expiryDateExpectedText = "Срок действия";
    private final By cvcCode = By.xpath("//label[@class = 'ng-tns-c46-5 ng-star-inserted']");
    private final String cvcCodeExpectedText = "CVC";
    private final By cardholderName = By.xpath("//label[@class = 'ng-tns-c46-3 ng-star-inserted']");
    private final String cardholderNameExpectedText = "Имя держателя (как на карте)";
    private final By buttonPay = By.xpath("//button[@class = 'colored disabled']");
    private final String buttonPayExpectedText = "Оплатить 1.00 BYN";
    private final By phoneNumberBePay = By.xpath("//div[@class = 'pay-description__text']//span");
    private final String phoneNumberBePayTextPhone = "Оплата: Услуги связи Номер:375297777777";
    private final By sumBePay = By.xpath("//div[@class = 'pay-description__cost']//span");
    private final String sumBePayTextPhone = "1.00 BYN";
    private final By logoBePayVisa = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]");
    private final By logoBePayMC = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[1]");
    private final By logoBePayBelkart = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[1]");
    private final By logoBePayMir = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[1]");

    public TopUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void fillData() {
        waitElement(phoneNumberXPath);
        fillInput(phoneNumberXPath, phoneNumber);
        fillInput(valueXPath, countOfMoney);
        fillInput(emailXPath, email);
        clickContinueButton();
        checkCookie();
        waitElement(By.xpath("//iframe[@class='bepaid-iframe']"));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        checkText(phoneNumberBePay, phoneNumberBePayTextPhone);
        checkText(expiryDate, expiryDateExpectedText);
        checkText(cvcCode, cvcCodeExpectedText);
        checkText(cardholderName, cardholderNameExpectedText);
        checkText(buttonPay, buttonPayExpectedText);
        checkText(cardNumber, cardNumberExpectedText);
        checkText(sumBePay, sumBePayTextPhone);

        iteratorLogo(new By[]{logoBePayVisa, logoBePayMC, logoBePayBelkart, logoBePayMir});

    }

    private void checkText(By locator, String expText) {
        waitElement(locator);
        Assert.assertEquals(findElement(locator).getText(), expText);
    }

    private void fillInput(By data, String value) {
        findElement(data).sendKeys(value);
    }

    public void clickContinueButton() {
        findElement(buttonContinueXPath).click();
    }

    public void checkLogo() {
        iteratorLogo(new By[]{visaLogo, verifiedByVisaLogo, masterCardSecureCodeLogo, belkart});
    }

    private void iteratorLogo(By[] logos) {
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

    private void waitElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void getTextOfNameBlok() {
        checkText(blokNameXPath, expectedName);
    }

    public void open() {
        driver.get(webSiteUrl);
        checkCookie();
    }

    public void checkLink() {
        waitElement(xPathesOfLink);
        findElement(xPathesOfLink).click();
        Assert.assertEquals(expectedLink, driver.getCurrentUrl());
    }

    public void checkLabelsForInputs() {
        waitElement(placeHolderPhone);
        checkPlaceHolder(placeHolderPhone, attributeOfPhone);
        checkPlaceHolder(placeHolderSum, attributeOfSum);
        checkPlaceHolder(placeHolderEmail, attributeOfEmail);

        selectOptionFromDropdown(buttonHomeInternet);
        checkPlaceHolder(placeHolderPhoneOfHomeEnternet, attributeOfPhoneSubscriber);
        checkPlaceHolder(placeHolderSumOfHomeEnternet, attributeOfSum);
        checkPlaceHolder(placeHolderEmailOfHomeEnternet, attributeOfEmail);

        selectOptionFromDropdown(buttonInstallment);
        checkPlaceHolder(placeHolderAccountNumberOfInstallment, attributeOfAccountNumber);
        checkPlaceHolder(placeHolderSumOfInstallment, attributeOfSum);
        checkPlaceHolder(placeHolderEmailOfInstallment, attributeOfEmail);

        selectOptionFromDropdown(buttonDebtDue);
        checkPlaceHolder(placeHolderAccountNumberOfDebtDue, attributeOfAccountNumberDebtDue);
        checkPlaceHolder(placeHolderSumOfDebtDue, attributeOfSum);
        checkPlaceHolder(placeHolderEmailOfDebtDue, attributeOfEmail);
    }

    private void checkPlaceHolder(By locator, String expectedPlaceHolder) {
        String actualPlaceholder = findElement(locator).getAttribute(placeholder);
        Assert.assertEquals(actualPlaceholder, expectedPlaceHolder, "Ожидалось значение placeholder: " + expectedPlaceHolder + ", но было: " + actualPlaceholder);
    }

    public void selectOptionFromDropdown(By locator) {
        findElement(dropDownButton).click();
        findElement(locator);
    }

    public WebElement findElement(By xpath) {
        return driver.findElement(xpath);
    }
}