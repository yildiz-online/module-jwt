package be.yildizgames.module.jwt.session;

import be.yildizgames.module.jwt.Subject;
import be.yildizgames.module.jwt.Tokens;

import java.time.LocalDateTime;

/**
 * @author Grégory Van den Borre
 */
public record UserSession(
        Subject userId,
        String username,
        Tokens tokens,
        LocalDateTime loginTime
) {

    public String accessToken() {
        return this.tokens.accessToken();
    }

}
