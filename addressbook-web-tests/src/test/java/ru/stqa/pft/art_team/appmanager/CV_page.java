package ru.stqa.pft.art_team.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.art_team.locators.Keycloak_locators;

public class CV_page {
    private WebDriver wd;

    private final BaseHelper baseHelper = new BaseHelper(wd);

    public CV_page(WebDriver wd) {
        this.wd = wd;
    }

    public String get_border_color_menu_tab(By locator) {
        String rgba = wd.findElement(locator).getCssValue("border-bottom-color");
        return rgba;
    }

    public String get_border_color_cv_tab () {
        String color = get_border_color_menu_tab(Keycloak_locators.cv_tab);
        return color;
    }

    public void check_is_block_summary_displayed(){
        Boolean a =  baseHelper.isElementPresent(By.xpath("//div[@id='summary']/span"));
    }

}
