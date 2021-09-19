package pl.wojciechkostecki.wood.model.dto;

import lombok.Data;
import pl.wojciechkostecki.wood.model.Branch;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class TrunkDTO {
    private Long id;

    @NotNull(message = "Height is mandatory")
    private Double heightInCm;

    @NotNull(message = "Width is mandatory")
    private Double widthInCm;

    @NotNull(message = "Tree ID is mandatory")
    private Long treeId;

    private List<Branch> branches = new ArrayList<>();

}
