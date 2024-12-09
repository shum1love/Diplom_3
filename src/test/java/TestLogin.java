import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.RegistrationPage;

import static io.restassured.RestAssured.given;

public class TestLogin {
    private WebDriver driver;
    ApiRegistration apiRegistration = new ApiRegistration();
    private String token;
    private RegistrationPage registrationPage;
    private String name = "Bogdan";
    String email = "bogdan.example95@yandex.ru";
    String password = "Bogdan123";
    String wrongPassword = "12345";

    @Before
    public void setUp() {
        // Создаем WebDriver через класс Browser
        driver = Browser.createWebDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site");
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверка успешной регистрации нового пользователя с корректными данными")
    public void testLoginMainPage() {
        token = apiRegistration.apiRegistration(email, password, name);
        registrationPage.clickButtonLoginAccount();
        registrationPage.clickFieldEmailLogin();
        registrationPage.setFieldEmailLogin(email);
        registrationPage.clickFieldPasswordLogin();
        registrationPage.setFieldPasswordLogin(password);
        registrationPage.clickButtonLoginLogin();

    }

    @After
    public void deleteUser() {
        if (token != null) {
            given()
                    .header("Authorization", token)
                    .when()
                    .delete("https://stellarburgers.nomoreparties.site/api/auth/user");
        }
    }
}
