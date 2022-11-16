import extensions.DriverFactory;
import pages.*;
import org.junit.*;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static base.Base.*;
import static org.junit.Assert.assertEquals;

public class PersonalAccountPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setup() {
        driver = DriverFactory.getBrowser(CHROME);
        //driver = DriverFactory.getBrowser(YANDEX);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        mainPage = new MainPage(driver);
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        mainPage.waitSignInButton();
        mainPage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitSignInButton();
        loginPage.sendKeysEmail(EMAIL);
        loginPage.sendKeysPassword(PASSWORD);
        loginPage.clickSignInButton();
        mainPage.waitCreateOrderButton();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Переход в личный кабинет по клику на кнопку 'Личный кабинет'")
    public void shouldGoToProfile() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickAccountButton();
        personalAccountPage.waitPersonalAccountLink();
        assertEquals(PERSONAL_ACCOUNT_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход в конструктор по клику на кнопку 'Конструктор'")
    public void shouldGoToConstructor() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickAccountButton();
        personalAccountPage.waitPersonalAccountLink();
        mainPage.clickConstructorLink();
        assertEquals(BASE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Переход в конструктор по клику на логотип")
    public void shouldGoToHomePage() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickAccountButton();
        personalAccountPage.waitPersonalAccountLink();
        mainPage.clickLogo();
        assertEquals(BASE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Выход из аккаунта в личном кабинете")
    public void shouldExit() {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.clickAccountButton();
        personalAccountPage.waitPersonalAccountLink();
        personalAccountPage.clickExitLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitSignInButton();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
    }
}