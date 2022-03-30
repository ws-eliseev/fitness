package ws.eliseev.fitness.security.jwt;

import lombok.Getter;
import lombok.Setter;

/**
 * класс запроса для получения JWT-токена
 */
@Getter
@Setter
public class JwtRequest {
    private String username;
    private String password;
}
