package com.kloster.service;

import com.kloster.entity.postgres.MyEntity;
import com.kloster.entity.postgres.OtherEntity;
import com.kloster.mapper.MyMapper;
import com.kloster.model.MyModel;
import com.kloster.repository.postgres.MyRepository;
import com.kloster.repository.postgres.OtherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyService {

    private final PropertyLoaderService propertyLoader;
    private final MyRepository repository;
    private final OtherRepository otherRepository;
    private final MyMapper mapper;

    public String getNome() {
        return propertyLoader.getNome();
    }

    public int getIdade() {
        return propertyLoader.getIdade();
    }

    public MyModel saveModel(MyModel myModel) {

       return mapper.entityToModel(repository.save(mapper.modelToEntity(myModel)));
    }

    public MyModel findByNome(String nome) {
        return mapper.entityToModel(repository.findByNome(nome));
    }

    public MyModel findById(Long id) {
        return mapper.entityToModel(repository.findById(id).orElse(null));
    }

    public List<MyModel> findAll() {
        return repository.findAll().stream()
                .map(mapper::entityToModel)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<MyModel> findAll(Pageable pageable) {
        return repository.findAll(pageable).stream().map(mapper::entityToModel).collect(Collectors.toList());
    }

    public MyModel addOtherToMy(Long myId, Long otherId) {
        MyEntity myEntity = repository.findById(myId)
                .orElseThrow(() -> new RuntimeException("MyEntity not found with id " + myId));

        OtherEntity otherEntity = otherRepository.findById(otherId)
                .orElseThrow(() -> new RuntimeException("OtherEntity not found with id " + otherId));

        myEntity.getOtherEntities().add(otherEntity);

        repository.save(myEntity);

        return mapper.entityToModel(myEntity);
    }
}
