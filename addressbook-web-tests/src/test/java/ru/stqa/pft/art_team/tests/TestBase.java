package ru.stqa.pft.art_team.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.art_team.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @Before
    public void setUp() {
        app.init();
    }

    @After
    public void tearDown() {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }




}
