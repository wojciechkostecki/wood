package pl.wojciechkostecki.wood.model.dto;

import lombok.Data;
import pl.wojciechkostecki.wood.model.TypeLeaf;

import javax.validation.constraints.NotNull;

@Data
public class LeafDTO {

    private TypeLeaf typeLeaf;

    @NotNull(message = "Length is mandatory")
    private Double lengthInMm;

    @NotNull(message = "Width is mandatory")
    private Double widthInMm;

    @NotNull(message = "Branch ID is mandatory")
    private Long branchId;

}
