package com.kloster.entity.postgres;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "my_entity")
public class MyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;

    @OneToMany(mappedBy = "myEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OtherEntity> otherEntities;
}