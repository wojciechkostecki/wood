package pl.wojciechkostecki.wood.model.dto;

import lombok.Data;

@Data
public class BranchDTO {

    private Double lengthInCm;

    private Long trunkId;

    private Long parentBranchId;

}
