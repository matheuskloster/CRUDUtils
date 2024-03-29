package com.kloster.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class MyModel {

    private Long id;
    private String nome;
    private int idade;
    private List<OtherModel> otherModels;


}
