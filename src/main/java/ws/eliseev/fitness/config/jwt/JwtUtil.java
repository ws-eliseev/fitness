package ws.eliseev.fitness.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import ws.eliseev.fitness.model.User;
import ws.eliseev.fitness.repository.IUserRepository;

import java.nio.charset.StandardCharsets;
import java.util.Date;


@Service
public class JwtUtil {

    @Value(value = "SecretKey")
    private String SECRET_KEY;

    private final IUserRepository userRepository;

    @Autowired
    public JwtUtil(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Algorithm getAlgorithm() {
        return Algorithm.HMAC256(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(User user) {
        return JWT.create()
                        .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withClaim("role", user.getCustomRoles())
                .sign(getAlgorithm());
    }

    public DecodedJWT checkToken(String token) {
        JWTVerifier jwtVerifier = JWT.require(getAlgorithm()).build();
        return jwtVerifier.verify(token);
    }

    public UsernamePasswordAuthenticationToken getAuthenticationByDecodedToken(DecodedJWT decodedJWT) {
        User user = userRepository.findByUsername(decodedJWT.getSubject());
        return new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
    }

}
