package sg.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Restaurant extends BaseEntity {

    private String restaurantName;

    @OneToOne
    @JoinColumn(name = "session_id")
    private Session session;
}
