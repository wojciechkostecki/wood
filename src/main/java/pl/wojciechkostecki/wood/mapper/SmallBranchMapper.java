package pl.wojciechkostecki.wood.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.wojciechkostecki.wood.model.Branch;
import pl.wojciechkostecki.wood.model.dto.SmallBranchDTO;

@Mapper(componentModel = "spring")
public interface SmallBranchMapper extends EntityMapper<SmallBranchDTO, Branch>{

    @Mapping(target = "parentBranchId", source = "largeBranch.id")
    SmallBranchDTO toDto(Branch branch);
}
