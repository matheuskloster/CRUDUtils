package com.kloster.service;

import com.kloster.mapper.MyMapper;
import com.kloster.mapper.MyMapperImpl;
import com.kloster.model.MyModel;
import com.kloster.repository.MyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
