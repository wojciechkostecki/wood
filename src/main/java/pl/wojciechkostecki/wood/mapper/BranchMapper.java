package pl.wojciechkostecki.wood.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.wojciechkostecki.wood.model.Branch;
import pl.wojciechkostecki.wood.model.dto.BranchDTO;

@Mapper(componentModel = "spring")
public interface BranchMapper extends EntityMapper<BranchDTO, Branch>{

    @Mapping(target = "trunkId", source = "trunk.id")
    @Mapping(target = "branchId", source = "branch.id")
    BranchDTO toDto(Branch branch);
}
