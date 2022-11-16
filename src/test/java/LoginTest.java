import extensions.DriverFactory;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.time.Duration;

import static base.Base.*;
import static org.junit.Assert.assertEquals;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
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
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Авторизация на главной странице")
    public void homePageSignInButtonCheck() {
        loginPage = new LoginPage(driver);
        mainPage.clickSignInButton();
        loginPage.waitSignInButton();
        loginPage.sendKeysEmail(EMAIL);
        loginPage.sendKeysPassword(PASSWORD);
        loginPage.clickSignInButton();
        mainPage.waitCreateOrderButton();
        assertEquals(BASE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Авторизация  через кнопку 'Личный кабинет'")
    public void accountButtonSighInCheck() {
        loginPage = new LoginPage(driver);
        mainPage.clickAccountButton();
        loginPage.waitSignInButton();
        loginPage.sendKeysEmail(EMAIL);
        loginPage.sendKeysPassword(PASSWORD);
        loginPage.clickSignInButton();
        mainPage.waitCreateOrderButton();
        assertEquals(BASE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Авторизация через кнопку в форме регистрации")
    public void regPageSignInLinkCheck() {
        loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        driver.get(REGISTER_URL);
        registerPage.waitRegisterButton();
        registerPage.clickSignInButton();
        loginPage.waitSignInButton();
        loginPage.sendKeysEmail(EMAIL);
        loginPage.sendKeysPassword(PASSWORD);
        loginPage.clickSignInButton();
        mainPage.waitCreateOrderButton();
        assertEquals(BASE_URL, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Авторизация через кнопку в форме восстановления пароля")
    public void forgotPageSignInLinkCheck() {
        loginPage = new LoginPage(driver);
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        driver.get(FORGOT_PASSWORD_URL);
        passwordRecoveryPage.waitRecoveryPasswordButton();
        passwordRecoveryPage.clickSignInLink();
        loginPage.waitSignInButton();
        loginPage.sendKeysEmail(EMAIL);
        loginPage.sendKeysPassword(PASSWORD);
        loginPage.clickSignInButton();
        mainPage.waitCreateOrderButton();
        assertEquals(BASE_URL, driver.getCurrentUrl());
    }
}
