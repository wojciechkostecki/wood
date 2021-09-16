package pl.wojciechkostecki.wood.mapper;

import org.mapstruct.Mapper;
import pl.wojciechkostecki.wood.model.Branch;
import pl.wojciechkostecki.wood.model.dto.BranchDTO;

@Mapper(componentModel = "spring")
public interface BranchMapper extends EntityMapper<BranchDTO, Branch>{
}
