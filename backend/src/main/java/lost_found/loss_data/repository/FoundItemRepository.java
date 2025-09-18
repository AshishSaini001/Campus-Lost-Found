
package lost_found.loss_data.repository;

import lost_found.loss_data.model.FoundItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoundItemRepository extends JpaRepository<FoundItem, Long> {
    // Additional query methods (if needed)
}