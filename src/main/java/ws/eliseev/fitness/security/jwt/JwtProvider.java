package ws.eliseev.fitness.security.jwt;

import io.jsonwebtoken.*;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ws.eliseev.fitness.dto.UserDto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Costa Vashchuk
 * Класс генерации и валидации access и refresh токенов
 */
@Slf4j
@Component
public class JwtProvider {

    private static final String JWT_ACCESS_SECRET = "superPuperSecret";
    private static final String JWT_REFRESH_SECRET = "superPuperRefresh";


    /**
     * Генерация access-токен. Принимает объект пользователя и генерирует access токен для него.
     *
     * @return возвращает access-token
     */
    public String generateAccessToken(UserDto user) {
        final LocalDateTime now = LocalDateTime.now();
        final Instant accessExpirationInstant = now.plusMinutes(30).atZone(ZoneId.systemDefault()).toInstant();
        final Date accessExpiration = Date.from(accessExpirationInstant);
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(accessExpiration)
                .signWith(SignatureAlgorithm.HS512, JWT_ACCESS_SECRET)
                .claim("roles", user.getRoles())
                .claim("firstName", user.getFirstName())
                .compact();
    }

    /**
     * Генерация refresh-токена
     *
     * @return новый refresh-токен
     */
    public String generateRefreshToken(UserDto user) {
        final LocalDateTime now = LocalDateTime.now();
        final Instant refreshExpirationInstant = now.plusDays(30).atZone(ZoneId.systemDefault()).toInstant();
        final Date refreshExpiration = Date.from(refreshExpirationInstant);
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setExpiration(refreshExpiration)
                .signWith(SignatureAlgorithm.HS512, JWT_REFRESH_SECRET)
                .compact();
    }

    /**
     * отвечает за проверку валидности токена.
     * @param token - токен
     * @return true or false
     */
    public boolean validateAccessToken(@NonNull String token) {
        return validateToken(token, JWT_ACCESS_SECRET);
    }

    /**
     * отвечает за проверку валидности токена.
     * @param token токен
     * @return true or false
     */

    public boolean validateRefreshToken(@NonNull String token) {
        return validateToken(token, JWT_REFRESH_SECRET);
    }

    private boolean validateToken(@NonNull String token, @NonNull String secret) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException expEx) {
            log.error("Token expired", expEx);
        } catch (UnsupportedJwtException unsEx) {
            log.error("Unsupported jwt", unsEx);
        } catch (MalformedJwtException mjEx) {
            log.error("Malformed jwt", mjEx);
        } catch (SignatureException sEx) {
            log.error("Invalid signature", sEx);
        } catch (Exception e) {
            log.error("invalid token", e);
        }
        return false;
    }

    public Claims getAccessClaims(@NonNull String token) {
        return getClaims(token, JWT_ACCESS_SECRET);
    }

    public Claims getRefreshClaims(@NonNull String token) {
        return getClaims(token, JWT_REFRESH_SECRET);
    }

    private Claims getClaims(@NonNull String token, @NonNull String secret) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
}
