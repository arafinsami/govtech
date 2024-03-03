package sg.tech.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sg.tech.entity.AppUser;
import sg.tech.entity.Session;
import sg.tech.repository.UserRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public AppUser createUser(AppUser user) {
        return userRepository.save(user);
    }

    public AppUser getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public AppUser addUserToSession(Long userId, Long sessionId) {
        AppUser user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            Session session = user.getSession();
            if (session != null && session.getId().equals(sessionId)) {
                return user;
            }
            session = new Session();
            session.setId(sessionId);
            user.setSession(session);
            userRepository.save(user);
        }
        return user;
    }

    public void removeUserFromSession(Long userId) {
        AppUser user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setSession(null);
            userRepository.save(user);
        }
    }
}
