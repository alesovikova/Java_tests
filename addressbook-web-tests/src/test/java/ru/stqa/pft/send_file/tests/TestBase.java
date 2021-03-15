package ru.stqa.pft.send_file.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;
import ru.stqa.pft.send_file.appmanager.ApplicationManager;

public class TestBase {


    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeClass
    public static void setUp() {
        app.init();
    }

    @AfterClass
    public static void tearDown() {
        app.stop();
    }


}
