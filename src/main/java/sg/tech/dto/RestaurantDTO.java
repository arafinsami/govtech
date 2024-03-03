package sg.tech.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import sg.tech.entity.Restaurant;

@Data
@NoArgsConstructor
public class RestaurantDTO {

    private String restaurantName;

    private Long sessionId;

    public static RestaurantDTO from(Restaurant restaurant) {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setRestaurantName(restaurant.getRestaurantName());
        dto.setSessionId(restaurant.getSession().getId());
        return dto;
    }
}
