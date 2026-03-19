package auto.trace.mapper;

import auto.trace.dto.response.ModelResponse;
import auto.trace.entity.Model;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModelMapper {
    List<ModelResponse> toResponseList(List<Model> models);
}
