package pl.wojciechkostecki.wood.model.dto;

import lombok.Data;
import pl.wojciechkostecki.wood.model.Branch;

import java.util.ArrayList;
import java.util.List;

@Data
public class TrunkDTO {
    private Long id;

    private Double heightInCm;

    private Double widthInCm;

    private Long treeId;

    private List<Branch> branches = new ArrayList<>();

}
