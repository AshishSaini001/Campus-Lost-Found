package lost_found.loss_data.repository;

import lost_found.loss_data.model.LostData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LostDataRepository extends JpaRepository<LostData, Long> {
    // Additional query methods (if needed)
}