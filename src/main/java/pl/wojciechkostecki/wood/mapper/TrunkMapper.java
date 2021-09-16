package pl.wojciechkostecki.wood.mapper;

import org.mapstruct.Mapper;
import pl.wojciechkostecki.wood.model.Trunk;
import pl.wojciechkostecki.wood.model.dto.TrunkDTO;

@Mapper(componentModel = "spring")
public interface TrunkMapper extends EntityMapper<TrunkDTO, Trunk>{
}
