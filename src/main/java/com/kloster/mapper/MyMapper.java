package com.kloster.mapper;

import com.kloster.dto.MyDto;
import com.kloster.entity.postgres.MyEntity;
import com.kloster.model.MyModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface MyMapper {

    MyMapper INSTANCE = Mappers.getMapper(MyMapper.class);

    MyEntity toMyEntity(MyModel myModel);

    MyModel toMyModel(MyEntity myEntity);

    MyModel dtoToModel(MyDto myDto);
}