package com.kloster.controller;

import com.kloster.model.MyModel;
import com.kloster.service.MyService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myModel")
@RequiredArgsConstructor
@Api(value = "MyController", description = "Operações disponíveis em MyController")
public class MyController {

    private final MyService service;

    @GetMapping("/static")
    @ApiOperation(value = "Retorna um MyModel", response = MyModel.class)
    public MyModel myEndpoint() {
        MyModel myModel = new MyModel();
        myModel.setIdade(service.getIdade());
        myModel.setNome(service.getNome());
        return myModel;
    }

    @PostMapping
    @ApiOperation(value = "Salva um MyModel e retorna o objeto salvo", response = MyModel.class)
    public MyModel mySaveEndpoint(@ApiParam(value = "Objeto MyModel que precisa ser salvo", required = true) @RequestBody MyModel myModel) {
        return service.saveModel(myModel);
    }


    @GetMapping
    @ApiOperation(value = "Retorna todos os MyModel", response = MyModel.class, responseContainer = "List")
    public List<MyModel> myGetAllEndpoint() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um MyModel com base no ID fornecido", response = MyModel.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Objeto MyModel encontrado"),
        @ApiResponse(code = 404, message = "Não foi encontrado nenhum objeto MyModel com o ID fornecido")
    })
    public MyModel myGetByIdEndpoint(@ApiParam(value = "ID do objeto MyModel que precisa ser obtido", required = true) @PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/name")
    @ApiOperation(value = "Retorna um MyModel com base no nome fornecido", response = MyModel.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Objeto MyModel encontrado"),
        @ApiResponse(code = 404, message = "Não foi encontrado nenhum objeto MyModel com o nome fornecido")
    })
    public MyModel myGetByNomeEndpoint(@ApiParam(value = "Nome do objeto MyModel que precisa ser obtido", required = true) @RequestParam String nome) {
        return service.findByNome(nome);
    }
}