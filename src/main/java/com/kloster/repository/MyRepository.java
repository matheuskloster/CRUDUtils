package com.kloster.repository;

import com.kloster.entity.MyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyRepository extends MongoRepository<MyEntity, String> {

    MyEntity findByNome(String nome);
    MyEntity deleteByNome(String nome);

}
