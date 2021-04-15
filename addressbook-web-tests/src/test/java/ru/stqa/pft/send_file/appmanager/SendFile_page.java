package ru.stqa.pft.send_file.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.send_file.locators.Locators;

import java.util.ArrayList;
import java.util.List;

public class SendFile_page {

    private WebDriver wd;

    private final ru.stqa.pft.send_file.appmanager.BaseHelper baseHelper = new BaseHelper(wd);

    public SendFile_page(WebDriver wd) {
        this.wd = wd;
    }

    public String get_border_color_menu_tab(By locator) {
        String rgba = wd.findElement(locator).getCssValue("border-bottom-color");
        return rgba;
    }

    public void download_file(String filePath) {
        wd.findElement(Locators.fileInput).sendKeys(filePath);
        baseHelper.pause(5000);
    }

    public void validate_file_downloaded_exist(String fileName) {
        String file = wd.findElement(Locators.downloaded_file).getText();
        Assert.assertEquals(fileName, file);
    }

    public ArrayList<String> get_list_names_downloaded_files() {
        ArrayList<String> fileList = new ArrayList<String>();
        List<WebElement> files = wd.findElements(Locators.downloaded_file);
        for (int i = 0; i < files.size(); i++)
        {
            String file = files.get(i).getText();
            fileList.add(file);
        }
        java.util.Collections.sort(fileList);
        return fileList;
    }

    public void validate_names_downloaded_files(ArrayList<String> fileNamesList) {
        ArrayList<String> downloadedFiles = get_list_names_downloaded_files();
        for (int i = 0; i < downloadedFiles.size(); i++)
        {
            Assert.assertEquals(downloadedFiles.get(i), fileNamesList.get(i));
        }
    }


    public void validate_element_antivirus_icon_exist() {
        Assert.assertEquals(true, baseHelper.isElementPresent(wd, Locators.antivirus_icon));
    }

    public void delete_file() {
        wd.findElement(Locators.delete_file_icon).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void validate_file_deleted_not_exist(String fileName) {
        Assert.assertEquals(false, baseHelper.isElementPresent(wd, Locators.downloaded_file_name(fileName)));
    }

    public String get_download_link() {
        return wd.findElement(Locators.download_link).getAttribute("value");
    }

    public void validate_file_available_to_download(String fileName) {
        String file = wd.findElement(Locators.link_to_file_for_download).getText();
        Assert.assertEquals(fileName, file);
    }

    public ArrayList<String> get_list_names_downloaded_files_by_link() {
        ArrayList<String> fileList = new ArrayList<String>();
        List<WebElement> files = wd.findElements(Locators.link_to_file_for_download);
        for (int i = 0; i < files.size(); i++)
        {
            String file = files.get(i).getText();
            fileList.add(file);
        }
        java.util.Collections.sort(fileList);
        return fileList;
    }

    public void validate_files_available_to_download(ArrayList<String> fileNamesList) {
        ArrayList<String> downloadedFiles = get_list_names_downloaded_files_by_link();
        for (int i = 0; i < downloadedFiles.size(); i++)
        {
            Assert.assertEquals(fileNamesList.get(i), downloadedFiles.get(i));
        }
    }

    public void press_cancel_button() {
        wd.findElement(Locators.cancel_button).click();
    }

    public void validate_missing_download_link() {
        Assert.assertEquals(baseHelper.isElementPresent(wd, Locators.download_link), false);
    }

    public void press_done_button() {
        wd.findElement(Locators.done_button).click();
    }

    public void validate_link_for_download_file(String url) {
        Assert.assertEquals(url, wd.findElement(Locators.link_for_download_file).getAttribute("href"));
    }

    public void set_term_expire(String days) {
        wd.findElement(Locators.component_daysToExpired).click();
        wd.findElement(Locators.daysToExpired(days)).click();
    }

    public void validate_text_term_expire() {
        String text_term_expire = wd.findElement(Locators.text_term_expire).getText();
        Assert.assertEquals("The retention period will expire after 0 days 23 hours 59 minutes.", text_term_expire);

    }

    public void set_number_of_downloads(String number) {
        wd.findElement(Locators.component_storageTermExpiration).click();
        wd.findElement(Locators.storageTermExpiration(number)).click();
    }

    public void validate_number_of_available_downloads(int number) {
        for (int i = 0; i <= number; i++) {
            wd.findElement(Locators.link_to_file_for_download).click();
        }
        Assert.assertEquals(false, baseHelper.isElementPresent(wd, Locators.link_to_file_for_download));

    }

    public void set_password_protect() {
        wd.findElement(Locators.check_box_password).click();
    }

    public void type_password(String password) {
        wd.findElement(Locators.password_field).sendKeys(password);
    }

    public void validate_password_protect() {
        Assert.assertEquals(true, baseHelper.isElementPresent(wd, Locators.password_field_to_download));
    }

    public void enter_password_to_download(String password) {
        wd.findElement(Locators.password_field_to_download).sendKeys(password);
    }

    public void click_unblock_btn() {
        wd.findElement(Locators.unblock_btn).click();
    }


    public void validate_file_unavailable_to_download() {
        Assert.assertEquals(false, baseHelper.isElementPresent(wd, Locators.link_to_file_for_download));
    }

    public void go_to_send_by_email_tab() {
        wd.findElement(Locators.send_by_email_tab).click();
    }

    public void fill_in_send_by_email_form(String email, String subject, String message) {
        wd.findElement(Locators.field_email).clear();
        wd.findElement(Locators.field_email).sendKeys(email);
        wd.findElement(Locators.field_subject).clear();
        wd.findElement(Locators.field_subject).sendKeys(subject);
        wd.findElement(Locators.field_message).clear();
        wd.findElement(Locators.field_message).sendKeys(message);
    }

    public void fill_in_send_by_request_form(String subject, String message) {
        wd.findElement(Locators.field_subject).clear();
        wd.findElement(Locators.field_subject).sendKeys(subject);
        wd.findElement(Locators.field_message).clear();
        wd.findElement(Locators.field_message).sendKeys(message);
    }

    public void click_send_button() {
        wd.findElement(Locators.send_button).click();
    }

    public void validate_success_message_send_by_email() {
        Assert.assertEquals(true, baseHelper.isElementPresent(wd, Locators.success_message_send_by_email));
    }
}
