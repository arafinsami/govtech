package sg.tech.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sg.tech.entity.Restaurant;
import sg.tech.repository.RestaurantRepository;

import java.util.List;
import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant addRestaurantToSession(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant getRandomRestaurant(Long sessionId) {
        List<Restaurant> restaurants = restaurantRepository.findBySession_Id(sessionId);
        if (restaurants.isEmpty()) {
            return null; // No restaurants found for the session
        }

        Random random = new Random();
        int randomIndex = random.nextInt(restaurants.size());
        return restaurants.get(randomIndex);
    }
}
