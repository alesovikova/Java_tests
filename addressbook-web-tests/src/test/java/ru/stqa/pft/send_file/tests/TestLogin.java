package ru.stqa.pft.send_file.tests;

import org.junit.Test;
//import org.testng.annotations.Test;

public class TestLogin extends TestBase {

    String users = "send_file";

    @Test
    public void test_login_incorrect_username() {
        app.getSessionHelper().login(app.getBaseHelper().read_json(users,"false_username"),
                app.getBaseHelper().read_json(users,"password"));
        app.getSessionHelper().validate_login_invalid_message();
    }

    @Test
    public void test_login_incorrect_password() {
        app.getSessionHelper().login(app.getBaseHelper().read_json(users,"username"),
                app.getBaseHelper().read_json(users,"false_password"));
        app.getSessionHelper().validate_login_invalid_message();
    }

    @Test
    public void test_login_success() {
        app.getSessionHelper().login(app.getBaseHelper().read_json(users,"username"),
                app.getBaseHelper().read_json(users,"password"));
        app.getSessionHelper().validate_user_name();

    }

}
