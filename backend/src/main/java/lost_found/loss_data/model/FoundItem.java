package lost_found.loss_data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "found_items") // Explicitly define the table name
public class FoundItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Column(nullable = false) // Name cannot be null
    private String name;

    @Column(length = 500) // Limit description length to 500 characters
    private String description;

    @NotNull(message = "Location cannot be null")
    @Column(nullable = false) // Location cannot be null
    private String location; // Where the item was found

    @NotNull(message = "Date cannot be null")
    @Column(nullable = false) // Date cannot be null
    private String date; // When the item was found
}