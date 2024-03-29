package com.kloster.answer;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AnswerMapper {

    AnswerMapper INSTANCE = Mappers.getMapper(AnswerMapper.class);

    AnswerEntity modelToEntity(AnswerModel answerModel);

    AnswerModel entityToModel(AnswerEntity answerEntity);

    AnswerModel dtoToModel(AnswerDto answerDto);
}