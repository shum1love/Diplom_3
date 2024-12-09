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
    // нопка Войти в аккаунт на главной странице
    private By  buttonLoginAccount = By.xpath(".//button[contains(text(), 'Войти в аккаунт')]");
    // Кнопка Офрмить заказ на главной страницы. Видно только авторизированному пользователю
    private By buttonPlaceOrder = By.xpath(".//button[contains(text(), 'Оформить заказ')]");

    // Кнопка личный кабинет
    private By  buttonPersonalAccount = By.xpath(".//p[contains(text(), 'Личный Кабинет')]");

    // Окно Авторизции
    // Поле ввода email в окне авторизации
    private By fieldEmailLogin = By.xpath(".//label[contains(text(), 'Email')]/following-sibling::input");
    // Поле ввода password в окне авторизации
    private By fieldPasswordLogin = By.xpath(".//label[contains(text(), 'Пароль')]/following-sibling::input");
    // Кнопка регистрации в окне авторизации
    private By  buttonRegistration = By.className("Auth_link__1fOlj");
    // Кнопка зарегистрироваться в окне авторизации
    private By  buttonLoginLogin = By.xpath(".//button[contains(text(), 'Войти')]");
    // Кнопка Восстановить пароль в окне авторизации
    private By buttonRecoverPassword = By.xpath(".//a[text()='Восстановить пароль']");


    // Окно Восстановление пароля
    // Кнопка Войти в окне Восстановление пароля
    private By buttonLoginRecoveryPassword = By.xpath(".//a[text()='Войти']");


    // Окно Регистрации
    // Поле ввода имени в окне Регистрации
    private By  fieldNameReg = By.xpath(".//label[contains(text(), 'Имя')]/following-sibling::input");
    // Поле ввода емейла в окне Регистрации
    private By  fieldEmailReg = By.xpath(".//label[contains(text(), 'Email')]/following-sibling::input");
    // Поле ввода пароля в окне Регистрации
    private By  fieldPasswordReg = By.xpath(".//label[contains(text(), 'Пароль')]/following-sibling::input");
    // Кнопка регистрации в в окне Регистрации
    private By  buttonRegistrationReg = By.xpath(".//button[contains(text(), 'Зарегистрироваться')]");
    // Кнопка Войти в в окне Регистрации
    private By buttonLoginReg = By.xpath(".//a[text()='Войти']");
    // Текст некорректный пароль в в окне Регистрации
    private By  textWrongPassword = By.xpath(".//p[contains(text(), 'Некорректный пароль')]");


    // Коструктор. Шаг. Совершает регистрацию
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Создаем объект WebDriverWait с таймаутом 10 сек
    }
    @Step("Клик по кнопке войти в аккаунт на главной странице сайта")
    public void clickButtonLoginAccount(){
        driver.findElement(buttonLoginAccount).click();
    }
    @Step
    public void waitButtonPlaceOrder(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement placeOrderButton = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonPlaceOrder));
    }
    @Step("Видимость кнопки Оформить заказ на главной странице сайта")
    public boolean enabledButtonPlaceOrder(){
         return driver.findElement(buttonPlaceOrder).isDisplayed();
    }

    @Step("Клик по полю Email в окне авторизации")
    public void clickFieldEmailLogin(){
        driver.findElement(fieldEmailLogin).click();
    }
    @Step("Ввод текста в поле Email в окне авторизации")
    public void setFieldEmailLogin(String email){
        driver.findElement(fieldEmailLogin).sendKeys(email);
    }
    @Step("Клик по полю Пароль в окне Авторизации")
    public void clickFieldPasswordLogin(){
        driver.findElement(fieldPasswordLogin).click();
    }
    @Step("Ввод тектса в поле пароль в окне Авторизации")
    public void setFieldPasswordLogin(String password){
        driver.findElement(fieldPasswordLogin).sendKeys(password);
    }
    @Step("Клик по кнопке личный кабинет в шапке сайта")
    public void clickPersonalAccount(){
        driver.findElement(buttonPersonalAccount).click();
    }
    @Step("Клик по кнопке Войти в окне авторизации")
    public void clickButtonLoginLogin(){
        driver.findElement(buttonLoginLogin).click();
    }
    @Step("Клик по кнопке зарегистрироваться в окне авторизации")
    public void clickButtonRegistration(){
        driver.findElement(buttonRegistration).click();
    }
    @Step("Клик по кнопке восстановление пароля в окне авторизации")
    public void clickButtonRecoveryPassword(){
        driver.findElement(buttonRecoverPassword).click();
    }

    // Окно Восстановлеине пароля
    @Step("Клик по кнопке Войти в окне Восстановление пароля")
    public void clickButtonLoginRecoveryPassword(){
        driver.findElement(buttonLoginRecoveryPassword).click();
    }


    // Окно регистрации
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
    @Step("Клик по кнопке Зарегистрироваться в окне регистрации")
    public void clickButtonRegistrationReg(){
        driver.findElement(buttonRegistrationReg).click();
    }
    @Step("Проверка на отображение текста ошибки при неверно набранном пароле")
    public boolean visibleTextwrongPassword(){
        return driver.findElement(textWrongPassword).isDisplayed();
    }
    @Step
    public void clickButtonLoginReg(){
        driver.findElement(buttonLoginReg).click();
    }
}
