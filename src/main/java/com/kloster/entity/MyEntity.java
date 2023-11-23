package com.kloster.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "my_entity")
@Data
public class MyEntity {

    @Id
    private String id;
    private String nome;
    private int idade;

}

