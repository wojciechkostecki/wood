package pl.wojciechkostecki.wood.service;

import org.springframework.stereotype.Service;
import pl.wojciechkostecki.wood.mapper.BranchMapper;
import pl.wojciechkostecki.wood.mapper.SmallBranchMapper;
import pl.wojciechkostecki.wood.mapper.TrunkMapper;
import pl.wojciechkostecki.wood.model.Branch;
import pl.wojciechkostecki.wood.model.Trunk;
import pl.wojciechkostecki.wood.model.dto.BranchDTO;
import pl.wojciechkostecki.wood.model.dto.SmallBranchDTO;
import pl.wojciechkostecki.wood.repository.BranchRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BranchService {
    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;
    private final TrunkMapper trunkMapper;
    private final TrunkService trunkService;
    private final SmallBranchMapper smallBranchMapper;

    public BranchService(BranchRepository branchRepository, BranchMapper branchMapper,
                         TrunkMapper trunkMapper, TrunkService trunkService, SmallBranchMapper smallBranchMapper) {
        this.branchRepository = branchRepository;
        this.branchMapper = branchMapper;
        this.trunkMapper = trunkMapper;
        this.trunkService = trunkService;
        this.smallBranchMapper = smallBranchMapper;
    }


    public Optional<BranchDTO> findById(Long id) {
        return branchRepository.findById(id).map(branchMapper::toDto);
    }

    public List<BranchDTO> getAll() {
        return branchMapper.toDto(branchRepository.findAll());
    }

    public BranchDTO saveLargeBranch(BranchDTO branchDTO) {
        Branch branch = branchMapper.toEntity(branchDTO);
        Trunk trunk = trunkMapper.toEntity(trunkService.findById(branchDTO.getTrunkId())
                .orElseThrow(() -> new EntityNotFoundException("Couldn't find a Trunk with passed id")));
        branch.setTrunk(trunk);
        trunk.getBranches().add(branch);
        return branchMapper.toDto(branchRepository.save(branch));
    }

    public SmallBranchDTO saveSmallBranch(SmallBranchDTO smallBranchDTO) {
        Branch smallBranch = smallBranchMapper.toEntity(smallBranchDTO);
        Branch branch = branchRepository.getById(smallBranchDTO.getParentBranchId());
        smallBranch.setLargeBranch(branch);
        branch.getSmallBranches().add(smallBranch);
        return smallBranchMapper.toDto(branchRepository.save(smallBranch));
    }

}
