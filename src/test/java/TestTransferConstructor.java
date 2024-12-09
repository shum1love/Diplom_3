import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObject.RegistrationPage;
import static org.junit.Assert.assertEquals;
public class TestTransferConstructor {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    @Before
    public void setUp() {
        // Создаем WebDriver через класс Browser
        driver = Browser.createWebDriver();
        driver.manage().window().maximize();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        registrationPage = new RegistrationPage(driver);
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Без авторизации")
    public void testTransferConstructor(){
        registrationPage.clickButtonConstructor();
        assertEquals(registrationPage.checkButtonLoginAccount(), true);
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор через логотип Stellar Burgers")
    @Description("Без авторизации")
    public void testTransferConstructorLogo(){
        registrationPage.clickLogoStellarBurger();
        assertEquals(registrationPage.checkButtonLoginAccount(), true);
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
