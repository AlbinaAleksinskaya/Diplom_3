package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    WebDriver driver;

    private final By signInButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By createOrderButton = By.xpath(".//button[text()='Оформить заказ']");
    private final By goToPersonalAccountButton = By.linkText("Личный Кабинет");
    private final By activeTab = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span");
    private final By bunsTab = By.xpath(".//div/span[text()='Булки']");
    private final By saucesTab = By.xpath(".//div/span[text()='Соусы']");
    private final By fillingsTab = By.xpath(".//div/span[text()='Начинки']");
    private final By constructorLink = By.linkText("Конструктор");
    private final By logo = By.className("AppHeader_header__logo__2D0X2");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitSignInButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(signInButton));
    }
    public void waitCreateOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
    }

    public void clickConstructorLink() {
        WebElement element = driver.findElement(constructorLink);
        element.click();
    }

    public void clickLogo() {
        WebElement element = driver.findElement(logo);
        element.click();
    }

    public void clickSignInButton() {
        WebElement element = driver.findElement(signInButton);
        element.click();
    }

    public void clickAccountButton() {
        WebElement element = driver.findElement(goToPersonalAccountButton);
        element.click();
    }

    public String getTextActiveTab() {
        WebElement element = driver.findElement(activeTab);
        return element.getText();
    }

    public void clickBuns() {
        WebElement element = driver.findElement(bunsTab);
    }

    public void clickSauces() {
        WebElement element = driver.findElement(saucesTab);
        element.click();
    }

    public void clickFillings() {
        WebElement element = driver.findElement(fillingsTab);
        element.click();
    }
}