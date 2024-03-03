package sg.tech.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sg.tech.dto.RestaurantDTO;
import sg.tech.entity.Restaurant;
import sg.tech.entity.Session;
import sg.tech.repository.RestaurantRepository;
import sg.tech.repository.SessionRepository;

import java.util.List;
import java.util.Random;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    private final SessionRepository sessionRepository;

    public Restaurant addRestaurantToSession(RestaurantDTO dto) {
        Session session = sessionRepository.findById(dto.getSessionId()).orElseThrow(null);
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(dto.getRestaurantName());
        restaurant.setSession(session);
        return restaurantRepository.save(restaurant);
    }

    public Restaurant getRandomRestaurant(Long sessionId) {
        List<Restaurant> restaurants = restaurantRepository.findBySession_Id(sessionId);
        if (restaurants.isEmpty()) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(restaurants.size());
        return restaurants.get(randomIndex);
    }
}
