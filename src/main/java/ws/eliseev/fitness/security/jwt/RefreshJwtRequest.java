package ws.eliseev.fitness.security.jwt;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Costa Vashchuk
 */

@Getter
@Setter
public class RefreshJwtRequest {
    private String refreshToken;
}

