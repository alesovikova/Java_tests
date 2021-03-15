package ru.stqa.pft.art_team.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private SessionHelper sessionHelper;
    private BaseHelper baseHelper;
    private CV_page cv_page;

    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void init() {
        if (browser == BrowserType.CHROME) {
            wd = new ChromeDriver();
        } else if (browser == BrowserType.FIREFOX) {
            wd = new FirefoxDriver();
        } else if (browser == BrowserType.IEXPLORE) {
            wd = new InternetExplorerDriver();
        }


        wd.get("https://artteam-pe-team-qa.oo-aps.artezio.net/");
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().setSize(new Dimension(1710, 1000));
        sessionHelper = new SessionHelper(wd);
        baseHelper = new BaseHelper(wd);
        cv_page = new CV_page(wd);

    }

    public void stop() {
        wd.quit();
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public BaseHelper getBaseHelper() {
        return baseHelper;
    }

    public CV_page cv_page() {
        return cv_page;
    }

    public void wait_for_page_load(int seconds) {
        new WebDriverWait(wd, seconds).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }





}
