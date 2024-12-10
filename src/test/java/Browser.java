import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser");
        if (browser == null || browser.isEmpty()) {
            throw new IllegalArgumentException("Не указан браузер! Передайте параметр -Dbrowser=<chrome|yandex>");
        }

        switch (browser.toLowerCase()) {
            case "yandex":
                return createYandexDriver();
            case "chrome":
                return createChromeDriver();
            default:
                throw new IllegalArgumentException("Неподдерживаемый браузер: " + browser);
        }
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    private static WebDriver createYandexDriver() {
        // Убедитесь, что пути к драйверу и бинарнику корректны
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriveryandex\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Rodion\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        return new ChromeDriver(options);
    }
}
/*
Пример запуска:

Для Chrome:
mvn test -Dbrowser=chrome

Для Yandex Browser:
mvn test -Dbrowser=yandex
*/
