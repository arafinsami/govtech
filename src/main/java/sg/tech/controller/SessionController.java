package sg.tech.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sg.tech.dto.SessionDTO;
import sg.tech.entity.Session;
import sg.tech.service.SessionService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "session")
public class SessionController {

    private final SessionService sessionService;

    @PostMapping
    public ResponseEntity<SessionDTO> createSession(@RequestBody SessionDTO request) {
        Session session = request.createSession();
        Session sessionDB = sessionService.createSession(session);
        return new ResponseEntity<>(SessionDTO.from(sessionDB), HttpStatus.CREATED);
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<SessionDTO> getSessionById(@PathVariable Long sessionId) {
        Session session = sessionService.getSessionById(sessionId);
        return new ResponseEntity<>(SessionDTO.from(session), HttpStatus.OK);
    }

    @PutMapping("/{sessionId}/end")
    public ResponseEntity<?> endSession(@PathVariable Long sessionId) {
        sessionService.endSession(sessionId);
        return new ResponseEntity<>("session ended with session id:" + sessionId, HttpStatus.OK);
    }
}
