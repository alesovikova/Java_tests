package ru.stqa.pft.send_file.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class TestMyFiles extends TestBase {

    @BeforeMethod
    public void go_to_sendFile_page() {
        app.getBaseHelper().go_to_url("https://sendfiledemo.artezio.net/sendFile");
    }

    @Test
    public void test_send_file_by_link_and_check_tab_my_files() {
        String file_name = "file_5.txt";
        File file = new File("src/data/" + file_name);

        app.sendFile_page.download_file(file.getAbsolutePath());
        String url = "https://" + app.sendFile_page.get_download_link();
        app.sendFile_page.press_done_button();
        app.getBaseHelper().go_to_url("https://sendfiledemo.artezio.net/myFiles");
        app.myFile_page.validate_file_downloaded_exist_in_myFilesTable(file_name);
    }

    @Test
    public void test_send_file_by_email_and_check_tab_my_files() {
        String file_name = "file_4.txt";
        File file = new File("src/data/" + file_name);

        app.sendFile_page.download_file(file.getAbsolutePath());
        app.sendFile_page.go_to_send_by_email_tab();
        app.sendFile_page.fill_in_send_by_email_form("Anna.Lesovikova@artezio.com",
                "Autotest", "Autotest test test");
        app.sendFile_page.click_send_button();
        app.getBaseHelper().go_to_url("https://sendfiledemo.artezio.net/myFiles");
        app.myFile_page.validate_file_downloaded_exist_in_myFilesTable(file_name);
    }


}
