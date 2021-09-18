package pl.wojciechkostecki.wood.service;

import org.springframework.stereotype.Service;
import pl.wojciechkostecki.wood.exception.BadRequestException;
import pl.wojciechkostecki.wood.mapper.BranchMapper;
import pl.wojciechkostecki.wood.mapper.TrunkMapper;
import pl.wojciechkostecki.wood.model.Branch;
import pl.wojciechkostecki.wood.model.Trunk;
import pl.wojciechkostecki.wood.model.dto.BranchDTO;
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

    public BranchService(BranchRepository branchRepository, BranchMapper branchMapper,
                         TrunkMapper trunkMapper, TrunkService trunkService) {
        this.branchRepository = branchRepository;
        this.branchMapper = branchMapper;
        this.trunkMapper = trunkMapper;
        this.trunkService = trunkService;
    }


    public Optional<BranchDTO> findById(Long id) {
        return branchRepository.findById(id).map(branchMapper::toDto);
    }

    public List<BranchDTO> getAll() {
        return branchMapper.toDto(branchRepository.findAll());
    }

    public void save(BranchDTO branchDTO) {
        if ((branchDTO.getTrunkId() == null) && (branchDTO.getBranchId() == null)) {
            throw new BadRequestException("Indicate the Trunk or Branch to which this Object is to be assigned");
        }
        if ((branchDTO.getTrunkId() != null) && (branchDTO.getBranchId() != null)) {
            throw new BadRequestException("An Object cannot be assigned to a Trunk and Branch at the same time");
        }
        if ((branchDTO.getTrunkId() != null) && (branchDTO.getBranchId() == null)) {
            Branch branch = branchMapper.toEntity(branchDTO);
            Trunk trunk = trunkMapper.toEntity(trunkService.findById(branchDTO.getTrunkId())
                    .orElseThrow(() -> new EntityNotFoundException("Couldn't find a Trunk with passed id")));
            branch.setTrunk(trunk);
            trunk.getBranches().add(branch);
            branchMapper.toDto(branchRepository.save(branch));
        }
        if ((branchDTO.getTrunkId() == null) && (branchDTO.getBranchId() != null)) {
            Branch branchBelongingToBranch = branchMapper.toEntity(branchDTO);
            Branch branch = branchRepository.getById(branchDTO.getBranchId());
            branchBelongingToBranch.setBranch(branch);
            branch.getBranches().add(branchBelongingToBranch);
            branchMapper.toDto(branchRepository.save(branchBelongingToBranch));
        }
    }
}
