package pl.wojciechkostecki.wood.service;

import org.springframework.stereotype.Service;
import pl.wojciechkostecki.wood.mapper.BranchMapper;
import pl.wojciechkostecki.wood.mapper.LeafMapper;
import pl.wojciechkostecki.wood.model.Branch;
import pl.wojciechkostecki.wood.model.Leaf;
import pl.wojciechkostecki.wood.model.dto.LeafDTO;
import pl.wojciechkostecki.wood.repository.LeafRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LeafService {
    private  final LeafRepository leafRepository;
    private final LeafMapper leafMapper;
    private final BranchService branchService;
    private final BranchMapper branchMapper;

    public LeafService(LeafRepository leafRepository, LeafMapper leafMapper,
                       BranchService branchService, BranchMapper branchMapper) {
        this.leafRepository = leafRepository;
        this.leafMapper = leafMapper;
        this.branchService = branchService;
        this.branchMapper = branchMapper;
    }

    public LeafDTO save(LeafDTO leafDTO) {
        Leaf leaf = leafMapper.toEntity(leafDTO);
        Branch branch = branchMapper.toEntity(branchService.findById(leafDTO.getBranchId())
                .orElseThrow(() -> new EntityNotFoundException("Couldn't find a Branch with passed id")));
        leaf.setBranch(branch);
        branch.getLeaves().add(leaf);
        return leafMapper.toDto(leafRepository.save(leaf));
    }

    public List<LeafDTO> getAll() {
        return leafMapper.toDto(leafRepository.findAll());
    }
}
