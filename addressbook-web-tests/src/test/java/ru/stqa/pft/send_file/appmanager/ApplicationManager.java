package ru.stqa.pft.send_file.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private SessionHelper sessionHelper;
    private BaseHelper baseHelper;
    public SendFile_page sendFile_page;
    public RequestFile_page requestFile_page;
    public MyFile_page myFile_page;

    private String browser;
    String users = "send_file";

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void init() {
        ChromeOptions chromeOptions= new ChromeOptions();
        chromeOptions.setBinary("/var/lib/jenkins/workspace/Autotests-DEMO/addressbook-web-tests/src/test/drivers/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/workspace/Autotests-DEMO/addressbook-web-tests/src/test/drivers/chromedriver.exe");
        if (browser == BrowserType.CHROME) {
            wd = new ChromeDriver(chromeOptions);
        } else if (browser == BrowserType.FIREFOX) {
            wd = new FirefoxDriver();
        } else if (browser == BrowserType.IEXPLORE) {
            wd = new InternetExplorerDriver();
        }


        wd.get("https://sendfiledemo.artezio.net/");
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.manage().window().setSize(new Dimension(1710, 1000));
        sessionHelper = new SessionHelper(wd);
        baseHelper = new BaseHelper(wd);
        sendFile_page = new SendFile_page(wd);
        requestFile_page = new RequestFile_page(wd);
        myFile_page = new MyFile_page(wd);

        login_as_user();

    }

    public void login_as_user() {
        getSessionHelper().login(getBaseHelper().read_json(users, "username"),
                getBaseHelper().read_json(users, "password"));
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

    public SendFile_page cv_page() {
        return sendFile_page;
    }

    public void wait_for_page_load(int seconds) {
        new WebDriverWait(wd, seconds).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }





}
