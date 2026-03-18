package auto.trace.mapper;

import auto.trace.dto.ModelDto;
import auto.trace.entity.Model;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModelMapper {
    List<ModelDto> toResponseList(List<Model> models);
}
