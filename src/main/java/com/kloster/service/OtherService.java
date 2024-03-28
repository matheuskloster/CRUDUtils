package com.kloster.service;

import com.kloster.mapper.OtherMapper;
import com.kloster.model.OtherModel;

import com.kloster.repository.postgres.OtherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OtherService {


    private final OtherRepository repository;
    private final OtherMapper mapper;

    public List<OtherModel> getAll() {
        return repository.findAll().stream().map(mapper::entityToModel).collect(Collectors.toList());
    }

    public OtherModel getById(Long id) {
        return mapper.entityToModel(repository.findById(id).orElse(null));
    }

    public OtherModel create(OtherModel otherModel) {
        return mapper.entityToModel(repository.save(mapper.modelToEntity(otherModel)));
    }

    public OtherModel update(OtherModel otherModel) {
        return mapper.entityToModel(repository.save(mapper.modelToEntity(otherModel)));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}