package sg.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sg.tech.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
}
