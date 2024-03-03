package sg.tech.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sg.tech.entity.AppUser;
import sg.tech.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public AppUser createUser(@RequestBody AppUser user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public AppUser getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}/session/{sessionId}")
    public void addUserToSession(@PathVariable Long userId, @PathVariable Long sessionId) {
        userService.addUserToSession(userId, sessionId);
    }

    @DeleteMapping("/{userId}/session")
    public void removeUserFromSession(@PathVariable Long userId) {
        userService.removeUserFromSession(userId);
    }
}
