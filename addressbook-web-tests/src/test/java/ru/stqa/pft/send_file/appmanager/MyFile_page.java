package ru.stqa.pft.send_file.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.send_file.locators.Locators;

import java.util.ArrayList;
import java.util.List;

public class MyFile_page {

    private WebDriver wd;

    private final BaseHelper baseHelper = new BaseHelper(wd);

    public MyFile_page(WebDriver wd) {
        this.wd = wd;
    }


    public void validate_file_downloaded_exist_in_myFilesTable(String fileName) {
        String file = wd.findElement(Locators.column_file_name).getText();
        Assert.assertEquals(fileName, file);
    }

}
