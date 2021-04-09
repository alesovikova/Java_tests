package ru.stqa.pft.send_file.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class TestRequestFiles extends TestBase {

    @BeforeMethod
    public void go_to_sendFile_page() {
        app.getBaseHelper().go_to_url("https://sendfiledemo.artezio.net/requestFile");
    }

    @Test
    public void test_create_request_link_and_validate_link() {
        app.requestFile_page.click_request_link_btn();
        String request_link = app.requestFile_page.get_request_link();
        app.getBaseHelper().open_new_tab_and_go_to_url(request_link);
        app.requestFile_page.validate_ability_upload_file();
        app.getBaseHelper().close_tab();
    }

    @Test
    public void test_create_request_link_and_request_more() {
        app.requestFile_page.click_request_link_btn();
        String request_link = app.requestFile_page.get_request_link();
        app.getBaseHelper().open_new_tab_and_go_to_url(request_link);
        app.requestFile_page.click_request_more_button();
        app.requestFile_page.validate_exist_request_link_button();
        app.getBaseHelper().close_tab();
    }

    @Test
    public void test_create_request_link_and_sand_file_by_request() {
        String file_name = "file_1.txt";
        File file = new File("src/data/" + file_name);

        app.requestFile_page.click_request_link_btn();
        String request_link = app.requestFile_page.get_request_link();
        app.getBaseHelper().open_new_tab_and_go_to_url(request_link);
        app.sendFile_page.download_file(file.getAbsolutePath());
        app.sendFile_page.validate_file_downloaded_exist(file_name);
        app.sendFile_page.fill_in_send_by_email_form("Anna.Lesovikova@artezio.com",
                "Autotest", "Autotest test test");
        app.sendFile_page.click_send_button();
        app.sendFile_page.validate_success_message_send_by_email();
        app.getBaseHelper().close_tab();
    }
}
