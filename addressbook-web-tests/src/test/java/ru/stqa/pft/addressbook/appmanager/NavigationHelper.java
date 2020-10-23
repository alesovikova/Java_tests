package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{
    private WebDriver wd;

    public NavigationHelper(WebDriver wd) {

        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("GROUPS"));
    }

    public void gotoHomePage() {
        click(By.linkText("HOME"));
    }

    public void initNewContact() {
        click(By.linkText("ADD_NEW"));
    }
}
