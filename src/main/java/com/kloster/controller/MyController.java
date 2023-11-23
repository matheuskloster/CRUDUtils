package com.kloster.controller;

import com.kloster.model.MyModel;
import com.kloster.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyController {

    private final MyService service;

    @GetMapping()
    public MyModel myEndpoint() {
        MyModel myModel = new MyModel();
        myModel.setIdade(service.getIdade());
        myModel.setNome(service.getNome());
        return myModel;
    }

    @PostMapping("/save")
    public MyModel mySaveEndpoint(@RequestBody MyModel myModel) {
        return service.saveModel(myModel);
    }

    @GetMapping("/get")
    public MyModel myGetByNomeEndpoint(@RequestParam String nome) {
        return service.findByNome(nome);
    }
}
