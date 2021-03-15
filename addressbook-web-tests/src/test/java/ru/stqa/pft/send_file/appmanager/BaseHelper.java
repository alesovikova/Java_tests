package ru.stqa.pft.send_file.appmanager;

import org.assertj.core.groups.Tuple;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BaseHelper {
    private WebDriver wd;

    public BaseHelper(WebDriver driver) {
        this.wd = driver;
    }


    public String read_json(String dataFileName, String key) {
        String dataFilePath = "src/config/";
        JSONObject testObject = null;

        try {
            FileReader reader = new FileReader(dataFilePath + dataFileName);
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            testObject = (JSONObject) jsonObject;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (String) testObject.get(key);
    }

    public void open_new_tab_and_go_to_url(String url) {
        ((JavascriptExecutor)wd).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String> (wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1)); //switches to new tab
        wd.get(url);
    }

    public void close_tab() {
        ((JavascriptExecutor)wd).executeScript("window.close()");
        ArrayList<String> tabs = new ArrayList<String> (wd.getWindowHandles());
        wd.switchTo().window(tabs.get(0)); //switches to 0 tab
    }

    public void go_to_url(String url) {
        wd.get(url);
    }


    public boolean isElementPresent(WebDriver wd, By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void switch_language_to_eng(){
        wd.findElement(By.xpath("//span[text()='EN']")).click();
    }

    public void switch_language_to_ru(){
        wd.findElement(By.xpath("//span[text()='RU']")).click();
    }

    public void pause(Integer milliseconds){
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
