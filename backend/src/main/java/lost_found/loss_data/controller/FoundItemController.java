package lost_found.loss_data.controller;

import lost_found.loss_data.Services.FoundItemService;
import lost_found.loss_data.model.FoundItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

// http://localhost:8080/api/found-items
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/found-items")
public class FoundItemController {
    private final FoundItemService foundItemService;

    public FoundItemController(FoundItemService foundItemService) {
        this.foundItemService = foundItemService;
    }
3 rfedcfsC xsecqdwvegth y$RyhTEGAhytuwj6z7
    @PostMapping
    public FoundItem createFoundItem(@Valid @RequestBody FoundItem foundItem) {
        return foundItemService.saveFoundItem(foundItem);
    }

    @GetMapping
    public List<FoundItem> getAllFoundItems() {
        return foundItemService.getAllFoundItems();
    }

    @GetMapping("/{id}")
    public FoundItem getFoundItemById(@PathVariable Long id) {
        return foundItemService.getFoundItemById(id);
    }

    @PutMapping("/{id}")
    public FoundItem updateFoundItem(@PathVariable Long id, @RequestBody FoundItem updatedFoundItem) {
        return foundItemService.updateFoundItem(id, updatedFoundItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFoundItem(@PathVariable Long id) {
        foundItemService.deleteFoundItem(id);
        return ResponseEntity.ok("Found item deleted successfully");
    }
}