import extensions.DriverFactory;
import pages.*;
import org.junit.*;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.Duration;

import static base.Base.*;
import static org.junit.Assert.assertEquals;

public class RegisterTest {
    private WebDriver driver;
    private RegisterPage registerPage;
    private String email, password;

    @Before
    public void setup() {
        driver = DriverFactory.getBrowser(CHROME);
        //driver = DriverFactory.getBrowser(YANDEX);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        registerPage = new RegisterPage(driver);
        driver.get(REGISTER_URL);
        driver.manage().window().maximize();
        registerPage.waitRegisterButton();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @Description("Регистрация с валидными данными")
    public void shouldSuccessReg() {
        LoginPage loginPage = new LoginPage(driver);
        email = RandomStringUtils.randomAlphanumeric(10)+"@yandex.ru";
        password = RandomStringUtils.randomAlphanumeric(10);
        registerPage.sendKeysName(NAME);
        registerPage.sendKeysEmail(email);
        registerPage.sendKeysPassword(password);
        registerPage.clickRegisterButton();
        loginPage.waitSignInButton();
        assertEquals(LOGIN_URL, driver.getCurrentUrl());
    }

    @Test
    @Description("Регистрация с некорректным паролем")
    public void regShouldBeError() {
        email = RandomStringUtils.randomAlphanumeric(10)+"@yandex.ru";
        password = RandomStringUtils.randomAlphanumeric(5);
        registerPage.sendKeysName(NAME);
        registerPage.sendKeysEmail(email);
        registerPage.sendKeysPassword(password);
        registerPage.clickRegisterButton();
        registerPage.waitErrorText();
        assertEquals("Некорректный пароль", registerPage.getErrorText());
    }
}