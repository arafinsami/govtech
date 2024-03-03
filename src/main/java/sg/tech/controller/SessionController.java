package sg.tech.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sg.tech.entity.Session;
import sg.tech.service.SessionService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "session")
public class SessionController {

    private final SessionService sessionService;

    @PostMapping
    public Session createSession(@RequestBody Session session) {
        return sessionService.createSession(session);
    }

    @GetMapping("/{sessionId}")
    public Session getSessionById(@PathVariable Long sessionId) {
        return sessionService.getSessionById(sessionId);
    }

    @PutMapping("/{sessionId}/end")
    public void endSession(@PathVariable Long sessionId) {
        sessionService.endSession(sessionId);
    }
}
