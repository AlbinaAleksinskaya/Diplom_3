package extensions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver getBrowser(String browserName) {
        switch (browserName) {
            case "yandex": {
                //путь до драйвера
                System.setProperty("webdriver.chrome.driver", "src/main/java/resources/yandexdriver");
                ChromeOptions options = new ChromeOptions();
                //путь до Yandex bin
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                return new ChromeDriver(options);
            }
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            default: throw new RuntimeException("Только Хром и Яндекс!");
        }
    }
}
