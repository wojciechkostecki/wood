package pl.wojciechkostecki.wood.model.dto;

import lombok.Data;
import pl.wojciechkostecki.wood.model.Leaf;

import java.util.ArrayList;
import java.util.List;

@Data
public class SmallBranchDTO {
    private Long id;

    private Double lengthInCm;

    private Long parentBranchId;

    private List<Leaf> leaves = new ArrayList<>();
}
