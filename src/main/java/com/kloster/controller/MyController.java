package com.kloster.controller;

import com.kloster.dto.MyDto;
import com.kloster.model.MyModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface MyController {
    @PostMapping
    MyModel create(@RequestBody MyDto myDto);

    @GetMapping
    List<MyModel> getAll();

    @GetMapping("/nome")
    MyModel getByNome(@RequestParam String nome);

    @DeleteMapping("/nome")
    MyModel deleteByNome(@RequestParam String nome);

    @DeleteMapping
    void delete(@RequestBody MyModel myModel);

    @PutMapping
    MyModel update(@RequestBody MyModel myModel);
}
