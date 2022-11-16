package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {

    WebDriver driver;

    private final By personalAccountLink = By.linkText("Профиль");
    private final By exitButton = By.xpath(".//button[text()='Выход']");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitPersonalAccountLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(personalAccountLink));
    }

    public void clickExitLink() {
        WebElement element = driver.findElement(exitButton);
        element.click();
    }
}