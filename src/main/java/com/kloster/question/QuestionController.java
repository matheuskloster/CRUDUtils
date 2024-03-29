package com.kloster.question;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
@Api(value = "QuestionController", description = "Operações disponíveis em QuestionController")
public class QuestionController {

    private final QuestionService service;
    private final QuestionMapper mapper;

    @PostMapping
    @ApiOperation(value = "Fazer pergunta", response = QuestionModel.class)
    public QuestionModel questionSaveEndpoint(@ApiParam(value = "Objeto Question que precisa ser salvo", required = true) @RequestBody QuestionDto questionDto) {
        return service.saveModel(mapper.dtoToModel(questionDto));
    }

    @DeleteMapping
    @ApiOperation(value = "Deletar pergunta por ID", response = QuestionModel.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Objeto Question deletado"), @ApiResponse(code = 404, message = "Não foi encontrado nenhum objeto Question com o ID fornecido")})
    public void questionDeleteByIdEndpoint(@ApiParam(value = "ID do objeto Question que precisa ser deletado", required = true) @RequestParam Long id) {
        service.deleteById(id);
    }

    @PutMapping
    @ApiOperation(value = "Atualiza uma Pergunta por ID", response = QuestionModel.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Objeto Question atualizado"), @ApiResponse(code = 404, message = "Não foi encontrado nenhum objeto Question com o ID fornecido")})
    public QuestionModel questionUpdateByIdEndpoint(@ApiParam(value = "ID do objeto Question que precisa ser atualizado", required = true) @RequestParam Long id, @ApiParam(value = "Objeto Question que precisa ser atualizado", required = true) @RequestBody QuestionDto questionDto) {

        return service.update(id, mapper.dtoToModel(questionDto));

    }


    @GetMapping
    @ApiOperation(value = "Retorna todas as perguntas", response = QuestionModel.class, responseContainer = "List")
    public List<QuestionModel> questionGetAllEndpoint() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna uma pergunta por ID", response = QuestionModel.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Objeto Question encontrado"), @ApiResponse(code = 404, message = "Não foi encontrado nenhum objeto Question com o ID fornecido")})
    public QuestionModel questionGetByIdEndpoint(@ApiParam(value = "ID do objeto Question que precisa ser obtido", required = true) @PathVariable Long id) {
        return service.findById(id);
    }
    
    //paginado
    @GetMapping("/paginado")
    @ApiOperation(value = "Retorna perguntas paginadas", response = QuestionModel.class, responseContainer = "List")
    public List<QuestionModel> questionGetAllPaginadoEndpoint(@ApiParam(value = "Número da página", required = true) @RequestParam int page, @ApiParam(value = "Número de elementos por página", required = true) @RequestParam int size) {
        return service.findAll(PageRequest.of(page, size));
    }
}