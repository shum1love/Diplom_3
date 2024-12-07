package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;
public class RegistrationPage {
    private WebDriver driver;
    // нопка личный кабинет
    private By  buttonPersonalAccount = By.className("AppHeader_header__link__3D_hX");
    // Поле ввода email в окне авторизации
    private By  fieldInputEmail = By.className("text input__textfield text_type_main-default");
    // Поле ввода пароля в окне авторизации
    private By  buttonLogin = By.className("text input__textfield text_type_main-default");
    // Поле ввода пароля в окне авторизации
    private By  fieldInputPassword = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa");
    // нопка регистрации в в окне авторизации
    private By  buttonRegistration = By.className("Auth_link__1fOlj");
    // Поле ввода имени в окне Регистрации
    private By  fieldNameReg = By.className("input pr-6 pl-6 input_type_text input_size_default");
    // Поле ввода емейла в окне Регистрации
    private By  fieldEmailReg = By.className("input pr-6 pl-6 input_type_text input_size_default");
    // Поле ввода пароля в окне Регистрации
    private By  fieldPasswordReg = By.className("input__placeholder text noselect text_type_main-default");
    // нопка регистрации в в окне Регистрации
    private By  buttonRegistrationReg = By.className("button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa");

    // Коструктор. Шаг. Совершает регистрацию
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }
    @Step("Клик по кнопке личный кабинет")
    public void clickPersonalAccount(){
        driver.findElement(buttonPersonalAccount).click();
    }
    @Step("Клик по кнопке зарегистрироваться")
    public void clickButtonRegistration(){
        driver.findElement(buttonRegistration).click();
    }
    @Step("Ввод email: {email}")
    public void setEmail(String email){
        driver.findElement(fieldInputEmail).sendKeys(email);
    }

}
