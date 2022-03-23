package ws.eliseev.fitness.service.jwt;

import io.jsonwebtoken.Claims;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.dto.UserDto;
import ws.eliseev.fitness.security.jwt.JwtAuthentication;
import ws.eliseev.fitness.security.jwt.JwtProvider;
import ws.eliseev.fitness.security.jwt.JwtRequest;
import ws.eliseev.fitness.security.jwt.JwtResponse;
import ws.eliseev.fitness.service.IUserService;

import javax.security.auth.message.AuthException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Costa Vashchuk
 * Класс получения новых токенов взамен "протухших"
 */

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final String USER_NOT_FOUND = "Пользователь не найден";
    private final IUserService userService;
    private final Map<String, String> refreshStorage = new HashMap<>();
    private final JwtProvider jwtProvider;

    /**
     * Находим пользователя по логину.
     * Если пользователь найден, и присланный пароль совпадает с паролем пользователя,
     * то передаем объект пользователя в JwtProvider и получаем от него токены.
     *
     * @param authRequest запрос с фронта
     *
     * @throws AuthException
     */

    public JwtResponse login(@NonNull JwtRequest authRequest) throws AuthException {
        final UserDto user = userService.getByUserName(authRequest.getUsername())
                .orElseThrow(() -> new AuthException(USER_NOT_FOUND));
        if (user.getPassword().equals(authRequest.getPassword())) {
            final String accessToken = jwtProvider.generateAccessToken(user);
            final String refreshToken = jwtProvider.generateRefreshToken(user);
            refreshStorage.put(user.getUsername(), refreshToken);
            return new JwtResponse(accessToken, refreshToken);
        } else {
            throw new AuthException("Неправильный пароль");
        }
    }

    /**
     * Принимает refresh токен, а возвращает новый access токен.
     * Сначала мы проверяем, что присланный refresh токен валиден.
     * Если валиден, то получаем claims и оттуда получаем логин пользователя.
     *
     * @throws AuthException
     */

    public JwtResponse getAccessToken(@NonNull String refreshToken) throws AuthException {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final UserDto user = userService.getByUserName(login)
                        .orElseThrow(() -> new AuthException(USER_NOT_FOUND));
                final String accessToken = jwtProvider.generateAccessToken(user);
                return new JwtResponse(accessToken, null);
            }
        }
        return new JwtResponse(null, null);
    }

    public JwtResponse refresh(@NonNull String refreshToken) throws AuthException {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            final Claims claims = jwtProvider.getRefreshClaims(refreshToken);
            final String login = claims.getSubject();
            final String saveRefreshToken = refreshStorage.get(login);
            if (saveRefreshToken != null && saveRefreshToken.equals(refreshToken)) {
                final UserDto user = userService.getByUserName(login)
                        .orElseThrow(() -> new AuthException(USER_NOT_FOUND));
                final String accessToken = jwtProvider.generateAccessToken(user);
                final String newRefreshToken = jwtProvider.generateRefreshToken(user);
                refreshStorage.put(user.getUsername(), newRefreshToken);
                return new JwtResponse(accessToken, newRefreshToken);
            }
        }
        throw new AuthException("Невалидный JWT токен");
    }

    public JwtAuthentication getAuthInfo() {
        return (JwtAuthentication) SecurityContextHolder.getContext().getAuthentication();
    }
}
