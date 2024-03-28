package com.kloster.controller;


import com.kloster.dto.OtherDto;
import com.kloster.mapper.OtherMapper;
import com.kloster.model.OtherModel;
import com.kloster.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/otherDto")
public class OtherController {

    @Autowired
    private OtherService otherDtoService;

    @Autowired
    private OtherMapper mapper;

    @GetMapping
    public List<OtherModel> getAll() {
        return otherDtoService.getAll();
    }

    @GetMapping("/{id}")
    public OtherModel getById(@PathVariable Long id) {
        return otherDtoService.getById(id);
    }

    @PostMapping
    public OtherModel create(@RequestBody OtherDto otherDto) {
        return otherDtoService.create(mapper.dtoToModel(otherDto));
    }

    @PutMapping
    public OtherModel update(@RequestBody OtherDto otherDto) {
        return otherDtoService.update(mapper.dtoToModel(otherDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        otherDtoService.delete(id);
    }
}