package lost_found.loss_data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "lost_items") // Update the table name to "lost_items"
public class LostData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null") // Validation constraint
    @Column(nullable = false) // Name cannot be null
    private String name;

    @Column(length = 500) // Limit description length to 500 characters
    private String description;

    @NotNull(message = "Status cannot be null") // Validation constraint
    @Column(nullable = false) // Status cannot be null
    private String status; // e.g., "lost"
}