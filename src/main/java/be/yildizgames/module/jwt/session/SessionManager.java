package be.yildizgames.module.jwt.session;

import be.yildizgames.module.jwt.Subject;
import be.yildizgames.module.jwt.Tokens;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Grégory Van den Borre
 */
public class SessionManager {

    private final Map<UUID, UserSession> activeSessions = new ConcurrentHashMap<>();

    public UserSession addSession(Subject sub, String username, Tokens tokens) {
        var session = new UserSession(sub, username, tokens, LocalDateTime.now());
        this.activeSessions.put(sub.value(), session);
        return session;
    }

    public final UserSession getSession(Subject sub) {
        return sub == null ? null : this.activeSessions.get(sub.value());
    }

    public final void removeSession(Subject sub) {
        this.activeSessions.remove(sub.value());
    }

    public boolean isAuthenticated(Subject sub) {
        return this.activeSessions.containsKey(sub.value());
    }
}
