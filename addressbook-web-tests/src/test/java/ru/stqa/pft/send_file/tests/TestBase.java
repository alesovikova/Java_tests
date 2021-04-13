package ru.stqa.pft.send_file.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import  org.testng.annotations.AfterSuite;
import  org.testng.annotations.BeforeSuite;
import ru.stqa.pft.send_file.appmanager.ApplicationManager;

public class TestBase {


    protected static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeSuite
    public static void setUp() {
        app.init();
    }

    @AfterSuite
    public static void tearDown() {
        app.stop();
    }


}
