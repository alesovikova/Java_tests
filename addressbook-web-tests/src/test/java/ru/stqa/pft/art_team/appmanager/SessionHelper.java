package ru.stqa.pft.art_team.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.pft.art_team.locators.Keycloak_locators;

public class SessionHelper {
    private WebDriver wd;

    public SessionHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void login(String username, String password) {
        type(Keycloak_locators.username, username);
        type(Keycloak_locators.password, password);
        click(Keycloak_locators.login_btn);
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
        String message = wd.findElement(Keycloak_locators.login_invalid_message).getText();
        Assert.assertEquals(message, "Invalid username or password.");

    }

    public void validate_exit_button() {
        wait_for_element_to_be_visible(Keycloak_locators.exit_btn, 10);
    }

    public void wait_for_element_to_be_visible (By locator, int timeout) {
        WebElement dynamicElement = (new WebDriverWait(wd, timeout))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
    }



}

