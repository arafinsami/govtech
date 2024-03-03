package sg.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class AppUser extends BaseEntity {

    private String username;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;
}
