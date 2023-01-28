package guru.springframework.sfgdi.datasource;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class FakeDataSource {
    private final String username;
    private final String password;

    public FakeDataSource(@Value("${popika.username}") String username,
                          @Value("${popika.password}") String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
