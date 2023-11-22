package com.kloster.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyLoader {

    @Value("${minha.variavel.nome}")
    private String nome;

    public String getNome() {
        return nome;
    }
}
