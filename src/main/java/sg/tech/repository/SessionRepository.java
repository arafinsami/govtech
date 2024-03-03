package sg.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sg.tech.entity.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
}
