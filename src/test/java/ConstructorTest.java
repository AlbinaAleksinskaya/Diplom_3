import extensions.DriverFactory;
import pages.MainPage;
import org.junit.*;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static base.Base.*;
import static org.junit.Assert.assertEquals;

public class ConstructorTest {
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
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    @DisplayName("Переход в раздел 'Булки'")
    public void shouldSwitchToBunsTab() {
        mainPage.clickBuns();
        assertEquals("Булки", mainPage.getTextActiveTab());
    }

    @Test
    @DisplayName("Переход в раздел 'Соусы'")
    public void shouldSwitchToSaucesTab() {
        mainPage.clickSauces();
        assertEquals("Соусы", mainPage.getTextActiveTab());
    }

    @Test
    @DisplayName("Переход в раздел 'Начинки'")
    public void shouldSwitchToFillingsTab() {
        mainPage.clickFillings();
        assertEquals("Начинки", mainPage.getTextActiveTab());
    }
}