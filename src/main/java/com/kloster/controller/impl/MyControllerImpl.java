package com.kloster.controller.impl;

import com.kloster.controller.MyController;
import com.kloster.dto.MyDto;
import com.kloster.model.MyModel;
import com.kloster.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyControllerImpl implements MyController {

    private final MyService service;

    @Override
    @PostMapping
    public MyModel create(@RequestBody MyDto myDto) {
        MyModel myModel = MyModel.builder().nome(myDto.getNome()).idade(myDto.getIdade()).build();
        return service.save(myModel);
    }

    @Override
    @GetMapping
    public List<MyModel> getAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/nome")
    public MyModel getByNome(@RequestParam String nome) {
        return service.findByNome(nome);
    }

    @Override
    @DeleteMapping("/nome")
    public MyModel deleteByNome(@RequestParam String nome) {
        return service.deleteByNome(nome);
    }
    @Override
    @DeleteMapping
    public void delete(@RequestBody MyModel myModel) {
         service.delete(myModel);
    }

    @Override
    @PutMapping
    public MyModel update(@RequestBody MyModel myModel) {
        return service.update(myModel);
    }
}
