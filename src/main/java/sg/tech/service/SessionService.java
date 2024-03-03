package sg.tech.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sg.tech.entity.Session;
import sg.tech.entity.SessionStatus;
import sg.tech.exception.ResourceNotFoundException;
import sg.tech.repository.SessionRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class SessionService {

    private final SessionRepository sessionRepository;

    public Session createSession(Session session) {
        session.setSessionStatus(SessionStatus.ACTIVE);
        return sessionRepository.save(session);
    }

    public Session getSessionById(Long sessionId) {
        return sessionRepository.findById(sessionId).orElseThrow(ResourceNotFoundException::new);
    }

    public void endSession(Long sessionId) {
        Session session = sessionRepository.findById(sessionId).orElse(null);
        if (session != null) {
            session.setSessionStatus(SessionStatus.ENDED);
            sessionRepository.save(session);
        }
    }
}
