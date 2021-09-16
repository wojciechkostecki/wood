package pl.wojciechkostecki.wood.mapper;

import org.mapstruct.Mapper;
import pl.wojciechkostecki.wood.model.Tree;
import pl.wojciechkostecki.wood.model.dto.TreeDTO;

@Mapper(componentModel = "spring")
public interface TreeMapper extends EntityMapper<TreeDTO, Tree>{
}
