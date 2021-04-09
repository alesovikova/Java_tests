package ru.stqa.pft.send_file.tests;

import org.junit.Before;
//import org.junit.Test;
import java.io.File;
import java.util.ArrayList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFiles extends TestBase {


    @BeforeMethod
    public void go_to_sendFile_page() {
        app.getBaseHelper().go_to_url("https://sendfiledemo.artezio.net/sendFile");
    }

    @Test
    public void test_download_file_and_validate(){
        String file_name = "file_1.txt";
        File file = new File("src/data/" + file_name);

        app.sendFile_page.download_file(file.getAbsolutePath());
        app.sendFile_page.validate_file_downloaded_exist(file_name);
        app.sendFile_page.validate_element_antivirus_icon_exist();
    }

    @Test
    public void test_download_file_and_delete(){
        String file_name = "file_1.txt";
        File file = new File("src/data/" + file_name);

        app.sendFile_page.download_file(file.getAbsolutePath());
        app.sendFile_page.validate_file_downloaded_exist(file_name);
        app.sendFile_page.delete_file();
        app.sendFile_page.validate_file_deleted_not_exist(file_name);
    }

    @Test
    public void test_add_file_and_validate(){
        String file_name_1 = "file_1.txt";
        String file_name_2 = "file_2.txt";
        File file_1 = new File("src/data/" + file_name_1);
        File file_2 = new File("src/data/" + file_name_2);
        ArrayList<String> FileNames = new ArrayList<>();
        FileNames.add("file_1.txt");
        FileNames.add("file_2.txt");

        app.sendFile_page.download_file(file_1.getAbsolutePath());
        app.sendFile_page.download_file(file_2.getAbsolutePath());
        app.sendFile_page.validate_names_downloaded_files(FileNames);
    }

    @Test
    public void test_multiple_file_download_and_validate() {
        ArrayList<String> FileNames = new ArrayList<>();
        ArrayList<File> FilePath = new ArrayList<>();
        FileNames.add("file_1.txt");
        FileNames.add("file_2.txt");
        FileNames.add("file_3.docx");
        FileNames.add("file_4.xlsx");
        FileNames.add("file_5.jpeg");

        for (int i = 0; i < FileNames.size(); i++) {
            File file = new File("src/data/" + FileNames.get(i));
            FilePath.add(file);
        }
        app.sendFile_page.download_file(FilePath.get(0).getAbsolutePath() + "\n" +
            FilePath.get(1).getAbsolutePath() + "\n" +
            FilePath.get(2).getAbsolutePath() + "\n" +
            FilePath.get(3).getAbsolutePath() + "\n" +
            FilePath.get(4).getAbsolutePath() );
        app.sendFile_page.validate_names_downloaded_files(FileNames);
    }

    @Test
    public void test_download_file_and_validate_file_available_to_download_by_link(){
        String file_name = "file_1.txt";
        File file = new File("src/data/" + file_name);

        app.sendFile_page.download_file(file.getAbsolutePath());
        String url = "https://" + app.sendFile_page.get_download_link();
        app.getBaseHelper().open_new_tab_and_go_to_url(url);
        app.sendFile_page.validate_file_available_to_download(file_name);
        app.getBaseHelper().close_tab();
    }

    @Test
    public void test_multiple_download_files_and_validate_file_available_to_download_by_link(){
        ArrayList<String> FileNames = new ArrayList<>();
        ArrayList<File> FilePath = new ArrayList<>();
        FileNames.add("file_1.txt");
        FileNames.add("file_2.txt");
        FileNames.add("file_3.docx");
        FileNames.add("file_4.xlsx");
        FileNames.add("file_5.jpeg");

        for (int i = 0; i < FileNames.size(); i++) {
            File file = new File("src/data/" + FileNames.get(i));
            FilePath.add(file);
        }
        app.sendFile_page.download_file(FilePath.get(0).getAbsolutePath() + "\n" +
                FilePath.get(1).getAbsolutePath() + "\n" +
                FilePath.get(2).getAbsolutePath() + "\n" +
                FilePath.get(3).getAbsolutePath() + "\n" +
                FilePath.get(4).getAbsolutePath() );

        String url = "https://" + app.sendFile_page.get_download_link();
        app.getBaseHelper().open_new_tab_and_go_to_url(url);
        app.sendFile_page.validate_files_available_to_download(FileNames);
        app.getBaseHelper().close_tab();
    }

    @Test
    public void test_download_file_and_press_cancel_button(){
        String file_name = "file_1.txt";
        File file = new File("src/data/" + file_name);

        app.sendFile_page.download_file(file.getAbsolutePath());
        app.sendFile_page.press_cancel_button();
        app.sendFile_page.validate_missing_download_link();
    }

    @Test
    public void test_download_file_and_press_done_button_and_validate_link(){
        String file_name = "file_1.txt";
        File file = new File("src/data/" + file_name);

        app.sendFile_page.download_file(file.getAbsolutePath());
        String url = "https://" + app.sendFile_page.get_download_link();
        app.sendFile_page.press_done_button();
        app.sendFile_page.validate_link_for_download_file(url);
    }

    @Test
    public void test_download_file_with_term_expire_and_validate(){
        String file_name = "file_1.txt";
        File file = new File("src/data/" + file_name);

        app.sendFile_page.download_file(file.getAbsolutePath());
        String url = "https://" + app.sendFile_page.get_download_link();
        app.sendFile_page.set_term_expire("1");
        app.getBaseHelper().open_new_tab_and_go_to_url(url);
        app.sendFile_page.validate_text_term_expire();
        app.getBaseHelper().close_tab();

    }

    @Test
    public void test_download_file_with_number_of_downloads_and_validate() {
        String file_name = "file_1.txt";
        File file = new File("src/data/" + file_name);

        app.sendFile_page.download_file(file.getAbsolutePath());
        String url = "https://" + app.sendFile_page.get_download_link();
        app.sendFile_page.set_number_of_downloads("1");
        app.getBaseHelper().open_new_tab_and_go_to_url(url);
        app.sendFile_page.validate_number_of_available_downloads(1);
        app.getBaseHelper().close_tab();
    }

    @Test
    public void test_download_file_with_password_protect_and_validate_available_to_download() {
        String file_name = "file_1.txt";
        File file = new File("src/data/" + file_name);

        app.sendFile_page.download_file(file.getAbsolutePath());
        String url = "https://" + app.sendFile_page.get_download_link();
        app.sendFile_page.set_password_protect();
        app.sendFile_page.type_password("123qweASD");
        app.getBaseHelper().open_new_tab_and_go_to_url(url);
        app.sendFile_page.validate_password_protect();
        app.sendFile_page.enter_password_to_download("123qweASD");
        app.sendFile_page.click_unblock_btn();
        app.sendFile_page.validate_file_available_to_download(file_name);
        app.getBaseHelper().close_tab();

    }

    @Test
    public void test_download_file_with_password_protect_and_validate_unavailable_to_download_with_wrong_password() {
        String file_name = "file_1.txt";
        File file = new File("src/data/" + file_name);

        app.sendFile_page.download_file(file.getAbsolutePath());
        String url = "https://" + app.sendFile_page.get_download_link();
        app.sendFile_page.set_password_protect();
        app.sendFile_page.type_password("123qweASD");
        app.getBaseHelper().open_new_tab_and_go_to_url(url);
        app.sendFile_page.validate_password_protect();
        app.sendFile_page.enter_password_to_download("123qweASD1");
        app.sendFile_page.click_unblock_btn();
        app.sendFile_page.validate_file_unavailable_to_download();
        app.getBaseHelper().close_tab();

    }

    @Test
    public void test_download_file_and_send_by_email() {
        String file_name = "file_1.txt";
        File file = new File("src/data/" + file_name);

        app.sendFile_page.download_file(file.getAbsolutePath());
        app.sendFile_page.go_to_send_by_email_tab();
        app.sendFile_page.fill_in_send_by_email_form("Anna.Lesovikova@artezio.com",
                "Autotest", "Autotest test test");
        app.sendFile_page.click_send_button();
        app.sendFile_page.validate_success_message_send_by_email();

    }

}

