package pl.wojciechkostecki.wood.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wojciechkostecki.wood.model.dto.TrunkDTO;
import pl.wojciechkostecki.wood.service.TrunkService;

import java.util.List;

@RestController
@RequestMapping("/api/trunks")
public class TrunkController {
    private final TrunkService trunkService;

    public TrunkController(TrunkService trunkService) {
        this.trunkService = trunkService;
    }

    @PostMapping
    public ResponseEntity<TrunkDTO> createTrunk(@RequestBody TrunkDTO trunkDTO) {
        TrunkDTO savedTrunk = trunkService.save(trunkDTO);
        return new ResponseEntity<>(savedTrunk, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TrunkDTO>> getAllTrunks() {
        return ResponseEntity.ok(trunkService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrunkDTO> getTrunk(@PathVariable Long id) {
        return ResponseEntity.ok(trunkService.findById(id).get());
    }
}
