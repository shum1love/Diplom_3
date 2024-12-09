import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.RegistrationPage;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class TestRegistration {
    private WebDriver driver;
    ApiLogin apiLogin = new ApiLogin();
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
        driver.get("https://stellarburgers.nomoreparties.site/register");
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверка успешной регистрации нового пользователя с корректными данными")
    public void testSuccessfulRegistration() {
        registrationPage.clickPersonalAccount();
        registrationPage.clickButtonRegistration();
        registrationPage.clickFieldNameReg();
        registrationPage.setFieldNameReg(name);
        registrationPage.clickEmailfield();
        registrationPage.setEmail(email);
        registrationPage.clickPasswordfield();
        registrationPage.setPassword(password);
        registrationPage.clickButtonRegistrationReg();
        token = apiLogin.apiLogin(email, password);
    }
    @Test
    @DisplayName("Проверка регистрации с паролем меньше допустимого")
    @Description("5 символов")
    public void testWrongPasswordRegistration(){
        registrationPage.clickPersonalAccount();
        registrationPage.clickButtonRegistration();
        registrationPage.clickFieldNameReg();
        registrationPage.setFieldNameReg(name);
        registrationPage.clickEmailfield();
        registrationPage.setEmail(email);
        registrationPage.clickPasswordfield();
        registrationPage.setPassword(wrongPassword);
        registrationPage.clickButtonRegistrationReg();
        token = apiLogin.apiLogin(email, wrongPassword);
        assertEquals(registrationPage.visibleTextwrongPassword(), true);
        assertEquals(token, null);
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
    public void tearDown() {
        if (driver != null) {  // Проверяем, что драйвер не равен null
            driver.quit();     // Закрываем все окна браузера
        }
    }

}
