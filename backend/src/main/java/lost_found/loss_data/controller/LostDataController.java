package lost_found.loss_data.controller;

import lost_found.loss_data.Services.LostDataService;
import lost_found.loss_data.model.LostData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/lost-items") // Update the mapping to "lost-items"
public class LostDataController {
    private final LostDataService lostDataService;

    public LostDataController(LostDataService lostDataService) {
        this.lostDataService = lostDataService;
    }

    @PostMapping
    public LostData createLostData(@Valid @RequestBody LostData lostData) {
        return lostDataService.saveLostData(lostData);
    }

    @GetMapping
    public List<LostData> getAllLostData() {
        return lostDataService.getAllLostData();
    }

    @GetMapping("/{id}")
    public LostData getLostDataById(@PathVariable Long id) {
        return lostDataService.getLostDataById(id);
    }

    @PutMapping("/{id}")
    public LostData updateLostData(@PathVariable Long id, @RequestBody LostData updatedLostData) {
        return lostDataService.updateLostData(id, updatedLostData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLostData(@PathVariable Long id) {
        lostDataService.deleteLostData(id);
        return ResponseEntity.ok("Lost data deleted successfully");
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}