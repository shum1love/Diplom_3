import org.junit.Test;

public class DemoTestApi {
    ApiRegistration apiRegistration = new ApiRegistration();
    @Test
    public void supertest(){
        apiRegistration.apiRegistration("bogdan.example63@yandex.ru", "12345", "Bodya");
    }
}
