package pl.wojciechkostecki.wood.mapper;

import org.mapstruct.Mapper;
import pl.wojciechkostecki.wood.model.Leaf;
import pl.wojciechkostecki.wood.model.dto.LeafDTO;

@Mapper(componentModel = "spring")
public interface LeafMapper extends EntityMapper<LeafDTO, Leaf>{
}
