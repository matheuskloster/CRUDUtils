package com.kloster.mapper;

import com.kloster.dto.OtherDto;
import com.kloster.entity.postgres.OtherEntity;
import com.kloster.model.OtherModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface OtherMapper {

    OtherMapper INSTANCE = Mappers.getMapper(OtherMapper.class);

    OtherEntity modelToEntity(OtherModel otherModel);

    OtherModel entityToModel(OtherEntity otherEntity);

    OtherModel dtoToModel(OtherDto otherDto);
}