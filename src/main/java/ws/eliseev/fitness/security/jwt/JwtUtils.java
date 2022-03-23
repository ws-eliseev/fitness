package ws.eliseev.fitness.security.jwt;

import io.jsonwebtoken.Claims;

public class JwtUtils {
    public static JwtAuthentication generate(Claims claims) {
        return new JwtAuthentication();
    }
}
