package com.kloster.answer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private AnswerService otherDtoService;

    @Autowired
    private AnswerMapper mapper;

    @GetMapping
    public List<AnswerModel> getAll() {
        return otherDtoService.getAll();
    }

    @GetMapping("/{id}")
    public AnswerModel getById(@PathVariable Long id) {
        return otherDtoService.getById(id);
    }

    @PostMapping
    public AnswerModel create(@RequestParam(value = "questionId") Long questionId, @RequestBody AnswerDto answerDto) {
        return otherDtoService.create(mapper.dtoToModel(answerDto), questionId);
    }

    @PutMapping("/{id}")
    public AnswerModel update(@PathVariable Long id, @RequestBody AnswerDto answerDto) {
        return otherDtoService.update(id, mapper.dtoToModel(answerDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        otherDtoService.delete(id);
    }
}