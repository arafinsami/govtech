package sg.tech.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.tech.entity.Session;
import sg.tech.entity.SessionStatus;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class SessionDTO {

    private Long id;

    private SessionStatus sessionStatus;

    private List<UserDTO> users;

    private RestaurantDTO restaurant;

    public static SessionDTO from(Session session) {
        SessionDTO dto = new SessionDTO();
        dto.setId(session.getId());
        dto.setSessionStatus(session.getSessionStatus());
        if (session.getUsers() != null) {
            dto.setUsers(session.getUsers().stream().map(UserDTO::from).collect(Collectors.toList()));
        }
        if (session.getRestaurant() != null) {
            dto.setRestaurant(dto.getRestaurant());
        }
        return dto;
    }
}
