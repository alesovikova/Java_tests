package ru.stqa.pft.send_file.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.pft.send_file.locators.Locators;

public class SessionHelper {
    private WebDriver wd;
    private final ru.stqa.pft.send_file.appmanager.BaseHelper baseHelper = new BaseHelper(wd);

    public SessionHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void login(String username, String password) {
        wd.findElement(Locators.username).clear();
        type(Locators.username, username);
        wd.findElement(Locators.password).clear();
        type(Locators.password, password);
        click(Locators.login_btn);
        baseHelper.pause(5000);
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void validate_login_invalid_message() {
        String message = wd.findElement(Locators.login_invalid_message).getText();
        Assert.assertEquals(message, "Incorrect e-mail or password");

    }

    public void validate_user_name() {
        wait_for_element_to_be_visible(Locators.user_name, 10);
    }

    public void wait_for_element_to_be_visible (By locator, int timeout) {
        WebElement dynamicElement = (new WebDriverWait(wd, timeout))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }



}

