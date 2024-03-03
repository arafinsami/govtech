package sg.tech.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.tech.entity.AppUser;
import sg.tech.entity.Restaurant;
import sg.tech.entity.Session;
import sg.tech.entity.SessionStatus;

import java.util.List;

@Data
@NoArgsConstructor
public class SessionDTO {

    private SessionStatus sessionStatus;

    private List<AppUser> users;

    private Restaurant restaurant;

    public static SessionDTO from(Session session) {
        SessionDTO dto = new SessionDTO();
        dto.setSessionStatus(session.getSessionStatus());
        dto.setUsers(session.getUsers());
        dto.setRestaurant(dto.getRestaurant());
        return dto;
    }

    public Session createSession() {
        Session session = new Session();
        session.setSessionStatus(sessionStatus);
        return session;
    }
}
