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

    public Optional<Tree> findById(Long id) {
        return treeRepository.findById(id);
    }

    public void growTree(Long id) {
        Tree tree = treeRepository.getById(id);

        if(tree.getAgeInYears()<= 3) {
            grow(tree, 1.5,1.5,1.2);
        }

        if(tree.getAgeInYears() > 3 && tree.getAgeInYears() <= 8) {
            grow(tree, 1.4,1.35,1.15);
        }

        if(tree.getAgeInYears() > 8 && tree.getAgeInYears() <= 20) {
            grow(tree, 1.2,1.1,1.1);
        }

    }

    public void grow(Tree tree, double growthFactorOfTrunk, double growthFactorOfBranch, double growthFactorOfLeaf) {
        tree.getTrunk().grow(growthFactorOfTrunk);
        tree.getTrunk().getBranches().forEach(b->b.grow(growthFactorOfBranch));
        tree.getTrunk().getBranches().forEach(b->b.getBranches().forEach(e->e.grow(growthFactorOfBranch)));
        tree.getTrunk().getBranches().forEach(b->b.getLeaves().forEach(l->l.grow(growthFactorOfLeaf)));
        tree.getTrunk().getBranches().forEach(b->b.getBranches().forEach(e->e.getLeaves().forEach(l->l.grow(growthFactorOfLeaf))));
        treeRepository.save(tree);
    }
}
