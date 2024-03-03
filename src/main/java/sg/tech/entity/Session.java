package sg.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Session extends BaseEntity {

    private SessionStatus sessionStatus;

    @OneToMany(mappedBy = "session")
    private List<AppUser> users;

    @OneToOne(mappedBy = "session")
    private Restaurant restaurant;
}
