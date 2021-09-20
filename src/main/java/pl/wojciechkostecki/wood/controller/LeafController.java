package pl.wojciechkostecki.wood.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wojciechkostecki.wood.model.dto.LeafDTO;
import pl.wojciechkostecki.wood.service.LeafService;

import java.util.List;

@RestController
@RequestMapping("api/leaves")
public class LeafController {
    private final LeafService leafService;

    public LeafController(LeafService leafService) {
        this.leafService = leafService;
    }

    @PostMapping
    public ResponseEntity<LeafDTO> createLeaf(@RequestBody LeafDTO leafDTO) {
        LeafDTO savedLeaf = leafService.save(leafDTO);
        return new ResponseEntity<>(savedLeaf, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LeafDTO>> getAllLeaves() {
        return ResponseEntity.ok(leafService.getAll());
    }
}
