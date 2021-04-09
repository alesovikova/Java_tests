package ru.stqa.pft.send_file.appmanager;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.send_file.locators.Locators;


public class RequestFile_page {

    private WebDriver wd;

    private final BaseHelper baseHelper = new BaseHelper(wd);

    public RequestFile_page(WebDriver wd) {
        this.wd = wd;
    }


    public void click_request_link_btn() {
        wd.findElement(Locators.request_link_btn).click();
    }

    public String get_request_link() {
        return wd.findElement(Locators.request_link).getText();
    }

    public void validate_ability_upload_file() {
        Assert.assertEquals(true, baseHelper.isElementPresent(wd, Locators.fileInput));
    }

    public void click_request_more_button() {
        wd.findElement(Locators.request_more_btn).click();
    }

    public void validate_exist_request_link_button() {
        Assert.assertEquals(true, baseHelper.isElementPresent(wd, Locators.request_link_btn));
    }
}
