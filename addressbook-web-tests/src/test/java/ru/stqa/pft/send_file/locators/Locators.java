package ru.stqa.pft.send_file.locators;

import org.openqa.selenium.By;

public class Locators {

    //authorization
    public static By username = (By.name("username"));
    public static By password = (By.name("password"));
    public static By login_btn = (By.xpath("//button/span[text()='Log In']"));
    public static By login_invalid_message = (By.xpath("//div[@id='kc-content-wrapper']/div/span[@class='kc-feedback-text']"));


    public static By user_name = (By.xpath("//div[@id='root']//span[text()='Ivanov Alexander']"));


    //Send file page
    public static By fileInput = (By.xpath("//input[@type='file']"));
    public static By downloaded_file = (By.xpath("//div[contains(@class, 'MuiListItemText-root')]/span"));
    public static By antivirus_icon = (By.xpath("//div[@class='MuiListItemSecondaryAction-root']/*[name()='svg'][1]"));
    public static By delete_file_icon = (By.xpath("//div[@class='MuiListItemSecondaryAction-root']/*[name()='svg'][2]"));
    public static By download_link = (By.xpath("//div/input[@id='link']"));
    public static By cancel_button = (By.xpath("//form[@name='fileLink']//div[contains(@class, 'MuiGrid-root ')][1]/button"));
    public static By done_button = (By.xpath("//form[@name='fileLink']//div[contains(@class, 'MuiGrid-root ')][2]/button"));
    public static By term_expiration = (By.xpath("//form[@name = 'fileSettings']//div/input[@name='storageTermExpiration']"));

    public static By downloaded_file_name (String name) {
        return (By.xpath("//div/span[text()=" +"'" + name + "']"));
    }

    public static By component_daysToExpired = (By.xpath("//div[@id='mui-component-select-daysToExpired']"));
    public static By component_storageTermExpiration = (By.xpath("//div[@id='mui-component-select-storageTermExpiration']"));

    public static By daysToExpired (String days) {
        return (By.xpath("//ul/li[@data-value=" +"'" + days + "']"));
    }
    public static By storageTermExpiration (String days) {
        return (By.xpath("//ul/li[@data-value=" +"'" + days + "']"));
    }
    public static By check_box_password = (By.xpath("//input[@name='passwordEnabled']"));
    public static By password_field = (By.xpath("//input[@id='password']"));



    //Page for download files
    public static By link_to_file_for_download = (By.xpath("//div[contains(@class, 'MuiListItemText-root')]/span"));
    public static By text_term_expire = (By.xpath("//section/div/div[3]"));
    public static By password_field_to_download = (By.xpath("//input[@name='password']"));
    public static By unblock_btn = (By.xpath("//button[@type='submit']/span[@class='MuiButton-label']"));

    //Page for download files with link
    public static By link_for_download_file = (By.xpath("//section//a"));
}