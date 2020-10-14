package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.junit.After;
import org.junit.Before;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @Before
    public void setUp() {
        app.init();
    }

    @After
    public void tearDown() {
        app.stop();
    }

}
