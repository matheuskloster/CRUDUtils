package com.kloster.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertyLoaderService {

    @Value("${minha.variavel.nome}")
    private String nome;

    @Value("${minha.variavel.idade}")
    private String idade;

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return Integer.parseInt(idade);
    }
}
