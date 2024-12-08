import org.junit.Before;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class ApiLogin {
    private String refreshToken; // Поле для сохранения refreshToken

    public String apiLogin(String email, String password) {
        User user = new User(email, password);

        // Выполняем POST запрос и извлекаем ответ
        Response response = given()
                .header("Content-Type", "application/json")
                .body(user)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login");

        // Извлекаем refreshToken из ответа
        refreshToken = response.jsonPath().getString("accessToken"); // Сохраняем refreshToken
        return refreshToken; // Возвращаем refreshToken
    }

     public String getRefreshToken() {
        return refreshToken; // Геттер для доступа к refreshToken
    }
}