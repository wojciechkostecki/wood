package pl.wojciechkostecki.wood.model.dto;

import lombok.Data;
import pl.wojciechkostecki.wood.model.Branch;
import pl.wojciechkostecki.wood.model.Leaf;

import java.util.ArrayList;
import java.util.List;

@Data
public class BranchDTO {

    private Long id;

    private Double lengthInCm;

    private Long trunkId;

    private Long branchId;

    private List<Branch> branches;

    private List<Leaf> leaves = new ArrayList<>();

}
