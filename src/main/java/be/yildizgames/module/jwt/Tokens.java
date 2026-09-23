package be.yildizgames.module.jwt;

/**
 * @author Grégory Van den Borre
 */
public record Tokens(
        String accessToken,
        String refreshToken,
        IdToken idToken,
        long expiresIn,
        long issuedAt
) {
    public boolean isExpired() {
        long now = System.currentTimeMillis() / 1000;
        return now >= issuedAt + expiresIn - 30;
    }
}
