package lost_found.loss_data.Services;

import lost_found.loss_data.model.FoundItem;
import lost_found.loss_data.repository.FoundItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoundItemService {
    private final FoundItemRepository foundItemRepository;

    public FoundItemService(FoundItemRepository foundItemRepository) {
        this.foundItemRepository = foundItemRepository;
    }

    public FoundItem saveFoundItem(FoundItem foundItem) {
        return foundItemRepository.save(foundItem);
    }

    public List<FoundItem> getAllFoundItems() {
        return foundItemRepository.findAll();
    }

    public FoundItem getFoundItemById(Long id) {
        return foundItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Found item not found"));
    }

    public FoundItem updateFoundItem(Long id, FoundItem updatedFoundItem) {
        FoundItem existingFoundItem = foundItemRepository.findById(id).orElseThrow(() -> new RuntimeException("Found item not found"));
        existingFoundItem.setName(updatedFoundItem.getName());
        existingFoundItem.setDescription(updatedFoundItem.getDescription());
        existingFoundItem.setLocation(updatedFoundItem.getLocation());
        existingFoundItem.setDate(updatedFoundItem.getDate());
        return foundItemRepository.save(existingFoundItem);
    }

    public void deleteFoundItem(Long id) {
        if (!foundItemRepository.existsById(id)) {
            throw new RuntimeException("Found item not found");
        }
        foundItemRepository.deleteById(id);
    }
}