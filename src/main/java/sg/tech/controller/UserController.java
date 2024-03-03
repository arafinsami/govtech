package sg.tech.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sg.tech.dto.UserDTO;
import sg.tech.entity.AppUser;
import sg.tech.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        AppUser user = request.createUser();
        AppUser userDB = userService.createUser(user);
        return new ResponseEntity<>(UserDTO.from(userDB), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        AppUser user = userService.getUserById(userId);
        UserDTO dto = UserDTO.from(user);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{userId}/session/{sessionId}")
    public ResponseEntity<UserDTO> addUserToSession(@PathVariable Long userId, @PathVariable Long sessionId) {
        AppUser user = userService.addUserToSession(userId, sessionId);
        return new ResponseEntity<>(UserDTO.from(user), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/session")
    public ResponseEntity<?> removeUserFromSession(@PathVariable Long userId) {
        userService.removeUserFromSession(userId);
        return new ResponseEntity<>("user removed from session with id:" + userId, HttpStatus.OK);
    }
}
