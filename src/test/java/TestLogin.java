import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.RegistrationPage;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class TestLogin {
    private WebDriver driver;
    ApiRegistration apiRegistration = new ApiRegistration();
    private String token;
    private RegistrationPage registrationPage;
    private String name = "Bogdan";
    String email = "bogdan.example98@yandex.ru";
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
    @DisplayName("Тест 1: вход по кнопке 'Войти в аккаунт' на главной")
    @Description("Создание пользователя чероез API, стандартный вход. Проверка видимости элемента Оформить заказ на главной странице для авторизированных пользователей")
    public void testLoginMainPage() {
        token = apiRegistration.apiRegistration(email, password, name);
        registrationPage.clickButtonLoginAccount();
        registrationPage.clickFieldEmailLogin();
        registrationPage.setFieldEmailLogin(email);
        registrationPage.clickFieldPasswordLogin();
        registrationPage.setFieldPasswordLogin(password);
        registrationPage.clickButtonLoginLogin();
        registrationPage.waitButtonPlaceOrder();
        assertEquals(registrationPage.enabledButtonPlaceOrder(), true);
    }
    @Test
    @DisplayName("Тест 2: вход через кнопку 'Личный кабинет'")
    @Description("Создание пользователя чероез API, стандартный вход. Проверка видимости элемента Оформить заказ на главной странице для авторизированных пользователей")
    public void testLoginPersonalAccount(){
        token = apiRegistration.apiRegistration(email, password, name);
        registrationPage.clickPersonalAccount();
        registrationPage.clickFieldEmailLogin();
        registrationPage.setFieldEmailLogin(email);
        registrationPage.clickFieldPasswordLogin();
        registrationPage.setFieldPasswordLogin(password);
        registrationPage.clickButtonLoginLogin();
        registrationPage.waitButtonPlaceOrder();
        assertEquals(registrationPage.enabledButtonPlaceOrder(), true);
    }
    @Test
    @DisplayName("Тест 3: вход через кнопку в форме регистрации")
    @Description("Создание пользователя чероез API, стандартный вход. Проверка видимости элемента Оформить заказ на главной странице для авторизированных пользователей")
    public void testLoginRegistrationForm(){
        token = apiRegistration.apiRegistration(email, password, name);
        registrationPage.clickPersonalAccount();
        registrationPage.clickButtonRegistration();
        registrationPage.clickButtonLoginReg();
        registrationPage.clickFieldEmailLogin();
        registrationPage.setFieldEmailLogin(email);
        registrationPage.clickFieldPasswordLogin();
        registrationPage.setFieldPasswordLogin(password);
        registrationPage.clickButtonLoginLogin();
        registrationPage.waitButtonPlaceOrder();
        assertEquals(registrationPage.enabledButtonPlaceOrder(), true);
    }
    @Test
    @DisplayName("Тест 4: вход через кнопку в форме восстановления пароля")
    @Description("Создание пользователя чероез API, стандартный вход. Проверка видимости элемента Оформить заказ на главной странице для авторизированных пользователей")
    public void testLoginRecoverPasswordForm(){
        token = apiRegistration.apiRegistration(email, password, name);
        registrationPage.clickPersonalAccount();
        registrationPage.clickButtonRecoveryPassword();
        registrationPage.clickButtonLoginRecoveryPassword();
        registrationPage.clickFieldEmailLogin();
        registrationPage.setFieldEmailLogin(email);
        registrationPage.clickFieldPasswordLogin();
        registrationPage.setFieldPasswordLogin(password);
        registrationPage.clickButtonLoginLogin();
        registrationPage.waitButtonPlaceOrder();
        assertEquals(registrationPage.enabledButtonPlaceOrder(), true);
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
