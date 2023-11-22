package com.kloster.controller;

import com.kloster.model.MyModel;
import com.kloster.service.MyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyController {

    private final MyService service;

    @GetMapping()
    public MyModel myEndpoint() {
        MyModel myModel = new MyModel();
        myModel.setAge(service.getIdade());
        myModel.setName(service.getNome());
        return myModel;
    }
}
