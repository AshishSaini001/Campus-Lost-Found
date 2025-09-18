package lost_found.loss_data.Services;

import lost_found.loss_data.model.LostData;
import lost_found.loss_data.repository.LostDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostDataService {
    private final LostDataRepository lostDataRepository;

    public LostDataService(LostDataRepository lostDataRepository) {
        this.lostDataRepository = lostDataRepository;
    }

    public List<LostData> getAllLostData() {
        return lostDataRepository.findAll();
    }

    public LostData saveLostData(LostData lostData) {
        return lostDataRepository.save(lostData);
    }

    public LostData getLostDataById(Long id) {
        return lostDataRepository.findById(id).orElseThrow(() -> new RuntimeException("Lost data not found"));
    }

    public LostData updateLostData(Long id, LostData updatedLostData) {
        LostData existingLostData = lostDataRepository.findById(id).orElseThrow(() -> new RuntimeException("Lost data not found"));
        existingLostData.setName(updatedLostData.getName());
        existingLostData.setDescription(updatedLostData.getDescription());
        existingLostData.setStatus(updatedLostData.getStatus());
        return lostDataRepository.save(existingLostData);
    }

    public void deleteLostData(Long id) {
        if (!lostDataRepository.existsById(id)) {
            throw new RuntimeException("Lost data not found");
        }
        lostDataRepository.deleteById(id);
    }
}