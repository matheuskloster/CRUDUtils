package com.kloster.service;

import com.kloster.mapper.MyMapper;
import com.kloster.model.MyModel;
import com.kloster.repository.postgres.MyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return mapper.toMyModel(repository.findById(id).orElse(null));
    }

    public List<MyModel> findAll() {
        return repository.findAll().stream().map(mapper::toMyModel).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<MyModel> findAll(Pageable pageable) {
        return repository.findAll(pageable).stream().map(mapper::toMyModel).collect(Collectors.toList());
    }

}
