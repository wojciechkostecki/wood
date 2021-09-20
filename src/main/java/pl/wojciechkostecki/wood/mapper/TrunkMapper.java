package pl.wojciechkostecki.wood.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.wojciechkostecki.wood.model.Trunk;
import pl.wojciechkostecki.wood.model.dto.TrunkDTO;

@Mapper(componentModel = "spring")
public interface TrunkMapper extends EntityMapper<TrunkDTO, Trunk>{

    @Mapping(source = "tree.id", target = "treeId")
    TrunkDTO toDto(Trunk trunk);
}
