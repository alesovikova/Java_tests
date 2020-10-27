package ru.stqa.pft.addressbook.tests;

import org.junit.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test 1", "test1", "test1"));
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("test 1", "test 2", "test1"), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();
    }
}
