package com.kloster.service;

import com.kloster.entity.MyEntity;
import com.kloster.mapper.MyMapper;
import com.kloster.model.MyModel;
import com.kloster.repository.MyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public MyModel save(MyModel myModel) {
       return mapper.toMyModel(repository.save(mapper.toMyEntity(myModel)));
    }

    public MyModel findById(String id) {
        return mapper.toMyModel(repository.findById(id).orElseThrow(() -> new RuntimeException("Não foi possível encontrar pelo id")));
    }

    public List<MyModel> findAll() {
        return mapper.toMyModelList(repository.findAll());
    }
    public MyModel findByNome(String nome) {
        return mapper.toMyModel(repository.findByNome(nome));
    }

    public MyModel deleteByNome(String nome) {
        return mapper.toMyModel(repository.deleteByNome(nome));
    }

    public void delete(MyModel myModel) {
        MyEntity myEntity = mapper.toMyEntity(myModel);
        repository.delete(myEntity);
    }

    public MyModel update(MyModel myModel) {
            var response = this.findById(myModel.getId());
            if (response != null) {
                return this.save(myModel);
            }
            return null;
        }
}
