package sg.tech.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import sg.tech.entity.Restaurant;

@Data
@NoArgsConstructor
public class RestaurantDTO {

    @NotBlank
    private String restaurantName;

    @NotNull
    private Long sessionId;

    public static RestaurantDTO from(Restaurant restaurant) {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setRestaurantName(restaurant.getRestaurantName());
        dto.setSessionId(restaurant.getSession().getId());
        return dto;
    }
}
