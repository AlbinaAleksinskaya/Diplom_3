package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.Duration;

public class RegisterPage {
    WebDriver driver;

    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By nameInput = By.xpath(".//fieldset[1]//input");
    private final By emailInput = By.xpath(".//fieldset[2]//input");
    private final By passwordInput = By.xpath(".//fieldset[3]//input");
    private final By passwordErrorText = By.xpath(".//p[text()='Некорректный пароль']");
    private final By signInButton = By.linkText("Войти");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitRegisterButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(registerButton));
    }

    public void sendKeysName(String name) {
        WebElement element = driver.findElement(nameInput);
        element.sendKeys(name);
    }

    public void sendKeysEmail(String email) {
        WebElement element = driver.findElement(emailInput);
        element.sendKeys(email);
    }

    public void sendKeysPassword(String password) {
        WebElement element = driver.findElement(passwordInput);
        element.sendKeys(password);
    }

    public void clickRegisterButton() {
        WebElement element = driver.findElement(registerButton);
        element.click();
    }

    public void waitErrorText() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(passwordErrorText));
    }

    public String getErrorText() {
        WebElement element = driver.findElement(passwordErrorText);
        return element.getText();
    }

    public void clickSignInButton() {
        WebElement element = driver.findElement(signInButton);
        element.click();
    }
}