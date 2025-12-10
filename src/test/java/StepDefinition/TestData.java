package StepDefinition;

public class TestData {
    public static String fakeEmail;
    public static String fakePassword;

    public static void setFakeEmail(String email) {
        fakeEmail = email;
    }

    public static String getFakeEmail() {
        return fakeEmail;
    }

    public static void setFakePassword(String password) {
        fakePassword = password;
    }

    public static String getFakePassword() {
        return fakePassword;
    }
}

