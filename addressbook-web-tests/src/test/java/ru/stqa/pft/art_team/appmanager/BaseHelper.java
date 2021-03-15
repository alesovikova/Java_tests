package ru.stqa.pft.art_team.appmanager;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;

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

    public void go_to_url(String url) {
        wd.navigate().to(url);

    }


    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void switch_language_to_eng(){
        wd.findElement(By.xpath("//span[text()='ENG']")).click();
    }

    public void switch_language_to_ru(){
        wd.findElement(By.xpath("//span[text()='РУС']")).click();
    }
}
