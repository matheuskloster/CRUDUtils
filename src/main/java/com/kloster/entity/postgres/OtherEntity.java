package com.kloster.entity.postgres;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "other_entity")
public class OtherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_entity_id")
    private MyEntity myEntity;
}