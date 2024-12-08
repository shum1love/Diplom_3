import org.junit.Test;

public class Testiksapi {
    ApiLogin apiLogin = new ApiLogin();
    @Test
    public void supertest(){
        apiLogin.apiLogin("bogdan.example62@yandex.ru", "Bogdan123");
    }
}
