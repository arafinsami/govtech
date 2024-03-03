package sg.tech.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import sg.tech.entity.AppUser;

@Data
@NoArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank
    private String username;

    public static UserDTO from(AppUser user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        return dto;
    }

    public AppUser createUser() {
        AppUser user = new AppUser();
        user.setUsername(username);
        return user;
    }
}
