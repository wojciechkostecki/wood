package pl.wojciechkostecki.wood.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wojciechkostecki.wood.model.dto.BranchDTO;
import pl.wojciechkostecki.wood.service.BranchService;

import java.util.List;

@RestController
@RequestMapping("api/branches")
public class BranchController {
    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping
    public ResponseEntity<List<BranchDTO>> getAllBranches(){
        return ResponseEntity.ok(branchService.getAll());
    }

    @PostMapping
    public ResponseEntity<Void> createBranch(@RequestBody BranchDTO branchDTO) {
        branchService.save(branchDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
