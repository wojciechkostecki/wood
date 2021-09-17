package pl.wojciechkostecki.wood.service;

import org.springframework.stereotype.Service;
import pl.wojciechkostecki.wood.exception.BadRequestException;
import pl.wojciechkostecki.wood.mapper.TreeMapper;
import pl.wojciechkostecki.wood.mapper.TrunkMapper;
import pl.wojciechkostecki.wood.model.Tree;
import pl.wojciechkostecki.wood.model.Trunk;
import pl.wojciechkostecki.wood.model.dto.TrunkDTO;
import pl.wojciechkostecki.wood.repository.TrunkRepository;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class TrunkService {
    private final TrunkRepository trunkRepository;
    private final TrunkMapper trunkMapper;
    private final TreeService treeService;
    private final TreeMapper treeMapper;

    public TrunkService(TrunkRepository trunkRepository, TrunkMapper trunkMapper, TreeService treeService, TreeMapper treeMapper) {
        this.trunkRepository = trunkRepository;
        this.trunkMapper = trunkMapper;
        this.treeService = treeService;
        this.treeMapper = treeMapper;
    }


    public TrunkDTO save(TrunkDTO trunkDTO) {
        Trunk trunk = trunkMapper.toEntity(trunkDTO);
        Tree tree = treeService.findById(trunkDTO.getTreeId())
                .orElseThrow(() -> new EntityNotFoundException("Couldn't find a Tree with passed id"));
        if (Objects.nonNull((tree.getTrunk()))) {
            throw new BadRequestException("Trunk is already assigned to tree");
        } else {
        trunk.setTree(tree);
        tree.setTrunk(trunk);
        return trunkMapper.toDto(trunkRepository.save(trunk));
    }}

    public List<TrunkDTO> getAll() {
        return trunkMapper.toDto(trunkRepository.findAll());
    }

    public Optional<TrunkDTO> findById(Long id) {
        return trunkRepository.findById(id).map(trunkMapper::toDto);
    }

}
