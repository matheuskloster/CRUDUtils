package com.kloster.answer;

import com.kloster.question.QuestionEntity;
import com.kloster.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerService {


    private final AnswerRepository repository;
    private final QuestionRepository questionRepository;
    private final AnswerMapper mapper;

    public List<AnswerModel> getAll() {
        return repository.findAll().stream().map(mapper::entityToModel).collect(Collectors.toList());
    }

    public AnswerModel getById(Long id) {
        return mapper.entityToModel(repository.findById(id).orElse(null));
    }

    public AnswerModel create(AnswerModel answerModel, Long id) {

        QuestionEntity questionEntity = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found with id " + id));


        AnswerEntity answerEntity = mapper.modelToEntity(answerModel);

        answerEntity.setQuestionEntity(questionEntity);
        return mapper.entityToModel(repository.save(answerEntity));
    }

    public AnswerModel update(Long id, AnswerModel answerModel) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Answer not found with id " + id));

        entity.setUsername(answerModel.getUsername());
        entity.setTexto(answerModel.getTexto());

        return mapper.entityToModel(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}