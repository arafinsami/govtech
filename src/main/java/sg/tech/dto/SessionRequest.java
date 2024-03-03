package sg.tech.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import sg.tech.entity.Session;
import sg.tech.entity.SessionStatus;

@Data
@NoArgsConstructor
public class SessionRequest {

    private Long id;

    @NotNull
    private SessionStatus sessionStatus;

    public Session createSession() {
        Session session = new Session();
        session.setSessionStatus(sessionStatus);
        return session;
    }
}
