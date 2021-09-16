package pl.wojciechkostecki.wood.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wojciechkostecki.wood.model.dto.TreeDTO;
import pl.wojciechkostecki.wood.service.TreeService;

import java.util.List;

@RestController
@RequestMapping("api/trees")
public class TreeController {
    private final TreeService treeService;

    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @PostMapping
    public ResponseEntity<TreeDTO> createTree(@RequestBody TreeDTO treeDTO) {
        TreeDTO savedTree = treeService.save(treeDTO);
        return new ResponseEntity<>(savedTree, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TreeDTO>> getAllTrees() {
        return ResponseEntity.ok(treeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreeDTO> getTree(@PathVariable Long id) {
        return ResponseEntity.ok(treeService.findById(id).get());
    }
}
