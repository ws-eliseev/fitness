package ws.eliseev.fitness.security;

/**
 * @author Costa Vashchuk
 */

public class SecurityConstants {
    public static final String SECRET_KEY = "SecretKeyForToken";
    public static final long EXPIRATION_TIME = 423_000_000;
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER = "Autorization";
    public static final String SIGN_IN_URL = "/users/sign-in";
}
