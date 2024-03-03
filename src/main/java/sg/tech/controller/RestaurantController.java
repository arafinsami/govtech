package sg.tech.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sg.tech.dto.RestaurantDTO;
import sg.tech.entity.Restaurant;
import sg.tech.service.RestaurantService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<RestaurantDTO> addRestaurantToSession(@Valid @RequestBody RestaurantDTO request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Restaurant restaurant = restaurantService.addRestaurantToSession(request);
        return new ResponseEntity<>(RestaurantDTO.from(restaurant), HttpStatus.CREATED);
    }

    @GetMapping("/random/{sessionId}")
    public ResponseEntity<RestaurantDTO> getRandomRestaurant(@PathVariable Long sessionId) {
        Restaurant restaurant = restaurantService.getRandomRestaurant(sessionId);
        return new ResponseEntity<>(RestaurantDTO.from(restaurant), HttpStatus.OK);
    }
}
