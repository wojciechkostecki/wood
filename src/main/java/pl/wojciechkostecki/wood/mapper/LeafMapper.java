package pl.wojciechkostecki.wood.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.wojciechkostecki.wood.model.Leaf;
import pl.wojciechkostecki.wood.model.dto.LeafDTO;

@Mapper(componentModel = "spring")
public interface LeafMapper extends EntityMapper<LeafDTO, Leaf>{

    @Mapping(source = "branch.id", target = "branchId")
    LeafDTO toDto(Leaf leaf);
}
