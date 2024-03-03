package com.kloster.service;

import com.kloster.mapper.MyMapper;
import com.kloster.model.MyModel;
import com.kloster.repository.MyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyService {

    private final PropertyLoaderService propertyLoader;
    private final MyRepository repository;
    private final MyMapper mapper;

    public String getNome() {
        return propertyLoader.getNome();
    }

    public int getIdade() {
        return propertyLoader.getIdade();
    }

    public MyModel saveModel(MyModel myModel) {
       return mapper.toMyModel(repository.save(mapper.toMyEntity(myModel)));
    }

    public MyModel findByNome(String nome) {
        return mapper.toMyModel(repository.findByNome(nome));
    }

    public MyModel findById(Long id) {
        return mapper.toMyModel(repository.findById(String.valueOf(id)).orElse(null));
    }

    public List<MyModel> findAll() {
        return repository.findAll().stream().map(mapper::toMyModel).collect(Collectors.toList());
    }
}
