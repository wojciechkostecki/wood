package pl.wojciechkostecki.wood.service;

import org.springframework.stereotype.Service;
import pl.wojciechkostecki.wood.mapper.TreeMapper;
import pl.wojciechkostecki.wood.model.Tree;
import pl.wojciechkostecki.wood.model.dto.TreeDTO;
import pl.wojciechkostecki.wood.repository.TreeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TreeService {
    private final TreeRepository treeRepository;
    private final TreeMapper treeMapper;

    public TreeService(TreeRepository treeRepository, TreeMapper treeMapper) {
        this.treeRepository = treeRepository;
        this.treeMapper = treeMapper;
    }

    public TreeDTO save(TreeDTO treeDTO) {
        Tree tree = treeMapper.toEntity(treeDTO);
        return treeMapper.toDto(treeRepository.save(tree));
    }

    public List<TreeDTO> getAll() {
        return treeMapper.toDto(treeRepository.findAll());
    }

    public Optional<TreeDTO> findById(Long id) {
        return treeRepository.findById(id).map(treeMapper::toDto);
    }
}
