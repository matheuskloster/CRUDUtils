package com.kloster.question;

import com.kloster.answer.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository repository;
    private final AnswerRepository answerRepository;
    private final QuestionMapper mapper;


    public QuestionModel saveModel(QuestionModel questionModel) {

       return mapper.entityToModel(repository.save(mapper.modelToEntity(questionModel)));
    }
    public QuestionModel findById(Long id) {
        return mapper.entityToModel(repository.findById(id).orElse(null));
    }

    public List<QuestionModel> findAll() {
        return repository.findAll().stream()
                .map(mapper::entityToModel)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<QuestionModel> findAll(Pageable pageable) {
        return repository.findAll(pageable).stream().map(mapper::entityToModel).collect(Collectors.toList());
    }

    public QuestionModel update(Long id, QuestionModel questionModel) {

        var model = findById(id);
        if (model == null) {
            throw new RuntimeException("Question not found with id " + questionModel.getId());
        }
        model.setTexto(questionModel.getTexto());
        model.setUsername(questionModel.getUsername());

        return mapper.entityToModel(repository.save(mapper.modelToEntity(model)));
    }


}
