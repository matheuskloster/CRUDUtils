package com.kloster.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@RequiredArgsConstructor
public class OtherModel {

    private Long id;
    private String nome;
    private String email;

}
