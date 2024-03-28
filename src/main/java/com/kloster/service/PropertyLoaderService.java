package com.kloster.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertyLoaderService {

    @Getter
    @Value("${minha.variavel.nome}")
    private String nome;

    @Value("${minha.variavel.idade}")
    private String idade;

    public int getIdade() {
        return Integer.parseInt(idade);
    }
}
