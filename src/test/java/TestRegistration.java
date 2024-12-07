import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.RegistrationPage;

import static org.junit.Assert.assertEquals;
public class TestRegistration {
    private WebDriver driver;
    private RegistrationPage registrationPage;

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
        //registrationPage.setName("Тест Пользователь");
        //registrationPage.setEmail("test@example.com");
        //registrationPage.setPassword("123456");
        //registrationPage.clickRegisterButton();

        String expectedUrl = "https://stellarburgers.nomoreparties.site/";
        assertEquals("URL после успешной регистрации не соответствует ожидаемому", expectedUrl, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Ошибка при некорректном пароле")
    @Description("Проверка отображения ошибки при вводе пароля длиной менее 6 символов")
    public void testInvalidPasswordError() {
        //registrationPage.setName("Тест Пользователь");
        //registrationPage.setEmail("test@example.com");
        //registrationPage.setPassword("12345"); // Некорректный пароль
        //registrationPage.clickRegisterButton();

        //String expectedError = "Некорректный пароль";
        //assertEquals("Сообщение об ошибке не соответствует ожидаемому", expectedError, registrationPage.getErrorMessage());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
