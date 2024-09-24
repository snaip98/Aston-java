package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Browser;

public abstract class BaseTest {
    protected WebDriver driver;
    @BeforeClass
    public void setUp() {
        driver = Browser.getDriver();
    }

    @AfterClass
    public void tearDown() {
        Browser.quitDriver();
    }
}