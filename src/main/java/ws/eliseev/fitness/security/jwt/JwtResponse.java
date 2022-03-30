package ws.eliseev.fitness.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * класс, который будет содержать в ответе access и refresh токены
 */
@Getter
@AllArgsConstructor
public class JwtResponse {
    private final String type = "Bearer";
    private String accessToken;
    private String refreshToken;
}
