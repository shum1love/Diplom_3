package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;
public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // нопка личный кабинет
    private By  buttonPersonalAccount = By.xpath(".//p[contains(text(), 'Личный Кабинет')]");
    // Окно Авторизции
    // Поле ввода email в окне авторизации
    private By fieldEmailLogin = By.name("name");
    // Поле ввода password в окне авторизации
    private By fieldPasswordLogin = By.name("Пароль");
    // нопка регистрации в окне авторизации
    private By  buttonRegistration = By.className("Auth_link__1fOlj");

    // Окно Регистрации
    // Поле ввода имени в окне Регистрации
    private By  fieldNameReg = By.xpath(".//label[contains(text(), 'Имя')]/following-sibling::input");
    // Поле ввода емейла в окне Регистрации
    private By  fieldEmailReg = By.xpath(".//label[contains(text(), 'Email')]/following-sibling::input");
    // Поле ввода пароля в окне Регистрации
    private By  fieldPasswordReg = By.xpath(".//label[contains(text(), 'Пароль')]/following-sibling::input");
    // нопка регистрации в в окне Регистрации
    private By  buttonRegistrationReg = By.xpath(".//button[contains(text(), 'Зарегистрироваться')]");

    // Коструктор. Шаг. Совершает регистрацию
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Создаем объект WebDriverWait с таймаутом 10 сек
    }
    @Step("Клик по кнопке личный кабинет")
    public void clickPersonalAccount(){
        driver.findElement(buttonPersonalAccount).click();
    }
    @Step("Клик по кнопке зарегистрироваться в окне авторизации")
    public void clickButtonRegistration(){
        driver.findElement(buttonRegistration).click();
    }
    @Step( "Клик по полю Имя в окне регистрации")
    public void clickFieldNameReg(){
        driver.findElement(fieldNameReg).click();
    }
    @Step("Ввод текста в поле Имя в окне регистрации")
    public void setFieldNameReg(String name){
        driver.findElement(fieldNameReg).sendKeys(name);
    }
    /*@Step("Ожидаем, пока поле ввода Email станет кликабельным")
    public void waitEmailFieldClickable() {
        wait.until(ExpectedConditions.elementToBeClickable(fieldEmailReg));
    }*/
    @Step("Клик по полю Email")
    public void clickEmailfield(){
        driver.findElement(fieldEmailReg).click();
    }
    @Step("Ввод email: {email}")
    public void setEmail(String email){
        driver.findElement(fieldEmailReg).sendKeys(email);
    }
    @Step("Клик по полю Password")
    public void clickPasswordfield(){
        driver.findElement(fieldPasswordReg).click();
    }
    @Step("Ввод password: {password}")
    public void setPassword(String password){
        driver.findElement(fieldPasswordReg).sendKeys(password);
    }
    @Step("")
    public void clickButtonRegistrationReg(){
        driver.findElement(buttonRegistrationReg).click();
    }
}
