package lost_found.loss_data.repository;

import lost_found.loss_data.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // Additional query methods (if needed)
}
