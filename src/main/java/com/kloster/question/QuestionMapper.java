package com.kloster.question;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionMapper INSTANCE = Mappers.getMapper(QuestionMapper.class);

    QuestionEntity modelToEntity(QuestionModel questionModel);

    QuestionModel dtoToModel(QuestionDto questionDto);


    QuestionModel entityToModel(QuestionEntity questionEntity);
}