package com.kloster.entity.postgres;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "my_entity")
public class MyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;

}