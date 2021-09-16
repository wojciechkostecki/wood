package pl.wojciechkostecki.wood.model.dto;

import lombok.Data;
import pl.wojciechkostecki.wood.model.TypeLeaf;

@Data
public class LeafDTO {

    private TypeLeaf typeLeaf;

    private Double lengthInMm;

    private Double widthInMm;

    private Long branchId;

}
