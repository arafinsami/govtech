package sg.tech.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sg.tech.entity.Restaurant;
import sg.tech.service.RestaurantService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public Restaurant addRestaurantToSession(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurantToSession(restaurant);
    }

    @GetMapping("/random/{sessionId}")
    public Restaurant getRandomRestaurant(@PathVariable Long sessionId) {
        return restaurantService.getRandomRestaurant(sessionId);
    }
}
